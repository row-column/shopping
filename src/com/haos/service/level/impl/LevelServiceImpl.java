package com.haos.service.level.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.date.DateUtil;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.level.Level;
import com.haos.domain.level.query.LevelQuery;
import com.haos.manager.level.LevelManager;
import com.haos.service.level.LevelService;

/**
 * Level information service interface
 * 
 * @author WangYue
 * 
 */
public class LevelServiceImpl implements LevelService {
	private static final Logger log = LogManager
			.getLogger(LevelServiceImpl.class);
	private LevelManager levelManager;

	@Override
	public ResultCollection addLevel(Level level) {
		ResultCollection result = new ResultCollection();
		level.setCreateTime(new Date()); // set create time
		level.setUpdateTime(new Date()); // set update time
		level.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
		try {
			boolean resultFlag = levelManager.addLevel(level);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("LevelServiceImpl -> addLevel() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection updateLevel(Level level) {
		ResultCollection result = new ResultCollection();
		level.setUpdateTime(new Date()); // set update time
		try {
			boolean resultFlag = levelManager.updateLevel(level);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("LevelServiceImpl -> updateLevel() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection getLevelById(Long id) {
		ResultCollection result = new ResultCollection();
		try {
			Level level = levelManager.getLevelById(id);
			result.addDefaultModel("level", level);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("LevelServiceImpl -> getLevelById() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection getLevelByLevelCode(String levelCode) {
		ResultCollection result = new ResultCollection();
		try {
			Level level = levelManager.getLevelByLevelCode(levelCode);
			result.addDefaultModel("level", level);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("LevelServiceImpl -> getLevelByLevelCode() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection queryLevelListByQueryBean(LevelQuery levelQuery) {
		ResultCollection result = new ResultCollection();
		try {
			List<Level> levelList = levelManager
					.queryLevelListByQueryBean(levelQuery);
			result.addDefaultModel("levelList", levelList);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"LevelServiceImpl -> queryLevelListByQueryBean() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection queryLevelListPageByQueryBean(
			LevelQuery levelQuery, int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
		try {
			List<Level> levelList = levelManager.queryLevelListPageByQueryBean(
					levelQuery, pageIndex, pageSize);
			result.addDefaultModel("levelList", levelList);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"LevelServiceImpl -> queryLevelListPageByQueryBean() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection deleteLevelById(Long id) {
		ResultCollection result = new ResultCollection();
		try {
			boolean resultFlag = levelManager.deleteLevelById(id);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("LevelServiceImpl -> deleteLevelById() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection deleteLevelByIds(Long ids[]) {
		ResultCollection result = new ResultCollection();
		try {
			if (null != ids && ids.length > 0) {
				boolean resultFlag = levelManager.deleteLevelByIds(ids);
				result.addDefaultModel("resultFlag", resultFlag);
				result.setSuccess(true);

			} else {
				log.error("LevelServiceImpl -> deleteLevelById() ids param null!!");
			}
		} catch (Exception e) {
			log.error("LevelServiceImpl -> deleteLevelById() error!!", e);
		}
		return result;
	}

	public void setLevelManager(LevelManager levelManager) {
		this.levelManager = levelManager;
	}

}
