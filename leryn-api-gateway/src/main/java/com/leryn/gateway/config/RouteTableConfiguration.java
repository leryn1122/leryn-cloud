package com.leryn.gateway.config;

import java.util.List;
import javax.annotation.Resource;

import com.leryn.gateway.data.Tables;
import com.leryn.gateway.data.tables.pojos.RouterTable;
import com.leryn.gateway.util.SpringContextHolder;

import org.jooq.DSLContext;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
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
    List<RouterTable> routerTables = dsl.select(Tables.ROUTER_TABLE.fields())
      .from(Tables.ROUTER_TABLE)
      .where(Tables.ROUTER_TABLE.PROFILE.in(SpringContextHolder.getProfiles()))
      .fetchInto(RouterTable.class);
    Assert.isTrue(!CollectionUtils.isEmpty(routerTables),
      () -> "Route table contains at least one rules.");

    Builder routeBuilder = builder.routes();

    for (RouterTable routerTable : routerTables) {
      routeBuilder
        .route(routerTable.getRouterId(),
          r -> r.path(routerTable.getUrlPrefix())
            .filters(f -> routerTable.getRewrite() ? rewriteUriSpec(f, routerTable) : f)
            .uri(routerTable.getRouteHost())
        );
    }
    return routeBuilder.build();
  }

  private GatewayFilterSpec rewriteUriSpec(GatewayFilterSpec filter, RouterTable route) {
    return filter.rewritePath(route.getRewriteRegexp(), route.getRewriteTarget());
  }
}
