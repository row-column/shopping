package com.haos.web.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.commodity.query.CommodityCategoryQuery;
import com.haos.domain.user.User;
import com.haos.service.commodity.CommodityCategoryService;
import com.haos.service.commodity.CommodityService;
import com.haos.service.user.UserService;
import com.opensymphony.xwork2.ActionContext;


public class IndexFrontAction extends BaseAction {                
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * commodity information service interface
	 */
	private CommodityService commodityService;                             

	/**
	 * commodity category information service interface         
	 */
	private CommodityCategoryService commodityCategoryService;
	
	/**
	 *  user information service interface 
	 */
	private UserService  userService;

	//user code
	private String userCode;
	//password
	private String password;
	
	Map<String,Object> map=null;

    
    public String execute() throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        CommodityCategoryQuery commodityCategoryQuery= new CommodityCategoryQuery(); // new commodityCategoryQuery object
        commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
        setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery)); //call  query commodity category list method
        setValueStack(commodityService.queryCommodityListByLatestTime()); //call query commodity by latest time
        setValueStack(commodityService.queryCommodityListBySalesCount()); //call query commodity by sales count descent
        setValueStack(commodityService.queryCommodityListByCommentCountAndSalesCount()); //call query commodity by comment count and sales cont descend
        setValueStack(commodityService.queryCommodityListByCategoryCodeAndCommentCountAndSalesCount()); //call query commodity by category code ascend and comment count and sales count descend
        
        return SUCCESS;
    }

   
    public String frame() throws Exception {
        return SUCCESS;
    }
    
    /**
     *  to Register Page
     * @return
     */
    public String toRegister(){
    	                                                                                                    
    	 CommodityCategoryQuery commodityCategoryQuery= new CommodityCategoryQuery(); // new commodityCategoryQuery object
         commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
         setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery)); //call  query commodity category list method
         setValueStack(commodityService.queryCommodityListByLatestTime()); //call query commodity by latest time
         setValueStack(commodityService.queryCommodityListBySalesCount()); //call query commodity by sales count descent
    	
    	return "success";
    }
    
    /**
     *  to Login Page
     * @return
     */
    public String toLogin(){
    	                                                                                                    
    	 CommodityCategoryQuery commodityCategoryQuery= new CommodityCategoryQuery(); // new commodityCategoryQuery object
         commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
         setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery)); //call  query commodity category list method
         setValueStack(commodityService.queryCommodityListByLatestTime()); //call query commodity by latest time
         setValueStack(commodityService.queryCommodityListBySalesCount()); //call query commodity by sales count descent
    	
    	return SUCCESS;
    }
    
    /**
     *  user login method
     * @return
     */
    public String login(){
    	if(!StringUtils.isBlank(userCode)){
    		 ResultCollection userResult=userService.getUserByUserCode(userCode);
    		 if(null!=userResult){
    			 if(userResult.getSuccess()){
    				 User u=(User)userResult.get("user");
    				 if(null!=u){
                         if(password.equals(u.getPassword())){
                        	 map=ActionContext.getContext().getSession(); //get session
                        	 map.put("userCode",u.getUserCode()); //put userCode to session
                        	 map.put("userName",u.getUserName()); //put userName to session
                        	 u.setPassword(null); //set password null
                        	 map.put("loginUser",u); //put userName to session
                        	 CommodityCategoryQuery commodityCategoryQuery= new CommodityCategoryQuery(); // new commodityCategoryQuery object
                             commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
                             setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery)); //call  query commodity category list method
                             setValueStack(commodityService.queryCommodityListByLatestTime()); //call query commodity by latest time
                             setValueStack(commodityService.queryCommodityListBySalesCount()); //call query commodity by sales count descent
                        	   
                        	 return SUCCESS;      
                         }else{
                        	 addActionError("<font color='red'>密码不正确</font>");
                        	 return INPUT;
                                             	
                         }
    					 
    				 }else{
    					 addActionError("<font color='red'>用户名不正确</font>");
    					 return INPUT;
    				 }
    			 }
    		 }else{
    			 addActionError("<font color='red'>系统出现异常，请联系管理员</font>");
    			 //error
    			 return INPUT;
    		 }
    	}else{
    		 addActionError("<font color='red'>用户名为空</font>");
    		//user code  null1
    		return INPUT;
    	}
    	
    	return SUCCESS;
    }
    
    
    /**
     * user logout method 
     * @return
     */
    public String logout() throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        CommodityCategoryQuery commodityCategoryQuery= new CommodityCategoryQuery(); // new commodityCategoryQuery object
        commodityCategoryQuery.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
        setValueStack(commodityCategoryService.queryCommodityCategoryListByQueryBean(commodityCategoryQuery)); //call  query commodity category list method
        setValueStack(commodityService.queryCommodityListByLatestTime()); //call query commodity by latest time
        setValueStack(commodityService.queryCommodityListBySalesCount()); //call query commodity by sales count descent
        map=ActionContext.getContext().getSession();
        
        if(null!=map.get("userName")){
        	map.put("userName",null);
        	
        }
        if(null!=map.get("userCode")){
        	map.put("userCode", null);
        }
        
        if(null!=map.get("loginUser")){
        	map.put("loginUser", null);
        }

        return SUCCESS;
    }


	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}


	public void setCommodityCategoryService(
			CommodityCategoryService commodityCategoryService) {
		this.commodityCategoryService = commodityCategoryService;
	}

	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
    

}