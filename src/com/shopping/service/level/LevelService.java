package com.shopping.service.level;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.level.Level;
import com.shopping.domain.level.query.LevelQuery;

/**
 * Level information service interface
 * @author WangYue
 *
 */
public interface LevelService {

	/**
	 * add level information
	 * @param level   level value class
	 * @return Result 
	 */
	public ResultCollection addLevel(Level level);
	
	/**
	 * update level information
	 * @param level  level value class
	 * @return Result 
	 */
	public ResultCollection updateLevel(Level level);
	
	/**
	 * according to level id ,query level information.
	 * @param id  level id
	 * @return  Result
	 */
	public ResultCollection getLevelById(Long id);
	
	/**
	 * according to level code ,query level information.
	 * @param levelCode  level code
	 * @return Result
	 */
	public ResultCollection getLevelByLevelCode(String levelCode);
	
	/**
	 * query level information with page
	 * @param query Query level value class
	 * @return Result
	 */
	public ResultCollection queryLevelListByQueryBean(LevelQuery levelQuery);
	
	/**
	 * query level information with page
	 * @param query Query level value class
	 * @return Result
	 */
	public ResultCollection queryLevelListPageByQueryBean(LevelQuery levelQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to level id,delete level information.
	 * @param id  level id
	 * @return Result .
	 */
	public ResultCollection deleteLevelById(Long id);

	/**
	 *  according to level ids,delete levels information
	 * @param ids level dis
	 * @return Result
	 */
	public  ResultCollection deleteLevelByIds(Long[] ids);
	
}
