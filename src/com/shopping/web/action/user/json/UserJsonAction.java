package com.shopping.web.action.user.json;

import com.opensymphony.xwork2.ActionContext;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.user.User;
import com.shopping.service.user.UserService;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.Map;


/**
 * User Information JsonAction
 * @author WangYue
 *
 */
public class UserJsonAction extends BaseAction {
   // private final static Log logger = LogFactory.getLog(UserJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * user information service interface
     */
    private UserService userService;
    
    /**
     * json result
     */
    private String result;
    
    /**
     * result msg
     */
    private String resultMsg;
    
    /**
     * user value
     */
    private User user;
    
    /**
     * ids array
     */
    private Long[]ids;
    
    /**
     * add user method
     *
     * @return
     */
    public String addUser() {
        if (null != user) {

        	user.setReqDate(new Date()); //set register time
        	user.setCreateTime(new Date()); //set create time
        	user.setUpdateTime(new Date()); //set update time
            ResultCollection serviceResult = userService.addUser(user); //call addUser()method
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false*" + (String) serviceResult.get("resultMsg");
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * update user method
     *
     * @return
     */
    public String updateUser() {
        if (null != user) {

        	user.setUpdateTime(new Date()); //set update time
            ResultCollection serviceResult = userService.updateUser(user); //call updateUser()method
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * delete user method
     *
     * @return
     */
    public String deleteUser() {
        if (null != user.getId() && user.getId().intValue() > 0) {
        	
            ResultCollection serviceResult = userService.deleteUserById(user.getId()); //call deleteUserById()method
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }
    
    /**
     * delete Users method
     *
     * @return
     */
    public String deleteUsers() {
        if (ids != null && ids.length > 1) {
        	
            ResultCollection serviceResult = userService.deleteUserByIds(ids); //call deleteUserByIds()method
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }
    
    
    /**
     * check user code
     *
     * @return
     */
	public String checkUserCode() {
		if (null != user) {

			ResultCollection serviceResult = userService.getUserByUserCode(user
					.getUserCode());
			if (null != serviceResult&&serviceResult.getSuccess()) {
					User user = (User) serviceResult.get("user");
					if (null != user) {
						if (user.getUserCode() != null) {
							result = "exist";
						} else {
							result = "ok";
						}
					} else {
						result = "ok";
					}

				} else {
					result = "error";
				}

		} else {
			result = "error";
		}
		return "out";
	}
	
	
	/**
     *  user register method
     *
     * @return
     */
    public String register() {
        if (null != user) {

        	//用户注册的时候 默认将用户姓名设置成用户账号
        	if(StringUtils.isBlank(user.getUserName())){
        		user.setUserName(user.getUserCode());
        	}
            ResultCollection serviceResult = userService.addUser(user);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false*" + (String) serviceResult.get("resultMsg");
            }
        } else {
            result = "false";
        }
        return "out";
    }
    
    /**
     * update user information
     * @return
     */
    public String updateUserInfo(){
    	Map<String,Object> map=ActionContext.getContext().getSession();
    	String userCode=(String) map.get("userCode");
    	if(!StringUtils.isBlank(userCode)){
    		if(null!=user){
    			user.setUserCode(userCode);  //set user  code
    			ResultCollection userServiceResult=userService.updateUserInfo(user); //call updateUserInfo()method
    			if(null!=userServiceResult&&userServiceResult.getSuccess()){
    				result="true";
    			}else{
    				result="false";
    			}
    			
    		}else{
    			result="false";
    		}
    		
    	}else{
    		result="false*login";
    	}
    	
    	return "out";
    	
    }
    
    /**
     * update password information
     * @return
     */
    public String updateUserPassword(){
    	Map<String,Object> map=ActionContext.getContext().getSession(); //get session
    	String userCode= (String) map.get("userCode");
    	if(!StringUtils.isBlank(userCode)){
    		ResultCollection userServiceResult=userService.getUserByUserCode(userCode);  //call getUserByUserCode()method
    		if(null!=userServiceResult&&userServiceResult.getSuccess()){
    			User u=(User)userServiceResult.get("user");
    			if(u!=null&&!StringUtils.isBlank(user.getOldPassword())){
    				if(user.getOldPassword().equals(u.getPassword())){
    					user.setUserCode(userCode);
    					ResultCollection userUpdateServiceResult=userService.updateUserPassword(user);  //call updateUser() method
    					if(null!=userUpdateServiceResult&&userUpdateServiceResult.getSuccess()){
    						result="true";
    					}else{
    						result="false";
    					}
    				}else{
    					result="false*原密码不正确";
    				}
    			}else{
    				result="false*用户账号不正确";
    			}
    			
    			
    		}else{
    			result="false*系统出现异常，请联系管理员";
    		}
    		
    	}else{
    		result="false*login";
    	}
    	
    	return "out";
    	
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

}
