package com.shopping.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.employee.Employee;
import com.shopping.domain.employee.EmployeeFun;
import com.shopping.domain.employee.query.EmployeeFunQuery;
import com.shopping.domain.fun.Fun;
import com.shopping.manager.employee.EmployeeFunManager;
import com.shopping.manager.fun.FunManager;
import com.shopping.service.employee.EmployeeService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 首页 Action User: YinWei DateTime: 2011-11-29 18:07:32 Version：1.0
 */
public class IndexBackgroudAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	/**
	 * Employee code
	 */
	private String employeeCode;
	/**
	 * Employee password
	 */
	private String password;
	/**
	 * Verify code
	 */
	private String verifyCode;

	/**
	 * Employee information service interface
	 */
	private EmployeeService employeeService;

	/**
	 * Fun information manager interface
	 */
	private FunManager funManager;
	/**
	 * Employee Fun information manager interface
	 */
	private EmployeeFunManager employeeFunManager;

	/**
	 * 默认执行的方法，主要用在登录成功之后
	 * 
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		return SUCCESS;
	}

	/**
	 * 左侧菜单展现页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String frame() throws Exception {
		return SUCCESS;
	}

	public String toLogin() {
		return SUCCESS;
	}

	public String login() {

		if (!StringUtils.isBlank(employeeCode)) {
			ResultCollection employeeResult = employeeService
					.getEmployeeByEmployeeCode(employeeCode); // call
																// getEmployeeByEmployeeCode()
																// method
			if (null != employeeResult && employeeResult.getSuccess()) {
				Employee emp = (Employee) employeeResult.get("employee");
				if (null != emp) {
					if (!StringUtils.isBlank(password)) {
						if (password.equals(emp.getPassword())) {
							if (!StringUtils.isBlank(verifyCode)) {
								if ("xumqvr".equalsIgnoreCase(verifyCode)) {

									StringBuilder sbFunList = dealWithFunList(employeeCode);
									// get session
									Map<String, Object> map = ActionContext
											.getContext().getSession(); 
									// set employeeCode to session
									map.put("employeeCode", employeeCode); 
									// set  employeeName to session
									map.put("employeeName",
											emp.getEmployeeName()); 
									if(null!=sbFunList){
										map.put("employeeFunNavigationList", sbFunList.toString());
									}else{
										addActionError("<font color='red'>该员工未分配权限</font>");
										return INPUT;
									}
								} else {
									addActionError("<font color='red'>验证码不正确</font>");
									return INPUT;
								}
							} else {
								addActionError("<font color='red'>验证码为空</font>");
								return INPUT;
							}

							return SUCCESS;
						} else {
							addActionError("<font color='red'>员工密码不正确</font>");
							return INPUT;
						}

					} else {
						addActionError("<font color='red'>员工密码为空</font>");
						return INPUT;
					}
				} else {
					addActionError("<font color='red'>员工账号不正确</font>");
					return INPUT;
				}
			} else {
				addActionError("<font color='red'>员工账号不正确</font>");
				return INPUT;
			}
		} else {
			addActionError("<font color='red'>员工账号为空</font>");
			return INPUT;

		}

	}

	/**
	 * 退出登录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		Map<String, Object> map = ActionContext.getContext().getSession(); // get
																			// session
																			// object

		if (null != map) {

			if (StringUtils.isNotBlank((String) map.get("employeeCode"))) {
				map.put("employeeCode", null); // set employeeCode to session
			}
			if (StringUtils.isNotBlank((String) map.get("employeeName"))) {
				map.put("employeeName", null); // set employeeName to session
			}
		}

		return SUCCESS;
	}

	/**
	 * 处理用户登录时功能列表内容
	 * 
	 * @param employeeCode
	 * @return
	 */
	private StringBuilder dealWithFunList(String employeeCode) {
		// 创建员工功能查询
		EmployeeFunQuery employeeFunQuery = new EmployeeFunQuery();
		employeeFunQuery.setEmployeeCode(employeeCode); // 设置员工账号
		List<EmployeeFun> employeeFunList = employeeFunManager
				.queryEmployeeFunListByQueryBean(employeeFunQuery);
		StringBuilder sbFunList = new StringBuilder();
		if (null != employeeFunList && employeeFunList.size() > 0) {
			Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
			Map<Integer,Integer> recordsCounter= new HashMap<Integer,Integer>();
			
			for(EmployeeFun employeeFun:employeeFunList){
				Fun fun = funManager.getFunByFunCode(employeeFun.getFunCode());
				Integer recordCounter=recordsCounter.get(fun.getFunSystem());
				if (null==recordCounter) {
					recordCounter=1;
				} else {
					recordCounter++;
				}
				
				recordsCounter.put(fun.getFunSystem(), recordCounter);
			}
			for (EmployeeFun ef : employeeFunList) {

				Fun fun = funManager.getFunByFunCode(ef.getFunCode());
				if (null == fun)
					return null;
				Integer count = counter.get(fun.getFunSystem());
				
				if (null == count) {
					count = 1;
				} else {
					count++;
				}
				
				/**
				 * 如何count=1 将会设置所属模块
				 */
				if (1 == count) {
					sbFunList.append("<h1 class=\"type\">").append(
							"<a href=\"javascript:void(0)\">");
					if (CommonConstant.SYSTEM_MODULE_ONE == fun.getFunSystem()) {
						sbFunList.append("员工&权限管理");
					} else if (CommonConstant.SYSTEM_MODULE_TWO == fun
							.getFunSystem()) {
						sbFunList.append("商品&商品类别管理");
					} else if (CommonConstant.SYSTEM_MODULE_THREE == fun
							.getFunSystem()) {
						sbFunList.append("用户&订单&消费记录管理");
					} else if (CommonConstant.SYSTEM_MODULE_FOUR == fun
							.getFunSystem()) {
						sbFunList.append("配送&配送类别管理");
					} else {

					}

					sbFunList.append("</a>");
					sbFunList.append("</h1>");
					sbFunList
							.append("<div class=\"content\">")
							.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">")
							.append("<tr><td>")
							.append("<img src=\"images/menu_topline.gif\" width=\"182\" height=\"5\" />")
							.append("</td></tr></table>");
					sbFunList.append("<ul class=\"MM\">");

				}

				sbFunList.append("<li><a href=\"" + fun.getUrlName()
						+ "\" target=\"main\">" + fun.getFunName()
						+ "</a></li>");
				
				
				if (count==recordsCounter.get(fun.getFunSystem())) {
					sbFunList.append("</ul>");
					sbFunList.append("</div>");
				}
					
				counter.put(fun.getFunSystem(), count);
			}

			return sbFunList;

		} else {
			return null;

		}

	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setFunManager(FunManager funManager) {
		this.funManager = funManager;
	}

	public void setEmployeeFunManager(EmployeeFunManager employeeFunManager) {
		this.employeeFunManager = employeeFunManager;
	}

}