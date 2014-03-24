package com.haos.service.server.employee.impl;

import java.util.Date;

import javax.jws.WebService;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.haos.common.util.CommonConstant;
import com.haos.domain.employee.Employee;
import com.haos.manager.employee.EmployeeManager;
import com.haos.service.server.employee.EmployeeInfoWebService;

/**
 * 员工信息WebService接口
 * 
 * @author Helios
 * 
 */
@WebService(endpointInterface = "com.haos.service.server.employee.EmployeeInfoWebService", serviceName = "employeeInfoService")
public class EmployeeInfoWebServiceImpl implements EmployeeInfoWebService {

	private static final Logger log = LogManager
			.getLogger(EmployeeInfoWebServiceImpl.class);

	/**
	 * 员工信息manager接口
	 */
	private EmployeeManager employeeManager;

	@Override
	public boolean registerEmployee(String employeeCode, String employeeName,
			String password, int sex, String mobile, String email,
			String address, String zipCode, String idCard) {
		/**
		 * 创建员工对象并设置相关信息
		 */
		Employee emp = new Employee();
		emp.setEmployeeCode(employeeCode);
		emp.setEmployeeName(employeeName);
		emp.setPassword(password);
		emp.setSex(sex);
		emp.setMobile(mobile);
		emp.setEmail(email);
		emp.setAddress(address);
		emp.setZipCode(zipCode);
		emp.setIdCard(idCard);
		emp.setReqDate(new Date());
		emp.setCreateTime(new Date());
		emp.setUpdateTime(new Date());
		emp.setStatus(CommonConstant.STATUS_DISAVAILABLE); // set employee
															// status
		emp.setYn(CommonConstant.YN_NO_DELETE); // set yn-0

		/**
		 * 调用添加员工方法
		 */
		return employeeManager.addEmployee(emp);

	}

	@Override
	public String loginEmployee(String employeeCode, String password) {

		String resultFlag = null;
		/**
		 * 判断员工账号和密码是否为空
		 */
		if (StringUtils.isNotBlank(employeeCode)
				&& StringUtils.isNotBlank(password)) {
			/**
			 * 调用根据员工账号 取得员工信息方法w
			 */
			Employee emp = employeeManager
					.getEmployeeByEmployeeCode(employeeCode);
			/**
			 * 判断员工输入的密码是否正确
			 */
			if (null != emp && StringUtils.isNotBlank(emp.getEmployeeCode())) {
				if(CommonConstant.YN_NO_DELETE==emp.getStatus()) {
					resultFlag = "员工账号不正确";
				}else {
					if (password.equals(emp.getPassword())) {
						resultFlag = emp.getEmployeeName();
					} else {
						resultFlag = "员工密码不正确";
					}
				}
			} else {
				resultFlag = "员工账号不正确";
			}

		} else {
			log.error("EmployeeInfoWebServicesImpl-->>loginEmployee()---->>>> employeeCode and  password paramter null!");
		}

		return resultFlag;
	}

	@Override
	public boolean updateEmployeePassword(String employeeCode, String password) {
		if (StringUtils.isNotBlank(employeeCode)
				&& StringUtils.isNotBlank(password)) {

			/**
			 * 调用根据员工账号 取得员工信息方法
			 */
			Employee emp = employeeManager
					.getEmployeeByEmployeeCode(employeeCode);
			/**
			 * 判断员工输入的密码是否正确
			 */
			if (null != emp && StringUtils.isNotBlank(emp.getEmployeeCode())) {
				if (password.equals(emp.getPassword())) {
					return true;
				} else {
					emp.setPassword(password);
					return employeeManager.updateEmployee(emp);
				}
			} else {
				return false;
			}

		} else {
			log.error("EmployeeInfoWebServicesImpl-->>updateEmployeePassword()---->>>> employeeCode and  password paramter null!");
		}

		return false;
	}

	@Override
	public boolean checkEmployeeCode(String employeeCode) {
		/**
		 * 判断员工账号和密码是否为空
		 */
		if (StringUtils.isNotBlank(employeeCode)) {
			/**
			 * 调用根据员工账号 取得员工信息方法
			 */
			Employee emp = employeeManager
					.getEmployeeByEmployeeCode(employeeCode);
			/**
			 * 判断员工输入的账号是否正确
			 */
			if (null != emp && StringUtils.isNotBlank(emp.getEmployeeCode())) {
				return true;
			} else {
				return false;
			}

		} else {
			log.error("EmployeeInfoWebServicesImpl-->>checkEmployeeCode()---->>>> employeeCode paramter null!");
		}

		return false;
	}

	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

}
