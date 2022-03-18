/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables;


import com.leryn.auth.data.Idaas;
import com.leryn.auth.data.tables.records.UserRoleRelationRecord;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 用户-角色关系表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRoleRelation extends TableImpl<UserRoleRelationRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>idaas.user_role_relation</code>
     */
    public static final UserRoleRelation USER_ROLE_RELATION = new UserRoleRelation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRoleRelationRecord> getRecordType() {
        return UserRoleRelationRecord.class;
    }

    /**
     * The column <code>idaas.user_role_relation.id</code>. 代理主键
     */
    public final TableField<UserRoleRelationRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false), this, "代理主键");

    /**
     * The column <code>idaas.user_role_relation.user_id</code>. 用户ID(员工号)
     */
    public final TableField<UserRoleRelationRecord, Integer> USER_ID = createField(DSL.name("user_id"), SQLDataType.INTEGER.nullable(false), this, "用户ID(员工号)");

    /**
     * The column <code>idaas.user_role_relation.role_id</code>. 角色ID
     */
    public final TableField<UserRoleRelationRecord, Integer> ROLE_ID = createField(DSL.name("role_id"), SQLDataType.INTEGER.nullable(false), this, "角色ID");

    /**
     * The column <code>idaas.user_role_relation.create_time</code>. 创建时间
     */
    public final TableField<UserRoleRelationRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>idaas.user_role_relation.update_time</code>. 修改时间
     */
    public final TableField<UserRoleRelationRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "修改时间");

    private UserRoleRelation(Name alias, Table<UserRoleRelationRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserRoleRelation(Name alias, Table<UserRoleRelationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("用户-角色关系表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>idaas.user_role_relation</code> table reference
     */
    public UserRoleRelation(String alias) {
        this(DSL.name(alias), USER_ROLE_RELATION);
    }

    /**
     * Create an aliased <code>idaas.user_role_relation</code> table reference
     */
    public UserRoleRelation(Name alias) {
        this(alias, USER_ROLE_RELATION);
    }

    /**
     * Create a <code>idaas.user_role_relation</code> table reference
     */
    public UserRoleRelation() {
        this(DSL.name("user_role_relation"), null);
    }

    public <O extends Record> UserRoleRelation(Table<O> child, ForeignKey<O, UserRoleRelationRecord> key) {
        super(child, key, USER_ROLE_RELATION);
    }

    @Override
    public Schema getSchema() {
        return Idaas.IDAAS;
    }

    @Override
    public UserRoleRelation as(String alias) {
        return new UserRoleRelation(DSL.name(alias), this);
    }

    @Override
    public UserRoleRelation as(Name alias) {
        return new UserRoleRelation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserRoleRelation rename(String name) {
        return new UserRoleRelation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserRoleRelation rename(Name name) {
        return new UserRoleRelation(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}