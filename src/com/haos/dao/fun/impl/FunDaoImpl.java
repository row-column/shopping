package com.haos.dao.fun.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.fun.FunDao;
import com.haos.domain.fun.Fun;
import com.haos.domain.fun.query.FunQuery;

/**
 * Fun information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class FunDaoImpl extends BaseDao implements FunDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addFun(Fun fun) {
		return this.insert("Fun.insert", fun);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateFun(Fun fun) {
		return this.update("Fun.update", fun);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Fun getFunById(Long id) {
		return (Fun)this.queryForObject("Fun.getFunById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Fun getFunByFunCode(String funCode) {
		return (Fun)this.queryForObject("Fun.getFunByFunCode", funCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fun> queryFunListByQueryBean(FunQuery funQuery) {
		return this.queryForList("Fun.queryFunListByQueryBean",funQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fun> queryFunListPageByQueryBean(FunQuery funQuery) {
		return this.queryForList("Fun.queryFunListPageByQueryBean", funQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteFunById(Long id) {
		return this.delete("Fun.deleteFunById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryFunCountByQueryBean(FunQuery funQuery) {
		return (Integer)this.queryForObject("Fun.queryFunCountByQueryBean", funQuery);
	}

}
