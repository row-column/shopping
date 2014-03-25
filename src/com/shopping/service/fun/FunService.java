package com.shopping.service.fun;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.fun.Fun;
import com.shopping.domain.fun.query.FunQuery;

/**
 * Fun information service interface
 * @author WangYue
 *
 */
public interface FunService {

	/**
	 * add fun information
	 * @param fun   fun value class
	 * @return Result 
	 */
	public ResultCollection addFun(Fun fun);
	
	/**
	 * update fun information
	 * @param fun  fun value class
	 * @return Result 
	 */
	public ResultCollection updateFun(Fun fun);
	
	/**
	 * according to fun id ,query fun information.
	 * @param id  fun id
	 * @return  Result
	 */
	public ResultCollection getFunById(Long id);
	
	/**
	 * according to fun code ,query fun information.
	 * @param funCode  fun code
	 * @return Result
	 */
	public ResultCollection getFunByFunCode(String funCode);
	
	/**
	 * query fun information with page
	 * @param query Query fun value class
	 * @return Result
	 */
	public ResultCollection queryFunListByQueryBean(FunQuery funQuery);
	
	/**
	 * query fun information with page
	 * @param query Query fun value class
	 * @return Result
	 */
	public ResultCollection queryFunListPageByQueryBean(FunQuery funQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to fun id,delete fun information.
	 * @param id  fun id
	 * @return Result .
	 */
	public ResultCollection deleteFunById(Long id);
	

	/**
	 * according to fun id,delete fun information.
	 * @param id  fun id array
	 * @return Result .
	 */
	public ResultCollection deleteFunByIds(Long[] id);
	
}
