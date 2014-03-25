package com.shopping.service.user;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.user.User;
import com.shopping.domain.user.query.UserQuery;

/**
 * User information service interface
 * @author WangYue
 *
 */
public interface UserService {

	/**
	 * add user information
	 * @param user   user value class
	 * @return Result 
	 */
	public ResultCollection addUser(User user);
	
	/**
	 * update user information
	 * @param user  user value class
	 * @return Result 
	 */
	public ResultCollection updateUser(User user);
	
	/**
	 * update user information
	 * @param user  user value class
	 * @return Result 
	 */
	public ResultCollection updateUserInfo(User user);
	
	/**
	 * update user password
	 * @param user  user value class
	 * @return Result 
	 */
	public ResultCollection updateUserPassword(User user);
	
	/**
	 * according to user id ,query user information.
	 * @param id  user id
	 * @return  Result
	 */
	public ResultCollection getUserById(Long id);
	
	/**
	 * according to user code ,query user information.
	 * @param userCode  user code
	 * @return Result
	 */
	public ResultCollection getUserByUserCode(String userCode);
	
	/**
	 * query user information with page
	 * @param query Query user value class
	 * @return Result
	 */
	public ResultCollection queryUserListByQueryBean(UserQuery userQuery);
	
	/**
	 * query user information with page
	 * @param query Query user value class
	 * @return Result
	 */
	public ResultCollection queryUserListPageByQueryBean(UserQuery userQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to user id,delete user information.
	 * @param id  user id
	 * @return Result .
	 */
	public ResultCollection deleteUserById(Long id);

	/**
	 * according to user ids,delete users information.
	 * @param ids user ids
	 * @return Result
	 */
	public ResultCollection deleteUserByIds(Long[] ids);
	
}
