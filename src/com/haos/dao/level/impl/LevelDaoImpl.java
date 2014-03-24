package com.haos.dao.level.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.level.LevelDao;
import com.haos.domain.level.Level;
import com.haos.domain.level.query.LevelQuery;

/**
 * Level information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class LevelDaoImpl extends BaseDao implements LevelDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addLevel(Level level) {
		return this.insert("Level.insert", level);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateLevel(Level level) {
		return this.update("Level.update", level);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Level getLevelById(Long id) {
		return (Level)this.queryForObject("Level.getLevelById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Level getLevelByLevelCode(String levelCode) {
		return (Level)this.queryForObject("Level.getLevelByLevelCode", levelCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Level> queryLevelListByQueryBean(LevelQuery levelQuery) {
		return this.queryForList("Level.queryLevelListByQueryBean",levelQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Level> queryLevelListPageByQueryBean(LevelQuery levelQuery) {
		return this.queryForList("Level.queryLevelListPageByQueryBean", levelQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteLevelById(Long id) {
		return this.delete("Level.deleteLevelById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryLevelCountByQueryBean(LevelQuery levelQuery) {
		return (Integer)this.queryForObject("Level.queryLevelCountByQueryBean", levelQuery);
	}

}
