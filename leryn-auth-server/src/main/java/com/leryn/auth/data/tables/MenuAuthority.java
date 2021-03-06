/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables;


import com.leryn.auth.data.Idaas;
import com.leryn.auth.data.Keys;
import com.leryn.auth.data.tables.records.MenuAuthorityRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 菜单权限表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MenuAuthority extends TableImpl<MenuAuthorityRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>idaas.menu_authority</code>
     */
    public static final MenuAuthority MENU_AUTHORITY = new MenuAuthority();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MenuAuthorityRecord> getRecordType() {
        return MenuAuthorityRecord.class;
    }

    /**
     * The column <code>idaas.menu_authority.id</code>. 代理主键
     */
    public final TableField<MenuAuthorityRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "代理主键");

    /**
     * The column <code>idaas.menu_authority.create_time</code>. 创建时间
     */
    public final TableField<MenuAuthorityRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>idaas.menu_authority.modified_time</code>. 修改时间
     */
    public final TableField<MenuAuthorityRecord, LocalDateTime> MODIFIED_TIME = createField(DSL.name("modified_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "修改时间");

    private MenuAuthority(Name alias, Table<MenuAuthorityRecord> aliased) {
        this(alias, aliased, null);
    }

    private MenuAuthority(Name alias, Table<MenuAuthorityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("菜单权限表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>idaas.menu_authority</code> table reference
     */
    public MenuAuthority(String alias) {
        this(DSL.name(alias), MENU_AUTHORITY);
    }

    /**
     * Create an aliased <code>idaas.menu_authority</code> table reference
     */
    public MenuAuthority(Name alias) {
        this(alias, MENU_AUTHORITY);
    }

    /**
     * Create a <code>idaas.menu_authority</code> table reference
     */
    public MenuAuthority() {
        this(DSL.name("menu_authority"), null);
    }

    public <O extends Record> MenuAuthority(Table<O> child, ForeignKey<O, MenuAuthorityRecord> key) {
        super(child, key, MENU_AUTHORITY);
    }

    @Override
    public Schema getSchema() {
        return Idaas.IDAAS;
    }

    @Override
    public Identity<MenuAuthorityRecord, Integer> getIdentity() {
        return (Identity<MenuAuthorityRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<MenuAuthorityRecord> getPrimaryKey() {
        return Keys.KEY_MENU_AUTHORITY_PRIMARY;
    }

    @Override
    public List<UniqueKey<MenuAuthorityRecord>> getKeys() {
        return Arrays.<UniqueKey<MenuAuthorityRecord>>asList(Keys.KEY_MENU_AUTHORITY_PRIMARY);
    }

    @Override
    public MenuAuthority as(String alias) {
        return new MenuAuthority(DSL.name(alias), this);
    }

    @Override
    public MenuAuthority as(Name alias) {
        return new MenuAuthority(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MenuAuthority rename(String name) {
        return new MenuAuthority(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MenuAuthority rename(Name name) {
        return new MenuAuthority(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
