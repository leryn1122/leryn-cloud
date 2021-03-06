/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables.daos;


import com.leryn.auth.data.tables.AuthorityMenuRelation;
import com.leryn.auth.data.tables.records.AuthorityMenuRelationRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 权限-菜单关系表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class AuthorityMenuRelationDao extends DAOImpl<AuthorityMenuRelationRecord, com.leryn.auth.data.tables.pojos.AuthorityMenuRelation, Integer> {

    /**
     * Create a new AuthorityMenuRelationDao without any configuration
     */
    public AuthorityMenuRelationDao() {
        super(AuthorityMenuRelation.AUTHORITY_MENU_RELATION, com.leryn.auth.data.tables.pojos.AuthorityMenuRelation.class);
    }

    /**
     * Create a new AuthorityMenuRelationDao with an attached configuration
     */
    @Autowired
    public AuthorityMenuRelationDao(Configuration configuration) {
        super(AuthorityMenuRelation.AUTHORITY_MENU_RELATION, com.leryn.auth.data.tables.pojos.AuthorityMenuRelation.class, configuration);
    }

    @Override
    public Integer getId(com.leryn.auth.data.tables.pojos.AuthorityMenuRelation object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityMenuRelation> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(AuthorityMenuRelation.AUTHORITY_MENU_RELATION.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityMenuRelation> fetchById(Integer... values) {
        return fetch(AuthorityMenuRelation.AUTHORITY_MENU_RELATION.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.leryn.auth.data.tables.pojos.AuthorityMenuRelation fetchOneById(Integer value) {
        return fetchOne(AuthorityMenuRelation.AUTHORITY_MENU_RELATION.ID, value);
    }

    /**
     * Fetch records that have <code>create_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityMenuRelation> fetchRangeOfCreateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(AuthorityMenuRelation.AUTHORITY_MENU_RELATION.CREATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityMenuRelation> fetchByCreateTime(LocalDateTime... values) {
        return fetch(AuthorityMenuRelation.AUTHORITY_MENU_RELATION.CREATE_TIME, values);
    }

    /**
     * Fetch records that have <code>modified_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityMenuRelation> fetchRangeOfModifiedTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(AuthorityMenuRelation.AUTHORITY_MENU_RELATION.MODIFIED_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modified_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityMenuRelation> fetchByModifiedTime(LocalDateTime... values) {
        return fetch(AuthorityMenuRelation.AUTHORITY_MENU_RELATION.MODIFIED_TIME, values);
    }
}
