package com.shopping.web.action.user;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.user.User;
import com.shopping.domain.user.query.UserQuery;
import com.shopping.service.user.UserService;
import com.opensymphony.xwork2.ActionContext;


/**
 * User information  action
 * @author WangYue
 *
 */
public class UserAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(UserAction.class);
    
    /**
     * User information Service interface
     */
    private UserService userService;
    /**
     * User information query value class
     */
    private UserQuery userQuery;
    
    /**
     * User information
     */
    private User user;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;

    /**
     * To user information list page
     *
     * @return
     */
    public String userMain() {
        if (null == userQuery) {
            userQuery = new UserQuery();
        }
        userQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        setValueStack(userService.queryUserListPageByQueryBean(userQuery, page, pageSize)); //call queryUserListPageByQueryBean()method
        return "userMain";
    }

    /**
     * 
     * To add user information page
     * @return
     */
    public String toAddUser() {
        this.setValueStack(null);
        return "toAddUser";
    }

    /**
     * 
     * To update user information page
     * @return
     */
    public String toUpdateUser() {
    	
        if (null != user) {
            ResultCollection result = userService.getUserById(user.getId()); //call getUserById()method
            setValueStack(result);
        } else {
            log.error("UserAction!toUpdateUser() error!");
        }
        return "toUpdateUser";
    }
    
    /**
     * 
     * To delete user information page
     * @return
     */
    public String toDeleteUser() {
    	
        if (null != user) {
            setValueStack(userService.getUserById(user.getId()));  //call getUserById()method
        } else {
            log.error("UserAction!toDeleteUser() error!");
        }
        return "toDeleteUser";
    }
    
    /**
     * 
     * To user information page
     * @return
     */
    public String myInfo() {
    	Map<String,Object> map=ActionContext.getContext().getSession(); //get session
    	String userCode=(String)map.get("userCode"); // get user code from session
    	if(!StringUtils.isBlank(userCode)){
    		setValueStack(userService.getUserByUserCode(userCode)); //call getUserByUserCode()method
    	}else{
    		return ERROR;
    	}
        return SUCCESS;
    }
    
    /**
     * 
     * To user password information page
     * @return
     */
    public String updateUserPassword() {
    	Map<String,Object> map=ActionContext.getContext().getSession();   //get session
    	String userCode=(String)map.get("userCode"); //get user code from session
    	if(StringUtils.isBlank(userCode)){
    		return ERROR;
    	}
        return SUCCESS;
    }

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserQuery getUserQuery() {
		return userQuery;
	}

	public void setUserQuery(UserQuery userQuery) {
		this.userQuery = userQuery;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
