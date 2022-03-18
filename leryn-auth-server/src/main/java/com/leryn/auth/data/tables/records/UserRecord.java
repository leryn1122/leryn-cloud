/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables.records;


import com.leryn.auth.data.tables.User;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record9<Integer, Integer, String, String, String, Boolean, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>idaas.user.id</code>. 代理主键
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>idaas.user.id</code>. 代理主键
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>idaas.user.user_id</code>. 用户ID
     */
    public void setUserId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>idaas.user.user_id</code>. 用户ID
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>idaas.user.username</code>. 用户名
     */
    public void setUsername(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>idaas.user.username</code>. 用户名
     */
    public String getUsername() {
        return (String) get(2);
    }

    /**
     * Setter for <code>idaas.user.password</code>. 密码
     */
    public void setPassword(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>idaas.user.password</code>. 密码
     */
    public String getPassword() {
        return (String) get(3);
    }

    /**
     * Setter for <code>idaas.user.salt</code>. 盐(8位随机盐)
     */
    public void setSalt(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>idaas.user.salt</code>. 盐(8位随机盐)
     */
    public String getSalt() {
        return (String) get(4);
    }

    /**
     * Setter for <code>idaas.user.password_activated</code>. 密码是否激活
     */
    public void setPasswordActivated(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>idaas.user.password_activated</code>. 密码是否激活
     */
    public Boolean getPasswordActivated() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>idaas.user.avatar</code>. 头像URL
     */
    public void setAvatar(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>idaas.user.avatar</code>. 头像URL
     */
    public String getAvatar() {
        return (String) get(6);
    }

    /**
     * Setter for <code>idaas.user.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>idaas.user.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>idaas.user.modified_time</code>. 修改时间
     */
    public void setModifiedTime(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>idaas.user.modified_time</code>. 修改时间
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
    public Row9<Integer, Integer, String, String, String, Boolean, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, Integer, String, String, String, Boolean, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return User.USER.ID;
    }

    @Override
    public Field<Integer> field2() {
        return User.USER.USER_ID;
    }

    @Override
    public Field<String> field3() {
        return User.USER.USERNAME;
    }

    @Override
    public Field<String> field4() {
        return User.USER.PASSWORD;
    }

    @Override
    public Field<String> field5() {
        return User.USER.SALT;
    }

    @Override
    public Field<Boolean> field6() {
        return User.USER.PASSWORD_ACTIVATED;
    }

    @Override
    public Field<String> field7() {
        return User.USER.AVATAR;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return User.USER.CREATE_TIME;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return User.USER.MODIFIED_TIME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getUserId();
    }

    @Override
    public String component3() {
        return getUsername();
    }

    @Override
    public String component4() {
        return getPassword();
    }

    @Override
    public String component5() {
        return getSalt();
    }

    @Override
    public Boolean component6() {
        return getPasswordActivated();
    }

    @Override
    public String component7() {
        return getAvatar();
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
    public Integer value2() {
        return getUserId();
    }

    @Override
    public String value3() {
        return getUsername();
    }

    @Override
    public String value4() {
        return getPassword();
    }

    @Override
    public String value5() {
        return getSalt();
    }

    @Override
    public Boolean value6() {
        return getPasswordActivated();
    }

    @Override
    public String value7() {
        return getAvatar();
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
    public UserRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UserRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UserRecord value4(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord value5(String value) {
        setSalt(value);
        return this;
    }

    @Override
    public UserRecord value6(Boolean value) {
        setPasswordActivated(value);
        return this;
    }

    @Override
    public UserRecord value7(String value) {
        setAvatar(value);
        return this;
    }

    @Override
    public UserRecord value8(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public UserRecord value9(LocalDateTime value) {
        setModifiedTime(value);
        return this;
    }

    @Override
    public UserRecord values(Integer value1, Integer value2, String value3, String value4, String value5, Boolean value6, String value7, LocalDateTime value8, LocalDateTime value9) {
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
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer id, Integer userId, String username, String password, String salt, Boolean passwordActivated, String avatar, LocalDateTime createTime, LocalDateTime modifiedTime) {
        super(User.USER);

        setId(id);
        setUserId(userId);
        setUsername(username);
        setPassword(password);
        setSalt(salt);
        setPasswordActivated(passwordActivated);
        setAvatar(avatar);
        setCreateTime(createTime);
        setModifiedTime(modifiedTime);
    }
}
