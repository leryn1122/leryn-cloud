/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables.daos;


import com.leryn.auth.data.tables.PageElementAuthority;
import com.leryn.auth.data.tables.records.PageElementAuthorityRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 页面元素权限表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class PageElementAuthorityDao extends DAOImpl<PageElementAuthorityRecord, com.leryn.auth.data.tables.pojos.PageElementAuthority, Integer> {

    /**
     * Create a new PageElementAuthorityDao without any configuration
     */
    public PageElementAuthorityDao() {
        super(PageElementAuthority.PAGE_ELEMENT_AUTHORITY, com.leryn.auth.data.tables.pojos.PageElementAuthority.class);
    }

    /**
     * Create a new PageElementAuthorityDao with an attached configuration
     */
    @Autowired
    public PageElementAuthorityDao(Configuration configuration) {
        super(PageElementAuthority.PAGE_ELEMENT_AUTHORITY, com.leryn.auth.data.tables.pojos.PageElementAuthority.class, configuration);
    }

    @Override
    public Integer getId(com.leryn.auth.data.tables.pojos.PageElementAuthority object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.PageElementAuthority> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(PageElementAuthority.PAGE_ELEMENT_AUTHORITY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.PageElementAuthority> fetchById(Integer... values) {
        return fetch(PageElementAuthority.PAGE_ELEMENT_AUTHORITY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.leryn.auth.data.tables.pojos.PageElementAuthority fetchOneById(Integer value) {
        return fetchOne(PageElementAuthority.PAGE_ELEMENT_AUTHORITY.ID, value);
    }

    /**
     * Fetch records that have <code>create_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.PageElementAuthority> fetchRangeOfCreateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(PageElementAuthority.PAGE_ELEMENT_AUTHORITY.CREATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.PageElementAuthority> fetchByCreateTime(LocalDateTime... values) {
        return fetch(PageElementAuthority.PAGE_ELEMENT_AUTHORITY.CREATE_TIME, values);
    }

    /**
     * Fetch records that have <code>modified_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.PageElementAuthority> fetchRangeOfModifiedTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(PageElementAuthority.PAGE_ELEMENT_AUTHORITY.MODIFIED_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modified_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.PageElementAuthority> fetchByModifiedTime(LocalDateTime... values) {
        return fetch(PageElementAuthority.PAGE_ELEMENT_AUTHORITY.MODIFIED_TIME, values);
    }
}