/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables.daos;


import com.leryn.auth.data.tables.AuthorityPageElementRelation;
import com.leryn.auth.data.tables.records.AuthorityPageElementRelationRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 权限-页面元素关系表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class AuthorityPageElementRelationDao extends DAOImpl<AuthorityPageElementRelationRecord, com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation, Integer> {

    /**
     * Create a new AuthorityPageElementRelationDao without any configuration
     */
    public AuthorityPageElementRelationDao() {
        super(AuthorityPageElementRelation.AUTHORITY_PAGE_ELEMENT_RELATION, com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation.class);
    }

    /**
     * Create a new AuthorityPageElementRelationDao with an attached configuration
     */
    @Autowired
    public AuthorityPageElementRelationDao(Configuration configuration) {
        super(AuthorityPageElementRelation.AUTHORITY_PAGE_ELEMENT_RELATION, com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation.class, configuration);
    }

    @Override
    public Integer getId(com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(AuthorityPageElementRelation.AUTHORITY_PAGE_ELEMENT_RELATION.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation> fetchById(Integer... values) {
        return fetch(AuthorityPageElementRelation.AUTHORITY_PAGE_ELEMENT_RELATION.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation fetchOneById(Integer value) {
        return fetchOne(AuthorityPageElementRelation.AUTHORITY_PAGE_ELEMENT_RELATION.ID, value);
    }

    /**
     * Fetch records that have <code>create_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation> fetchRangeOfCreateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(AuthorityPageElementRelation.AUTHORITY_PAGE_ELEMENT_RELATION.CREATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation> fetchByCreateTime(LocalDateTime... values) {
        return fetch(AuthorityPageElementRelation.AUTHORITY_PAGE_ELEMENT_RELATION.CREATE_TIME, values);
    }

    /**
     * Fetch records that have <code>modified_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation> fetchRangeOfModifiedTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(AuthorityPageElementRelation.AUTHORITY_PAGE_ELEMENT_RELATION.MODIFIED_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modified_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.AuthorityPageElementRelation> fetchByModifiedTime(LocalDateTime... values) {
        return fetch(AuthorityPageElementRelation.AUTHORITY_PAGE_ELEMENT_RELATION.MODIFIED_TIME, values);
    }
}
