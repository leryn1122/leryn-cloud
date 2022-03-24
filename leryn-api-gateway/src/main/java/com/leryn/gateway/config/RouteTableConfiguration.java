package com.leryn.gateway.config;

import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;

import com.leryn.gateway.data.Tables;
import com.leryn.gateway.data.tables.pojos.RouterTable;
import com.leryn.gateway.data.tables.pojos.ServiceDiscovery;
import com.leryn.gateway.util.SpringContextHolder;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Configuration
public class RouteTableConfiguration {

  @Resource
  private DSLContext dsl;

  /**
   * 根据数据库配置的路由表来分配路由
   * <ul>
   *   <li>只支持 URL 中的路径来使用不同的转发规则, 不支持其他转发规则.</li>
   *   <li>推荐使用重写路径.</li>
   * </ul>
   */
  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    Map<Record, Result<Record>> routes = dsl
      .select(Tables.SERVICE_DISCOVERY.fields())
      .select(Tables.ROUTER_TABLE.fields())
      .from(Tables.ROUTER_TABLE)
      .leftJoin(Tables.SERVICE_DISCOVERY)
      .on(Tables.SERVICE_DISCOVERY.SERVICE.eq(Tables.ROUTER_TABLE.SERVICE))
      .where(Tables.SERVICE_DISCOVERY.PROFILE.in(SpringContextHolder.getProfiles()))
      .fetchGroups(
        Tables.ROUTER_TABLE.fields(),
        Tables.SERVICE_DISCOVERY.fields()
      );
    Assert.isTrue(!CollectionUtils.isEmpty(routes),
      () -> "Route table contains at least one rules.");

    Builder routeBuilder = builder.routes();

    for (Entry<Record, Result<Record>> route : routes.entrySet()) {
      RouterTable routerTable = route.getKey().into(RouterTable.class);
      ServiceDiscovery serviceDiscovery = route.getValue().into(ServiceDiscovery.class).get(0);
      routeBuilder.route(routerTable.getRouterId(),
          r -> r.path(routerTable.getUrlPrefix())
            .filters(f -> routerTable.getRewrite() ? rewriteUriSpec(f, routerTable) : f)
            .uri(serviceDiscovery.getHost())
      );
    }
    return routeBuilder.build();
  }

  private GatewayFilterSpec rewriteUriSpec(GatewayFilterSpec filter, RouterTable route) {
    return filter.rewritePath(route.getRewriteRegexp(), route.getRewriteTarget());
  }
}
