package com.shopping.service.server.employee;

import java.util.Date;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 员工信息WebService接口
 * 
 * @author Helios
 * 
 */
@WebService(targetNamespace = "http://www.shopping.com")
public interface EmployeeInfoWebService {

	/**
	 * 注册员工信息方法
	 * 
	 * @param employeeCode
	 *            员工账号
	 * @param employeeName
	 *            员工名字
	 * @param password
	 *            员工密码
	 * @param sex
	 *            员工性别
	 * @param mobile
	 *            员工手机电话
	 * @param email
	 *            员工邮箱
	 * @param address
	 *            员工地址
	 * @param idCard
	 *            员工身份证
	 * @return true/false
	 */
	public boolean registerEmployee(
			@WebParam(name = "employeeCode") String employeeCode,
			@WebParam(name = "employeeName") String employeeName,
			@WebParam(name = "password") String password,
			@WebParam(name = "sex") int sex,
			@WebParam(name = "mobile") String mobile,
			@WebParam(name = "email") String email,
			@WebParam(name = "address") String address,
			@WebParam(name = "zipCode") String zipCode,
			@WebParam(name = "idCard") String idCard);

	/**
	 * 员工登陆方法
	 * 
	 * @param employeeCode
	 *            员工账号
	 * @param password
	 *            员工密码
	 * @return
	 */
	public String loginEmployee(
			@WebParam(name = "employeeCode") String employeeCode,
			@WebParam(name = "password") String password);

	/**
	 * 更新员工密码
	 * 
	 * @param employeeCode
	 *            员工账号
	 * @param password
	 *            员工密码
	 * @return true/false
	 */
	public boolean updateEmployeePassword(
			@WebParam(name = "employeeCode") String employeeCode,
			@WebParam(name = "password") String password);

	/**
	 * 检查员工账号是否存在方法
	 * 
	 * @param employeeCode
	 *            员工账号
	 * @return true/false
	 */
	public boolean checkEmployeeCode(
			@WebParam(name = "employeeCode") String employeeCode);

}
