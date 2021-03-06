/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables.records;


import com.leryn.auth.data.tables.UserGroupRoleRelation;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户组-角色关系表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserGroupRoleRelationRecord extends UpdatableRecordImpl<UserGroupRoleRelationRecord> implements Record3<Integer, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>idaas.user_group_role_relation.id</code>. 代理主键
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>idaas.user_group_role_relation.id</code>. 代理主键
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>idaas.user_group_role_relation.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>idaas.user_group_role_relation.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>idaas.user_group_role_relation.modified_time</code>. 修改时间
     */
    public void setModifiedTime(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>idaas.user_group_role_relation.modified_time</code>. 修改时间
     */
    public LocalDateTime getModifiedTime() {
        return (LocalDateTime) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return UserGroupRoleRelation.USER_GROUP_ROLE_RELATION.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return UserGroupRoleRelation.USER_GROUP_ROLE_RELATION.CREATE_TIME;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return UserGroupRoleRelation.USER_GROUP_ROLE_RELATION.MODIFIED_TIME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public LocalDateTime component2() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime component3() {
        return getModifiedTime();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public LocalDateTime value2() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime value3() {
        return getModifiedTime();
    }

    @Override
    public UserGroupRoleRelationRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UserGroupRoleRelationRecord value2(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public UserGroupRoleRelationRecord value3(LocalDateTime value) {
        setModifiedTime(value);
        return this;
    }

    @Override
    public UserGroupRoleRelationRecord values(Integer value1, LocalDateTime value2, LocalDateTime value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserGroupRoleRelationRecord
     */
    public UserGroupRoleRelationRecord() {
        super(UserGroupRoleRelation.USER_GROUP_ROLE_RELATION);
    }

    /**
     * Create a detached, initialised UserGroupRoleRelationRecord
     */
    public UserGroupRoleRelationRecord(Integer id, LocalDateTime createTime, LocalDateTime modifiedTime) {
        super(UserGroupRoleRelation.USER_GROUP_ROLE_RELATION);

        setId(id);
        setCreateTime(createTime);
        setModifiedTime(modifiedTime);
    }
}
