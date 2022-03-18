/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 菜单权限表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MenuAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    public MenuAuthority() {}

    public MenuAuthority(MenuAuthority value) {
        this.id = value.id;
        this.createTime = value.createTime;
        this.modifiedTime = value.modifiedTime;
    }

    public MenuAuthority(
        Integer       id,
        LocalDateTime createTime,
        LocalDateTime modifiedTime
    ) {
        this.id = id;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    /**
     * Getter for <code>idaas.menu_authority.id</code>. 代理主键
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>idaas.menu_authority.id</code>. 代理主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>idaas.menu_authority.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    /**
     * Setter for <code>idaas.menu_authority.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter for <code>idaas.menu_authority.modified_time</code>. 修改时间
     */
    public LocalDateTime getModifiedTime() {
        return this.modifiedTime;
    }

    /**
     * Setter for <code>idaas.menu_authority.modified_time</code>. 修改时间
     */
    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MenuAuthority (");

        sb.append(id);
        sb.append(", ").append(createTime);
        sb.append(", ").append(modifiedTime);

        sb.append(")");
        return sb.toString();
    }
}
