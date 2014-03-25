package com.shopping.dao.employee.impl;

import java.util.List;

import com.shopping.common.util.dao.BaseDao;
import com.shopping.dao.employee.EmployeeFunDao;
import com.shopping.domain.employee.EmployeeFun;
import com.shopping.domain.employee.query.EmployeeFunQuery;

/**
 * EmployeeFun information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class EmployeeFunDaoImpl extends BaseDao implements EmployeeFunDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addEmployeeFun(EmployeeFun fun) {
		return this.insert("EmployeeFun.insert", fun);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateEmployeeFun(EmployeeFun fun) {
		return this.update("EmployeeFun.update", fun);
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmployeeFun getEmployeeFunById(Long id) {
		return (EmployeeFun)this.queryForObject("EmployeeFun.getEmployeeFunById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmployeeFun getEmployeeFunByEmployeeFunCode(String funCode) {
		return (EmployeeFun)this.queryForObject("EmployeeFun.getEmployeeFunByEmployeeFunCode", funCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeFun> queryEmployeeFunListByQueryBean(EmployeeFunQuery funQuery) {
		return this.queryForList("EmployeeFun.queryEmployeeFunListByQueryBean",funQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeFun> queryEmployeeFunListPageByQueryBean(EmployeeFunQuery funQuery) {
		return this.queryForList("EmployeeFun.queryEmployeeFunListPageByQueryBean", funQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteEmployeeFunById(Long id) {
		return this.delete("EmployeeFun.deleteEmployeeFunById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteEmployeeFunByEmployeeCode(String employeeCode) {
		return this.delete("EmployeeFun.deleteEmployeeFunByEmployeeCode", employeeCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryEmployeeFunCountByQueryBean(EmployeeFunQuery funQuery) {
		return (Integer)this.queryForObject("EmployeeFun.queryEmployeeFunCountByQueryBean", funQuery);
	}

}
