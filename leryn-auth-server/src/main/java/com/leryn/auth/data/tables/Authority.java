/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables;


import com.leryn.auth.data.Idaas;
import com.leryn.auth.data.Keys;
import com.leryn.auth.data.tables.records.AuthorityRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 权限表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Authority extends TableImpl<AuthorityRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>idaas.authority</code>
     */
    public static final Authority AUTHORITY = new Authority();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorityRecord> getRecordType() {
        return AuthorityRecord.class;
    }

    /**
     * The column <code>idaas.authority.id</code>. 代理主键
     */
    public final TableField<AuthorityRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "代理主键");

    /**
     * The column <code>idaas.authority.authority_id</code>. 权限ID
     */
    public final TableField<AuthorityRecord, Integer> AUTHORITY_ID = createField(DSL.name("authority_id"), SQLDataType.INTEGER.nullable(false), this, "权限ID");

    /**
     * The column <code>idaas.authority.name</code>. 权限名称
     */
    public final TableField<AuthorityRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100).nullable(false), this, "权限名称");

    /**
     * The column <code>idaas.authority.create_time</code>. 创建时间
     */
    public final TableField<AuthorityRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>idaas.authority.modified_time</code>. 修改时间
     */
    public final TableField<AuthorityRecord, LocalDateTime> MODIFIED_TIME = createField(DSL.name("modified_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "修改时间");

    private Authority(Name alias, Table<AuthorityRecord> aliased) {
        this(alias, aliased, null);
    }

    private Authority(Name alias, Table<AuthorityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("权限表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>idaas.authority</code> table reference
     */
    public Authority(String alias) {
        this(DSL.name(alias), AUTHORITY);
    }

    /**
     * Create an aliased <code>idaas.authority</code> table reference
     */
    public Authority(Name alias) {
        this(alias, AUTHORITY);
    }

    /**
     * Create a <code>idaas.authority</code> table reference
     */
    public Authority() {
        this(DSL.name("authority"), null);
    }

    public <O extends Record> Authority(Table<O> child, ForeignKey<O, AuthorityRecord> key) {
        super(child, key, AUTHORITY);
    }

    @Override
    public Schema getSchema() {
        return Idaas.IDAAS;
    }

    @Override
    public Identity<AuthorityRecord, Integer> getIdentity() {
        return (Identity<AuthorityRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<AuthorityRecord> getPrimaryKey() {
        return Keys.KEY_AUTHORITY_PRIMARY;
    }

    @Override
    public List<UniqueKey<AuthorityRecord>> getKeys() {
        return Arrays.<UniqueKey<AuthorityRecord>>asList(Keys.KEY_AUTHORITY_PRIMARY);
    }

    @Override
    public Authority as(String alias) {
        return new Authority(DSL.name(alias), this);
    }

    @Override
    public Authority as(Name alias) {
        return new Authority(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Authority rename(String name) {
        return new Authority(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Authority rename(Name name) {
        return new Authority(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
