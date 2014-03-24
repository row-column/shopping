package com.haos.manager.employee.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.manager.BaseManager;
import com.haos.common.util.page.PageModel;
import com.haos.common.util.page.PageModelImpl;
import com.haos.dao.employee.EmployeeFunDao;
import com.haos.domain.employee.EmployeeFun;
import com.haos.domain.employee.query.EmployeeFunQuery;
import com.haos.manager.employee.EmployeeFunManager;

public class EmployeeFunManagerImpl extends BaseManager implements EmployeeFunManager {
	
    private static final Logger log = LogManager.getLogger(EmployeeFunManagerImpl.class);
	
	private EmployeeFunDao employeeFunDao;

	@Override
	public boolean addEmployeeFun(final EmployeeFun employeeFun) {
        boolean resultFlag = true;
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    try {
                        boolean insertFlag = false;
                        if (employeeFun != null) {
                            employeeFun.setCreateTime(new Date());
                            employeeFun.setUpdateTime(new Date());
                            employeeFun.setYn(CommonConstant.YN_NO_DELETE);
                            insertFlag = employeeFunDao.addEmployeeFun(employeeFun);
                            
                            if (!insertFlag) {
                                throw new RuntimeException("EmployeeFunManagerImpl.addEmployeeFun.error.");
                            }

                        } else {
                            log.debug("EmployeeFunManagerImpl.addEmployeeFun.parameter.empty.");
                            throw new RuntimeException("EmployeeFunManagerImpl.addEmployeeFun.parameter.empty.");
                        }
                    } catch (Exception e) {
                        log.error(e);
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("EmployeeFunManagerImpl.addEmployeeFun.exception:", e);
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
	public boolean updateEmployeeFun(EmployeeFun employeeFun) {
        boolean resultFlag = true;
        try {
            if (null != employeeFun) {
                employeeFun.setUpdateTime(new Date());
                
                boolean updateRouteFlag = employeeFunDao.updateEmployeeFun(employeeFun);
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("EmployeeFunManagerImpl.updateEmployeeFun.fail.");
                }
            } else {
                log.debug("EmployeeFunManagerImpl.updateEmployeeFun.parameter.empty.");
                throw new RuntimeException("EmployeeFunManagerImpl.updateEmployeeFun.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public EmployeeFun getEmployeeFunById(Long id) {
		return employeeFunDao.getEmployeeFunById(id);
	}

	@Override
	public EmployeeFun getEmployeeFunByEmployeeFunCode(String employeeFunCode) {
		return employeeFunDao.getEmployeeFunByEmployeeFunCode(employeeFunCode);
	}

	@Override
	public List<EmployeeFun> queryEmployeeFunListByQueryBean(EmployeeFunQuery employeeFunQuery) {
		return employeeFunDao.queryEmployeeFunListByQueryBean(employeeFunQuery);
	}

	@Override
	public PageModel<EmployeeFun> queryEmployeeFunListPageByQueryBean(EmployeeFunQuery employeeFunQuery,int pageIndex, int pageSize) {
		
        if (null == employeeFunQuery) {
            employeeFunQuery = new EmployeeFunQuery();
        }
        int totalItem = employeeFunDao.queryEmployeeFunCountByQueryBean(employeeFunQuery);
        
        PageModel<EmployeeFun> employeeFuns = new PageModelImpl<EmployeeFun>(pageIndex, pageSize);
        
        employeeFuns.setTotalItem(totalItem);
        
        employeeFunQuery.setStartRow(employeeFuns.getStartRow());
        
        employeeFunQuery.setEndRow(employeeFuns.getEndRow());
        
        List<EmployeeFun> employeeFunList = employeeFunDao.queryEmployeeFunListPageByQueryBean(employeeFunQuery);
        
        employeeFuns.addAll(employeeFunList);

        return employeeFuns;
	}

	@Override
	public boolean deleteEmployeeFunById(Long id) {
		
        boolean resultFlag = true;
        try {
            if (null != id && !("").equals(id)) {
                boolean deleteFlag = employeeFunDao.deleteEmployeeFunById(id);
                if (!deleteFlag) {
                    throw new RuntimeException("EmployeeFunManagerImpl.deleteEmployeeFun.fail.");
                }
            } else {
                log.debug("EmployeeFunManagerImpl.deleteEmployeeFun.empty.");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean deleteEmployeeFunByEmployeeCode(String employeeCode) {
		
        boolean resultFlag = true;
        try {
            if (!StringUtils.isBlank(employeeCode)) {
                boolean deleteFlag = employeeFunDao.deleteEmployeeFunByEmployeeCode(employeeCode);
                if (!deleteFlag) {
                    throw new RuntimeException("EmployeeFunManagerImpl.deleteEmployeeFunByEmployeeCode.fail.");
                }
            } else {
                log.debug("EmployeeFunManagerImpl.deleteEmployeeFunByEmployeeCode.empty.");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public int queryEmployeeFunCountByQueryBean(EmployeeFunQuery employeeFunquery) {
		return employeeFunDao.queryEmployeeFunCountByQueryBean(employeeFunquery);
	}

	public void setEmployeeFunDao(EmployeeFunDao employeeFunDao) {
		this.employeeFunDao = employeeFunDao;
	}
	
	

}
