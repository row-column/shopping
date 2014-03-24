package com.haos.dao.fun;

import java.util.List;

import com.haos.domain.fun.Fun;
import com.haos.domain.fun.query.FunQuery;


/**
 * Fun information DAO interface
 * @author WangYue
 *
 */
public interface FunDao {

	/**
	 * add fun information
	 * @param fun   fun value class
	 * @return true:success;false:fail
	 */
	public boolean addFun(Fun fun);
	
	/**
	 * update fun information
	 * @param fun  fun value class
	 * @return true:success;false:fail
	 */
	public boolean updateFun(Fun fun);
	
	/**
	 * according to fun id ,query fun information.
	 * @param id  fun id
	 * @return  Fun  fun value class
	 */
	public Fun getFunById(Long id);
	
	/**
	 * according to fun code ,query fun information.
	 * @param funCode  fun code
	 * @return Fun  fun value class
	 */
	public Fun getFunByFunCode(String funCode);
	
	/**
	 * query all fun information
	 * @param query  Query fun value class
	 * @return Fun  fun value class
	 */
	public List<Fun> queryFunListByQueryBean(FunQuery funQuery);
	
	/**
	 * query fun information with page
	 * @param query Query fun value class
	 * @return Fun fun value class
	 */
	public List<Fun> queryFunListPageByQueryBean(FunQuery funQuery);
	
	/**
	 * according to fun id,delete fun information.
	 * @param id  fun id
	 * @return true:success;false:fail.
	 */
	public boolean deleteFunById(Long id);
	
	/**
	 * get fun records 
	 * @param query  Query fun value class 
	 * @return fun count 
	 */
	public int queryFunCountByQueryBean(FunQuery funQuery);
	
	
}
