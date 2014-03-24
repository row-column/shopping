package com.haos.service.user.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.level.Level;
import com.haos.domain.user.User;
import com.haos.domain.user.query.UserQuery;
import com.haos.manager.level.LevelManager;
import com.haos.manager.user.UserManager;
import com.haos.service.user.UserService;

/**
 * User information service interface
 * 
 * @author WangYue
 * 
 */
public class UserServiceImpl implements UserService {

	private static final Logger log = LogManager
			.getLogger(UserServiceImpl.class);
	/**
	 * User information Manager interface
	 */
	private UserManager userManager;
	/**
	 * Level information Manager interface
	 */
	private LevelManager levelManager;

	@Override
	public ResultCollection addUser(User user) {

		ResultCollection result = new ResultCollection();
		try {
			user.setReqDate(new Date()); // set register date
			user.setCreateTime(new Date()); // set create time
			user.setUpdateTime(new Date()); // set update time
			user.setYn(CommonConstant.YN_NO_DELETE); // set yn=0
			// call getLevelById()method
			Level level = levelManager.getLevelById(1L);
			if (null != level && level.getId() != null) {
				// set level code
				user.setLevelCode(level.getLevelCode());
				// set level name
				user.setLevelName(level.getLevelName());
			}
			boolean resultFlag = userManager.addUser(user);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("UserServiceImpl -> addUser() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection updateUser(User user) {
		ResultCollection result = new ResultCollection();
		try {
			user.setUpdateTime(new Date()); // set update time
			boolean resultFlag = userManager.updateUser(user);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(resultFlag);
		} catch (Exception e) {
			log.error("UserServiceImpl -> updateUser() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection updateUserInfo(User user) {
		ResultCollection result = new ResultCollection();
		try {
			user.setUpdateTime(new Date()); // set update time
			boolean resultFlag = userManager.updateUserInfo(user);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(resultFlag);
		} catch (Exception e) {
			log.error("UserServiceImpl -> updateUserInfo() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection updateUserPassword(User user) {
		ResultCollection result = new ResultCollection();
		try {
			user.setUpdateTime(new Date()); // set update time
			boolean resultFlag = userManager.updateUserPassword(user);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(resultFlag);
		} catch (Exception e) {
			log.error("UserServiceImpl -> updateUserPassword() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection getUserById(Long id) {
		ResultCollection result = new ResultCollection();
		try {
			User user = userManager.getUserById(id);
			result.addDefaultModel("user", user);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("UserServiceImpl -> getUserById() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection getUserByUserCode(String userCode) {
		ResultCollection result = new ResultCollection();
		try {
			User user = userManager.getUserByUserCode(userCode);
			result.addDefaultModel("user", user);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("UserServiceImpl -> getUserByUserCode() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection queryUserListByQueryBean(UserQuery userQuery) {
		ResultCollection result = new ResultCollection();
		try {
			List<User> userList = userManager
					.queryUserListByQueryBean(userQuery);
			result.addDefaultModel("userList", userList);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("UserServiceImpl -> queryUserListByQueryBean() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection queryUserListPageByQueryBean(UserQuery userQuery,
			int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
		try {
			List<User> userList = userManager.queryUserListPageByQueryBean(
					userQuery, pageIndex, pageSize);
			result.addDefaultModel("userList", userList);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error(
					"UserServiceImpl -> queryUserListPageByQueryBean() error!!",
					e);
		}
		return result;
	}

	@Override
	public ResultCollection deleteUserById(Long id) {
		ResultCollection result = new ResultCollection();
		try {
			boolean resultFlag = userManager.deleteUserById(id);
			result.addDefaultModel("resultFlag", resultFlag);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("UserServiceImpl -> deleteUserById() error!!", e);
		}
		return result;
	}

	@Override
	public ResultCollection deleteUserByIds(Long ids[]) {
		ResultCollection result = new ResultCollection();
		try {
			if (null != ids && ids.length > 0) {
				boolean resultFlag = userManager.deleteUserByIds(ids);
				result.addDefaultModel("resultFlag", resultFlag);
				result.setSuccess(true);

			} else {
				log.error("UserServiceImpl -> deleteUserById() ids param null!!");
			}
		} catch (Exception e) {
			log.error("UserServiceImpl -> deleteUserById() error!!", e);
		}
		return result;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setLevelManager(LevelManager levelManager) {
		this.levelManager = levelManager;
	}

}
