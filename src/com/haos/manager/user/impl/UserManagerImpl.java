package com.haos.manager.user.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.haos.common.util.manager.BaseManager;
import com.haos.common.util.page.PageModel;
import com.haos.common.util.page.PageModelImpl;
import com.haos.dao.user.UserDao;
import com.haos.domain.user.User;
import com.haos.domain.user.query.UserQuery;
import com.haos.manager.user.UserManager;

public class UserManagerImpl extends BaseManager implements UserManager {
	

    private static final Logger log = LogManager.getLogger(UserManagerImpl.class);
	
	private UserDao userDao;

	@Override
	public boolean addUser(final User user) {
        boolean resultFlag = true;
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    try {
                        boolean insertFlag = false;
                        if (user != null) {
                        	
                            insertFlag = userDao.addUser(user);
                            
                            if (!insertFlag) {
                                throw new RuntimeException("UserManagerImpl.addUser.error.");
                            } else {
                            }

                        } else {
                            log.debug("UserManagerImpl.addUser.parameter.empty.");
                            throw new RuntimeException("UserManagerImpl.addUser.parameter.empty.");
                        }
                    } catch (Exception e) {
                        log.error(e);
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("UserManagerImpl.addUser.exception:", e);
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
	public boolean updateUser(User user) {
        boolean resultFlag = true;
        try {
            if (null != user) {
                user.setUpdateTime(new Date());
                
                boolean updateRouteFlag = userDao.updateUser(user);
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("UserManagerImpl.updateUser.fail.");
                }
            } else {
                log.debug("UserManagerImpl.updateUser.parameter.empty.");
                throw new RuntimeException("UserManagerImpl.updateUser.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean updateUserInfo(User user) {
        boolean resultFlag = true;
        try {
            if (null != user) {
                boolean updateRouteFlag = userDao.updateUserInfo(user);
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("UserManagerImpl.updateUserInfo.fail.");
                }
            } else {
                log.debug("UserManagerImpl.updateUserInfo.parameter.empty.");
                throw new RuntimeException("UserManagerImpl.updateUserInfo.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean updateUserPassword(User user) {
        boolean resultFlag = true;
        try {
            if (null != user) {
                
                boolean updateRouteFlag = userDao.updateUserPassword(user);
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("UserManagerImpl.updateUserPassword.fail.");
                }
            } else {
                log.debug("UserManagerImpl.updateUserPassword.parameter.empty.");
                throw new RuntimeException("UserManagerImpl.updateUserPassword.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public boolean updateUserCommentCount(User user) {
        boolean resultFlag = true;
        try {
            if (null != user) {
                
                boolean updateRouteFlag = userDao.updateUserCommentCount(user);
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("UserManagerImpl.updateUserCommentUser.fail.");
                }
            } else {
                log.debug("UserManagerImpl.updateUserCommentUser.parameter.empty.");
                throw new RuntimeException("UserManagerImpl.updateUserCommentUser.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean updateUserIntegralAndLevel(User user) {
        boolean resultFlag = true;
        try {
            if (null != user) {
                
                boolean updateRouteFlag = userDao.updateUserIntegralAndLevel(user);
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("UserManagerImpl.updateUserIntegralAndLevel.fail.");
                }
            } else {
                log.debug("UserManagerImpl.updateUserIntegralAndLevel.parameter.empty.");
                throw new RuntimeException("UserManagerImpl.updateUserIntegralAndLevel.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	@Override
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

	@Override
	public User getUserByUserCode(String userCode) {
		return userDao.getUserByUserCode(userCode);
	}

	@Override
	public List<User> queryUserListByQueryBean(UserQuery userQuery) {
		return userDao.queryUserListByQueryBean(userQuery);
	}

	@Override
	public PageModel<User> queryUserListPageByQueryBean(UserQuery userQuery,int pageIndex, int pageSize) {
		
		  //���������д���
        if (null == userQuery) {
            userQuery = new UserQuery();
        }
        //��ѯ����
        int totalItem = userDao.queryUserCountByQueryBean(userQuery);
        
        //������ҳ����,��ݵڼ�ҳ��ÿҳ��С
        PageModel<User> users = new PageModelImpl<User>(pageIndex, pageSize);
        
        //��������,ͬʱ��������ʼ�кͽ�����
        users.setTotalItem(totalItem);
        
        //���ÿ�ʼ��
        userQuery.setStartRow(users.getStartRow());
        
        //���������
        userQuery.setEndRow(users.getEndRow());
        
        //����Dao��ҳ����
        List<User> userList = userDao.queryUserListPageByQueryBean(userQuery);
        
        //��ӵ���ҳ������
        users.addAll(userList);

        return users;
	}

	@Override
	public boolean deleteUserById(Long id) {
		
		// ������
        boolean resultFlag = true;
        try {
            if (null != id && !("").equals(id)) {
                // ɾ��
                boolean deleteFlag = userDao.deleteUserById(id);
                if (!deleteFlag) {
                    //ɾ��ʧ�ܣ��׳��쳣
                    throw new RuntimeException("UserManagerImpl.deleteUser.fail.");
                }
            } else {
                //��¼id Ϊnull���׳��쳣
                log.debug("UserManagerImpl.deleteUser.empty.");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean deleteUserByIds(final Long[]ids){
		
		// result flag
        boolean resultFlag = true;
        try {
        	//deal with many data of transaction, you should execute this transaction.
        	TransactionTemplate template =this.getDataSourceTransactionManager();
        	template.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
					try{
						boolean deleteFlag=false; //delete result flag
						//judge on ids whether null or not
						if(ids!=null&&ids.length>0){
							//Traverse array ids
							for(Long id:ids){
								deleteFlag=userDao.deleteUserById(id);
							}
							if(!deleteFlag){
								throw new RuntimeException("UserManagerImpl.deleteUserByIds(),Fail.");
							}
						}else{
							throw new RuntimeException("UserManagerImpl.deleteUserByIds(), ids param null.");
						}
						
					}catch(Exception e){
						//record log
                        log.error(e);
                        // roll back
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("UserManagerImpl.deleteUserByIds.exception:", e);
					}
				}
			});
        }catch(Exception e){
        	resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public int queryUserCountByQueryBean(UserQuery userquery) {
		return userDao.queryUserCountByQueryBean(userquery);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
