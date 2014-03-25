package com.shopping.dao.level;

import java.util.List;

import com.shopping.domain.level.Level;
import com.shopping.domain.level.query.LevelQuery;


/**
 * Level information DAO interface
 * @author WangYue
 *
 */
public interface LevelDao {

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
	 * query all level information
	 * @param query  Query level value class
	 * @return Level  level value class
	 */
	public List<Level> queryLevelListByQueryBean(LevelQuery levelQuery);
	
	/**
	 * query level information with page
	 * @param query Query level value class
	 * @return Level level value class
	 */
	public List<Level> queryLevelListPageByQueryBean(LevelQuery levelQuery);
	
	/**
	 * according to level id,delete level information.
	 * @param id  level id
	 * @return true:success;false:fail.
	 */
	public boolean deleteLevelById(Long id);
	
	/**
	 * get level records 
	 * @param query  Query level value class 
	 * @return level count 
	 */
	public int queryLevelCountByQueryBean(LevelQuery levelQuery);
	
	
}
