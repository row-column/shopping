package com.shopping.manager.user;

import java.util.List;

import com.shopping.common.util.page.PageModel;
import com.shopping.domain.user.User;
import com.shopping.domain.user.query.UserQuery;


/**
 * User information manager interface
 * @author WangYue
 *
 */
public interface UserManager {

	/**
	 * add user information
	 * @param user   user value class
	 * @return true:success;false:fail
	 */
	public boolean addUser(User user);
	
	/**
	 * update user information
	 * @param user  user value class
	 * @return true:success;false:fail
	 */
	public boolean updateUser(User user);
	
	/**
	 * update user information
	 * @param user  user value class
	 * @return true:success;false:fail
	 */
	public boolean updateUserInfo(User user);

	/**
	 * update user password
	 * @param user  user value class
	 * @return true:success;false:fail
	 */
	public boolean updateUserPassword(User user);
	
	/**
	 * update user comment count
	 * @param user  user value class
	 * @return true:success;false:fail
	 */
	public boolean updateUserCommentCount(User user);
	/**
	 * update user integral and level
	 * @param user  user value class
	 * @return true:success;false:fail
	 */
	public boolean updateUserIntegralAndLevel(User user);
	
	/**
	 * according to user id ,query user information.
	 * @param id  user id
	 * @return  User  user value class
	 */
	public User getUserById(Long id);
	
	/**
	 * according to user code ,query user information.
	 * @param userCode  user code
	 * @return User  user value class
	 */
	public User getUserByUserCode(String userCode);
	
	/**
	 * query user information with page
	 * @param query Query user value class
	 * @return User user value class
	 */
	public List<User> queryUserListByQueryBean(UserQuery userQuery);
	
	/**
	 * query user information with page
	 * @param query Query user value class
	 * @return User user value class
	 */
	public PageModel<User> queryUserListPageByQueryBean(UserQuery userQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to user id,delete user information.
	 * @param id  user id
	 * @return true:success;false:fail.
	 */
	public boolean deleteUserById(Long id);
	
	/**
	 * according to user ids,delete users information
	 * @param ids  user ids
	 * @return true:success;false:fail.
	 */
	boolean deleteUserByIds(Long[] ids);
	/**
	 * get user records 
	 * @param query  Query user value class 
	 * @return user count 
	 */
	public int queryUserCountByQueryBean(UserQuery userquery);

	
	
}
