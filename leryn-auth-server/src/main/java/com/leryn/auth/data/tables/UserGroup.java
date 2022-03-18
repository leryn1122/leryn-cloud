/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables;


import com.leryn.auth.data.Idaas;
import com.leryn.auth.data.Keys;
import com.leryn.auth.data.tables.records.UserGroupRecord;

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
 * 用户组表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserGroup extends TableImpl<UserGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>idaas.user_group</code>
     */
    public static final UserGroup USER_GROUP = new UserGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserGroupRecord> getRecordType() {
        return UserGroupRecord.class;
    }

    /**
     * The column <code>idaas.user_group.id</code>. 代理主键
     */
    public final TableField<UserGroupRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "代理主键");

    /**
     * The column <code>idaas.user_group.name</code>. 用户组名
     */
    public final TableField<UserGroupRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100).nullable(false), this, "用户组名");

    /**
     * The column <code>idaas.user_group.parent_id</code>.
     */
    public final TableField<UserGroupRecord, Integer> PARENT_ID = createField(DSL.name("parent_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>idaas.user_group.create_time</code>. 创建时间
     */
    public final TableField<UserGroupRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>idaas.user_group.modified_time</code>. 修改时间
     */
    public final TableField<UserGroupRecord, LocalDateTime> MODIFIED_TIME = createField(DSL.name("modified_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "修改时间");

    private UserGroup(Name alias, Table<UserGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserGroup(Name alias, Table<UserGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("用户组表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>idaas.user_group</code> table reference
     */
    public UserGroup(String alias) {
        this(DSL.name(alias), USER_GROUP);
    }

    /**
     * Create an aliased <code>idaas.user_group</code> table reference
     */
    public UserGroup(Name alias) {
        this(alias, USER_GROUP);
    }

    /**
     * Create a <code>idaas.user_group</code> table reference
     */
    public UserGroup() {
        this(DSL.name("user_group"), null);
    }

    public <O extends Record> UserGroup(Table<O> child, ForeignKey<O, UserGroupRecord> key) {
        super(child, key, USER_GROUP);
    }

    @Override
    public Schema getSchema() {
        return Idaas.IDAAS;
    }

    @Override
    public Identity<UserGroupRecord, Integer> getIdentity() {
        return (Identity<UserGroupRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<UserGroupRecord> getPrimaryKey() {
        return Keys.KEY_USER_GROUP_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserGroupRecord>> getKeys() {
        return Arrays.<UniqueKey<UserGroupRecord>>asList(Keys.KEY_USER_GROUP_PRIMARY);
    }

    @Override
    public UserGroup as(String alias) {
        return new UserGroup(DSL.name(alias), this);
    }

    @Override
    public UserGroup as(Name alias) {
        return new UserGroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserGroup rename(String name) {
        return new UserGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserGroup rename(Name name) {
        return new UserGroup(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}