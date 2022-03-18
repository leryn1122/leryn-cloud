/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables.daos;


import com.leryn.auth.data.tables.RoleAuthorityRelation;
import com.leryn.auth.data.tables.records.RoleAuthorityRelationRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 角色-权限关系表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class RoleAuthorityRelationDao extends DAOImpl<RoleAuthorityRelationRecord, com.leryn.auth.data.tables.pojos.RoleAuthorityRelation, Integer> {

    /**
     * Create a new RoleAuthorityRelationDao without any configuration
     */
    public RoleAuthorityRelationDao() {
        super(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION, com.leryn.auth.data.tables.pojos.RoleAuthorityRelation.class);
    }

    /**
     * Create a new RoleAuthorityRelationDao with an attached configuration
     */
    @Autowired
    public RoleAuthorityRelationDao(Configuration configuration) {
        super(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION, com.leryn.auth.data.tables.pojos.RoleAuthorityRelation.class, configuration);
    }

    @Override
    public Integer getId(com.leryn.auth.data.tables.pojos.RoleAuthorityRelation object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchById(Integer... values) {
        return fetch(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.leryn.auth.data.tables.pojos.RoleAuthorityRelation fetchOneById(Integer value) {
        return fetchOne(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.ID, value);
    }

    /**
     * Fetch records that have <code>role_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchRangeOfRoleId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.ROLE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>role_id IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchByRoleId(Integer... values) {
        return fetch(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.ROLE_ID, values);
    }

    /**
     * Fetch records that have <code>authority_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchRangeOfAuthorityId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.AUTHORITY_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>authority_id IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchByAuthorityId(Integer... values) {
        return fetch(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.AUTHORITY_ID, values);
    }

    /**
     * Fetch records that have <code>create_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchRangeOfCreateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.CREATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchByCreateTime(LocalDateTime... values) {
        return fetch(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.CREATE_TIME, values);
    }

    /**
     * Fetch records that have <code>modified_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchRangeOfModifiedTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.MODIFIED_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modified_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.RoleAuthorityRelation> fetchByModifiedTime(LocalDateTime... values) {
        return fetch(RoleAuthorityRelation.ROLE_AUTHORITY_RELATION.MODIFIED_TIME, values);
    }
}