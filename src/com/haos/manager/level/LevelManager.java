package com.haos.manager.level;

import java.util.List;

import com.haos.common.util.page.PageModel;
import com.haos.domain.level.Level;
import com.haos.domain.level.query.LevelQuery;


/**
 * Level information manager interface
 * @author WangYue
 *
 */
public interface LevelManager {

	/**
	 * add level information
	 * @param level   level value class
	 * @return true:success;false:fail
	 */
	public boolean addLevel(Level level);
	
	/**
	 * update level information
	 * @param level  level value class
	 * @return true:success;false:fail
	 */
	public boolean updateLevel(Level level);
	
	/**
	 * according to level id ,query level information.
	 * @param id  level id
	 * @return  Level  level value class
	 */
	public Level getLevelById(Long id);
	
	/**
	 * according to level code ,query level information.
	 * @param levelCode  level code
	 * @return Level  level value class
	 */
	public Level getLevelByLevelCode(String levelCode);
	
	/**
	 * query level information with page
	 * @param query Query level value class
	 * @return Level level value class
	 */
	public List<Level> queryLevelListByQueryBean(LevelQuery levelQuery);
	
	/**
	 * query level information with page
	 * @param query Query level value class
	 * @return Level level value class
	 */
	public PageModel<Level> queryLevelListPageByQueryBean(LevelQuery levelQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to level id,delete level information.
	 * @param id  level id
	 * @return true:success;false:fail.
	 */
	public boolean deleteLevelById(Long id);
	
	/**
	 * according to level ids ,delete levles information
	 * @param ids  level ids array
	 * @return true:success;false:fail.
	 */
	public boolean deleteLevelByIds(Long[]ids);
	
	/**
	 * get level records 
	 * @param levelQuery  Query level value class 
	 * @return level count 
	 */
	public int queryLevelCountByQueryBean(LevelQuery levelQuery);
	
	
}
