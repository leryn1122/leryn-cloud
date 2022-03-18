/*
 * This file is generated by jOOQ.
 */
package com.leryn.gateway.data.tables.records;


import com.leryn.gateway.data.tables.RouterTable;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 路由表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RouterTableRecord extends UpdatableRecordImpl<RouterTableRecord> implements Record9<Integer, String, String, String, Boolean, String, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>gateway.router_table.id</code>. 代理主键
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>gateway.router_table.id</code>. 代理主键
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>gateway.router_table.router_id</code>. 路由ID
     */
    public void setRouterId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>gateway.router_table.router_id</code>. 路由ID
     */
    public String getRouterId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>gateway.router_table.url_prefix</code>. URL前缀
     */
    public void setUrlPrefix(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>gateway.router_table.url_prefix</code>. URL前缀
     */
    public String getUrlPrefix() {
        return (String) get(2);
    }

    /**
     * Setter for <code>gateway.router_table.route_host</code>. 路由地址
     */
    public void setRouteHost(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>gateway.router_table.route_host</code>. 路由地址
     */
    public String getRouteHost() {
        return (String) get(3);
    }

    /**
     * Setter for <code>gateway.router_table.rewrite</code>. 是否重写URL路径
     */
    public void setRewrite(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>gateway.router_table.rewrite</code>. 是否重写URL路径
     */
    public Boolean getRewrite() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>gateway.router_table.rewrite_regexp</code>. 重写表达式
     */
    public void setRewriteRegexp(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>gateway.router_table.rewrite_regexp</code>. 重写表达式
     */
    public String getRewriteRegexp() {
        return (String) get(5);
    }

    /**
     * Setter for <code>gateway.router_table.rewrite_target</code>. 重写表达式
     */
    public void setRewriteTarget(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>gateway.router_table.rewrite_target</code>. 重写表达式
     */
    public String getRewriteTarget() {
        return (String) get(6);
    }

    /**
     * Setter for <code>gateway.router_table.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>gateway.router_table.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>gateway.router_table.modified_time</code>. 修改时间
     */
    public void setModifiedTime(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>gateway.router_table.modified_time</code>. 修改时间
     */
    public LocalDateTime getModifiedTime() {
        return (LocalDateTime) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, String, String, Boolean, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, String, String, String, Boolean, String, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RouterTable.ROUTER_TABLE.ID;
    }

    @Override
    public Field<String> field2() {
        return RouterTable.ROUTER_TABLE.ROUTER_ID;
    }

    @Override
    public Field<String> field3() {
        return RouterTable.ROUTER_TABLE.URL_PREFIX;
    }

    @Override
    public Field<String> field4() {
        return RouterTable.ROUTER_TABLE.ROUTE_HOST;
    }

    @Override
    public Field<Boolean> field5() {
        return RouterTable.ROUTER_TABLE.REWRITE;
    }

    @Override
    public Field<String> field6() {
        return RouterTable.ROUTER_TABLE.REWRITE_REGEXP;
    }

    @Override
    public Field<String> field7() {
        return RouterTable.ROUTER_TABLE.REWRITE_TARGET;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return RouterTable.ROUTER_TABLE.CREATE_TIME;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return RouterTable.ROUTER_TABLE.MODIFIED_TIME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getRouterId();
    }

    @Override
    public String component3() {
        return getUrlPrefix();
    }

    @Override
    public String component4() {
        return getRouteHost();
    }

    @Override
    public Boolean component5() {
        return getRewrite();
    }

    @Override
    public String component6() {
        return getRewriteRegexp();
    }

    @Override
    public String component7() {
        return getRewriteTarget();
    }

    @Override
    public LocalDateTime component8() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime component9() {
        return getModifiedTime();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getRouterId();
    }

    @Override
    public String value3() {
        return getUrlPrefix();
    }

    @Override
    public String value4() {
        return getRouteHost();
    }

    @Override
    public Boolean value5() {
        return getRewrite();
    }

    @Override
    public String value6() {
        return getRewriteRegexp();
    }

    @Override
    public String value7() {
        return getRewriteTarget();
    }

    @Override
    public LocalDateTime value8() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime value9() {
        return getModifiedTime();
    }

    @Override
    public RouterTableRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public RouterTableRecord value2(String value) {
        setRouterId(value);
        return this;
    }

    @Override
    public RouterTableRecord value3(String value) {
        setUrlPrefix(value);
        return this;
    }

    @Override
    public RouterTableRecord value4(String value) {
        setRouteHost(value);
        return this;
    }

    @Override
    public RouterTableRecord value5(Boolean value) {
        setRewrite(value);
        return this;
    }

    @Override
    public RouterTableRecord value6(String value) {
        setRewriteRegexp(value);
        return this;
    }

    @Override
    public RouterTableRecord value7(String value) {
        setRewriteTarget(value);
        return this;
    }

    @Override
    public RouterTableRecord value8(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public RouterTableRecord value9(LocalDateTime value) {
        setModifiedTime(value);
        return this;
    }

    @Override
    public RouterTableRecord values(Integer value1, String value2, String value3, String value4, Boolean value5, String value6, String value7, LocalDateTime value8, LocalDateTime value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RouterTableRecord
     */
    public RouterTableRecord() {
        super(RouterTable.ROUTER_TABLE);
    }

    /**
     * Create a detached, initialised RouterTableRecord
     */
    public RouterTableRecord(Integer id, String routerId, String urlPrefix, String routeHost, Boolean rewrite, String rewriteRegexp, String rewriteTarget, LocalDateTime createTime, LocalDateTime modifiedTime) {
        super(RouterTable.ROUTER_TABLE);

        setId(id);
        setRouterId(routerId);
        setUrlPrefix(urlPrefix);
        setRouteHost(routeHost);
        setRewrite(rewrite);
        setRewriteRegexp(rewriteRegexp);
        setRewriteTarget(rewriteTarget);
        setCreateTime(createTime);
        setModifiedTime(modifiedTime);
    }
}
