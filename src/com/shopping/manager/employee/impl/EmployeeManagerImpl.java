package com.shopping.manager.employee.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.shopping.common.util.manager.BaseManager;
import com.shopping.common.util.page.PageModel;
import com.shopping.common.util.page.PageModelImpl;
import com.shopping.dao.employee.EmployeeDao;
import com.shopping.domain.employee.Employee;
import com.shopping.domain.employee.query.EmployeeQuery;
import com.shopping.manager.employee.EmployeeManager;

public class EmployeeManagerImpl extends BaseManager implements EmployeeManager {
	

    private static final Logger log = LogManager.getLogger(EmployeeManagerImpl.class);
	
	private EmployeeDao employeeDao;

	@Override
	public boolean addEmployee(final Employee employee) {
        boolean resultFlag = true;
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    try {
                        boolean insertFlag = false;
                        if (employee != null) {
                            insertFlag = employeeDao.addEmployee(employee);
                            
                            if (!insertFlag) {
                                throw new RuntimeException("EmployeeManagerImpl->addEmployee() error!!");
                            }

                        } else {
                            log.debug("EmployeeManagerImpl->addEmployee() employee empty!!");
                            throw new RuntimeException("EmployeeManagerImpl->addEmployee() employee empty!!");
                        }
                    } catch (Exception e) {
                        log.error(e);
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("EmployeeManagerImpl->addEmployee() exception:", e);
                    }
                }


            });

        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
        boolean resultFlag = true;
        try {
            if (null != employee) {
                employee.setUpdateTime(new Date()); //set update time
                
                boolean updateRouteFlag = employeeDao.updateEmployee(employee);  //call updateEmployee()method
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("EmployeeManagerImpl->updateEmployee()fail!!");
                }
            } else {
                log.debug("EmployeeManagerImpl->updateEmployee() employee empty!!");
                throw new RuntimeException("EmployeeManagerImpl->updateEmployee() employee empty!!");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean updateEmployeeStatus(Employee employee) {
        boolean resultFlag = true;
        try {
            if (null != employee) {
                
                boolean updateRouteFlag = employeeDao.updateEmployeeStatus(employee);  //call updateEmployeeStatus()method
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("EmployeeManagerImpl->updateEmployeeStatus()fail!!");
                }
            } else {
                log.debug("EmployeeManagerImpl->updateEmployeeStatus() employee empty!!");
                throw new RuntimeException("EmployeeManagerImpl->updateEmployeeStatus() employee empty!!");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		if(null!=id){
			return employeeDao.getEmployeeById(id); // call getEmployeeById() method
		}else{
			throw new RuntimeException("EmployeeManagerImpl->getEmployeeById() id empty");
		}
	}
	
	@Override
	public Employee getEmployeeByEmployeeCode(String employeeCode) {
		if(!StringUtils.isBlank(employeeCode)){
			return employeeDao.getEmployeeByEmployeeCode(employeeCode);  //call getEmployeeByEmployeeCode() method
		}else{
			throw new RuntimeException("EmployeeManagerImpl->getEmployeeByEmployeeCode() employee code empty");
		}
	}
	
	@Override
	public List<Employee> queryEmployeeListByQueryBean(EmployeeQuery employeeQuery) {
		if(null!=employeeQuery){
			return employeeDao.queryEmployeeListByQueryBean(employeeQuery); //call queryEmployeeListByQueryBean() method
		}else{
			throw new RuntimeException("EmployeeManagerImpl->queryEmployeeListByQueryBean() employee query empty");
		}
	}

	@Override
	public PageModel<Employee> queryEmployeeListPageByQueryBean(EmployeeQuery employeeQuery,int pageIndex, int pageSize) {
		
        if (null == employeeQuery) {
            employeeQuery = new EmployeeQuery();
        }
        int totalItem = employeeDao.queryEmployeeCountByQueryBean(employeeQuery);
        
        PageModel<Employee> employees = new PageModelImpl<Employee>(pageIndex, pageSize);
        
        employees.setTotalItem(totalItem);
        
        employeeQuery.setStartRow(employees.getStartRow());
        
        employeeQuery.setEndRow(employees.getEndRow());
        
        List<Employee> employeeList = employeeDao.queryEmployeeListPageByQueryBean(employeeQuery);
        
        employees.addAll(employeeList);

        return employees;
	}

	@Override
	public boolean deleteEmployeeById(Long id) {
		
        boolean resultFlag = true;
        try {
            if (null != id && !("").equals(id)) {
                boolean deleteFlag = employeeDao.deleteEmployeeById(id);
                if (!deleteFlag) {
                    throw new RuntimeException("EmployeeManagerImpl->deleteEmployee()fail!!");
                }
            } else {
                log.debug("EmployeeManagerImpl->deleteEmployee() empty!");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	
	@Override
	public boolean deleteEmployeeByIds(Long ids[]) {
		
        boolean resultFlag = true;
        try {
        	 boolean deleteFlag=false;
            if (null != ids && ids.length>1) {
            	for(Long id:ids){
            	  deleteFlag= employeeDao.deleteEmployeeById(id);
            	}
               
                if (!deleteFlag) {
                    throw new RuntimeException("EmployeeManagerImpl->deleteEmployee() fail!!");
                }
            } else {
                log.debug("EmployeeManagerImpl->deleteEmployee() empty!!");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public int queryEmployeeCountByQueryBean(EmployeeQuery employeeQuery) {
		if(null!=employeeQuery){
			return employeeDao.queryEmployeeCountByQueryBean(employeeQuery);
		}else{
			throw new RuntimeException("EmployeeManagerImpl->queryEmployeeCountByQueryBean() employee query empty");
		}
	}

	@Override
	public List<Employee> queryEmployeeListBySendEmployee(String isEmployeeFlag) {
		return employeeDao.queryEmployeeListBySendEmployee(isEmployeeFlag);
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	
}
