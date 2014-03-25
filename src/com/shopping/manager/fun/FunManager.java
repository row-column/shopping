package com.shopping.manager.fun;

import java.util.List;

import com.shopping.common.util.page.PageModel;
import com.shopping.domain.fun.Fun;
import com.shopping.domain.fun.query.FunQuery;


/**
 * Fun information manager interface
 * @author WangYue
 *
 */
public interface FunManager {

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
	 * query fun information with page
	 * @param query Query fun value class
	 * @return Fun fun value class
	 */
	public List<Fun> queryFunListByQueryBean(FunQuery funQuery);
	
	/**
	 * query fun information with page
	 * @param query Query fun value class
	 * @return Fun fun value class
	 */
	public PageModel<Fun> queryFunListPageByQueryBean(FunQuery funQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to fun id,delete fun information.
	 * @param id  fun id
	 * @return true:success;false:fail.
	 */
	public boolean deleteFunById(Long id);
	
	/**
	 * according to fun ids ,delete funs information
	 * @param ids fun ids array
	 * @return true:success;false:fail
	 */
	boolean deleteFunByIds(Long[] ids);
	
	/**
	 * get fun records 
	 * @param query  Query fun value class 
	 * @return fun count 
	 */
	public int queryFunCountByQueryBean(FunQuery funquery);

	
	
}
