package com.shopping.common.util.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;


public abstract class BaseDao<T extends Object> extends SqlSessionDaoSupport {

    /**
     * 
     * @param classMethod
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public boolean insert(String classMethod, T entity) throws DataAccessException {
        boolean flag = false;
        try {
            flag = this.getSqlSession().insert(classMethod, entity) > 0 ? true : false;
        } catch (DataAccessException e) {
            flag = false;
            throw e;
        }
        return flag;
    }

   /**
    * 
    * @param classMethod
    * @param entity
    * @return
    * @throws DataAccessException
    */
  
    public boolean update(String classMethod, T entity) throws DataAccessException {
        boolean flag = false;
        try {
            flag = this.getSqlSession().update(classMethod, entity) > 0 ? true : false;
        } catch (DataAccessException e) {
            flag = false;
            throw e;
        }
        return flag;
    }

    /**
     * 
     * @param classMethod
     * @param entity
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
	public T queryForObject(String classMethod, T entity) throws DataAccessException {
        T result = null;
        try {
            result = (T) this.getSqlSession().selectOne(classMethod, entity);
        } catch (DataAccessException e) {
            throw e;
        }
        return result;
    }

   /**
    * 
    * @param classMethod
    * @param entity
    * @return
    * @throws DataAccessException
    */
    @SuppressWarnings("unchecked")
	public List<T> queryForList(String classMethod, T entity) throws DataAccessException {
        List<T> result = new ArrayList<T>();
        try {
            result = this.getSqlSession().selectList(classMethod, entity);
        } catch (DataAccessException e) {
            throw e;
        }
        return result;
    }

   /**
    * 
    * @param classMethod
    * @return
    * @throws DataAccessException
    */
    @SuppressWarnings("unchecked")
	public List<T> queryForList(String classMethod) throws DataAccessException {
        List<T> result = new ArrayList<T>();
        try {
            result = this.getSqlSession().selectList(classMethod);
        } catch (DataAccessException e) {
            throw e;
        }
        return result;
    }

    /**
     * 
     * @param classMethod
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public boolean delete(String classMethod, T entity) throws DataAccessException {
        boolean flag = false;
        try {
            flag = this.getSqlSession().delete(classMethod, entity) > 0 ? true : false;
        } catch (DataAccessException e) {
            flag = false;
            throw e;
        }
        return flag;
    }

}
