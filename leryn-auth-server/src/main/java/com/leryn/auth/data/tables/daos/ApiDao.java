/*
 * This file is generated by jOOQ.
 */
package com.leryn.auth.data.tables.daos;


import com.leryn.auth.data.tables.Api;
import com.leryn.auth.data.tables.records.ApiRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * API表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ApiDao extends DAOImpl<ApiRecord, com.leryn.auth.data.tables.pojos.Api, Integer> {

    /**
     * Create a new ApiDao without any configuration
     */
    public ApiDao() {
        super(Api.API, com.leryn.auth.data.tables.pojos.Api.class);
    }

    /**
     * Create a new ApiDao with an attached configuration
     */
    @Autowired
    public ApiDao(Configuration configuration) {
        super(Api.API, com.leryn.auth.data.tables.pojos.Api.class, configuration);
    }

    @Override
    public Integer getId(com.leryn.auth.data.tables.pojos.Api object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.Api> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Api.API.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.Api> fetchById(Integer... values) {
        return fetch(Api.API.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.leryn.auth.data.tables.pojos.Api fetchOneById(Integer value) {
        return fetchOne(Api.API.ID, value);
    }

    /**
     * Fetch records that have <code>url BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.Api> fetchRangeOfUrl(String lowerInclusive, String upperInclusive) {
        return fetchRange(Api.API.URL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>url IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.Api> fetchByUrl(String... values) {
        return fetch(Api.API.URL, values);
    }

    /**
     * Fetch records that have <code>create_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.Api> fetchRangeOfCreateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Api.API.CREATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.Api> fetchByCreateTime(LocalDateTime... values) {
        return fetch(Api.API.CREATE_TIME, values);
    }

    /**
     * Fetch records that have <code>modified_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.leryn.auth.data.tables.pojos.Api> fetchRangeOfModifiedTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Api.API.MODIFIED_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modified_time IN (values)</code>
     */
    public List<com.leryn.auth.data.tables.pojos.Api> fetchByModifiedTime(LocalDateTime... values) {
        return fetch(Api.API.MODIFIED_TIME, values);
    }
}
