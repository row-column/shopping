package com.shopping.manager.send.impl;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.shopping.common.util.manager.BaseManager;
import com.shopping.common.util.page.PageModel;
import com.shopping.common.util.page.PageModelImpl;
import com.shopping.dao.send.SendDao;
import com.shopping.domain.send.Send;
import com.shopping.domain.send.query.SendQuery;
import com.shopping.manager.send.SendManager;

public class SendManagerImpl extends BaseManager implements SendManager {
	
    private static final Logger log = LogManager.getLogger(SendManagerImpl.class);
	
    /**
     * send information  dao interface
     */
	private SendDao sendDao;
	
	@Override
	public boolean addSend(final Send send) {
        boolean resultFlag = true;
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    try {
                        boolean insertFlag = false;
                        if (send != null) {
                            insertFlag = sendDao.addSend(send); // call  add send method
                            
                            if (!insertFlag) {
                                throw new RuntimeException("SendManagerImpl.addSend.error.");
                            } 

                        } else {
                            log.debug("SendManagerImpl.addSend.parameter.empty.");
                            throw new RuntimeException("SendManagerImpl.addSend.parameter.empty.");
                        }
                    } catch (Exception e) {
                        log.error(e);
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("SendManagerImpl.addSend.exception:", e);
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
	public boolean updateSend(Send send) {
        boolean resultFlag = true;
        try {
            if (null != send) {
                
                boolean updateRouteFlag = sendDao.updateSend(send);  //call update send method
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("SendManagerImpl.updateSend.fail.");
                }
            } else {
                log.debug("SendManagerImpl.updateSend.parameter.empty.");
                throw new RuntimeException("SendManagerImpl.updateSend.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
            //System.out.println(e);
        }
        return resultFlag;
	}

	@Override
	public Send getSendById(Long id) {
		return sendDao.getSendById(id);
	}

	@Override
	public List<Send> getSendBySendCode(String sendCode) {
		return sendDao.getSendBySendCode(sendCode);
	}

	@Override
	public List<Send> querySendListWithUniqueByQueryBean(SendQuery sendQuery) {
		return sendDao.querySendListWithUniqueByQueryBean(sendQuery);
	}
	@Override
	public List<Send> querySendListByQueryBean(SendQuery sendQuery) {
		return sendDao.querySendListByQueryBean(sendQuery);
	}

	@Override
	public PageModel<Send> querySendListPageByQueryBean(SendQuery sendQuery,int pageIndex, int pageSize) {
		
        if (null == sendQuery) {
            sendQuery = new SendQuery();
        }
        int totalItem = sendDao.querySendCountByQueryBean(sendQuery);
        
        PageModel<Send> sends = new PageModelImpl<Send>(pageIndex, pageSize);
        
        sends.setTotalItem(totalItem);
        
        sendQuery.setStartRow(sends.getStartRow());
        
        sendQuery.setEndRow(sends.getEndRow());
        
        List<Send> sendList = sendDao.querySendListPageByQueryBean(sendQuery);
        
        sends.addAll(sendList);

        return sends;
	}

	@Override
	public boolean deleteSendById(Long id) {
		
        boolean resultFlag = true;
        try {
            if (null != id && !("").equals(id)) {
                boolean deleteFlag = sendDao.deleteSendById(id);
                if (!deleteFlag) {
                    throw new RuntimeException("SendManagerImpl.deleteSend.fail.");
                }
            } else {
                log.debug("SendManagerImpl.deleteSend.empty.");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	@Override
	public boolean deleteSendByIds(final Long[]ids){
		
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
								deleteFlag=sendDao.deleteSendById(id);
							}
							if(!deleteFlag){
								throw new RuntimeException("SendManagerImpl.deleteSendByIds(),Fail.");
							}
						}else{
							throw new RuntimeException("SendManagerImpl.deleteSendByIds(), ids param null.");
						}
						
					}catch(Exception e){
						//record log
                        log.error(e);
                        // roll back
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("SendManagerImpl.deleteSendByIds.exception:", e);
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
	public int querySendCountByQueryBean(SendQuery sendQuery) {
		return sendDao.querySendCountByQueryBean(sendQuery);
	}

	public void setSendDao(SendDao sendDao) {
		this.sendDao = sendDao;
	}


}
