package com.haos.manager.level.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.haos.common.util.date.DateUtil;
import com.haos.common.util.manager.BaseManager;
import com.haos.common.util.page.PageModel;
import com.haos.common.util.page.PageModelImpl;
import com.haos.dao.level.LevelDao;
import com.haos.domain.level.Level;
import com.haos.domain.level.query.LevelQuery;
import com.haos.manager.level.LevelManager;

public class LevelManagerImpl extends BaseManager implements LevelManager {
	

    private static final Logger log = LogManager.getLogger(LevelManagerImpl.class);
	
	private LevelDao levelDao;

	@Override
	public boolean addLevel(final Level level) {
        boolean resultFlag = true;
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    try {
                        boolean insertFlag = false;
                        if (level != null) {
                        	level.setLevelCode(DateUtil.getSerialNumber()); // set level code 
                            insertFlag = levelDao.addLevel(level);
                            
                            if (!insertFlag) {
                                throw new RuntimeException("LevelManagerImpl.addLevel.error.");
                            } 

                        } else {
                            log.debug("LevelManagerImpl.addLevel.parameter.empty.");
                            throw new RuntimeException("LevelManagerImpl.addLevel.parameter.empty.");
                        }
                    } catch (Exception e) {
                        log.error(e);
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("LevelManagerImpl.addLevel.exception:", e);
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
	public boolean updateLevel(Level level) {
        boolean resultFlag = true;
        try {
            if (null != level) {
               
                boolean updateRouteFlag = levelDao.updateLevel(level);
                
                if (!updateRouteFlag) {
                	
                    throw new RuntimeException("LevelManagerImpl.updateLevel.fail.");
                }
            } else {
                log.debug("LevelManagerImpl.updateLevel.parameter.empty.");
                throw new RuntimeException("LevelManagerImpl.updateLevel.parameter.empty.");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}

	@Override
	public Level getLevelById(Long id) {
		return levelDao.getLevelById(id);
	}

	@Override
	public Level getLevelByLevelCode(String levelCode) {
		return levelDao.getLevelByLevelCode(levelCode);
	}

	@Override
	public List<Level> queryLevelListByQueryBean(LevelQuery levelQuery) {
		return levelDao.queryLevelListByQueryBean(levelQuery);
	}

	@Override
	public PageModel<Level> queryLevelListPageByQueryBean(LevelQuery levelQuery,int pageIndex, int pageSize) {
		
        if (null == levelQuery) {
            levelQuery = new LevelQuery();
        }
        int totalItem = levelDao.queryLevelCountByQueryBean(levelQuery);
        
        PageModel<Level> levels = new PageModelImpl<Level>(pageIndex, pageSize);
        
        levels.setTotalItem(totalItem);
        
        levelQuery.setStartRow(levels.getStartRow());
        
        levelQuery.setEndRow(levels.getEndRow());
        
        List<Level> levelList = levelDao.queryLevelListPageByQueryBean(levelQuery);
        
        levels.addAll(levelList);

        return levels;
	}

	@Override
	public boolean deleteLevelById(Long id) {
		
        boolean resultFlag = true;
        try {
            if (null != id && !("").equals(id)) {
                boolean deleteFlag = levelDao.deleteLevelById(id);
                if (!deleteFlag) {
                    throw new RuntimeException("LevelManagerImpl.deleteLevel.fail.");
                }
            } else {
                log.debug("LevelManagerImpl.deleteLevel.empty.");
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            resultFlag = false;
            log.error(e);
        }
        return resultFlag;
	}
	
	public boolean deleteLevelByIds(final Long[]ids){
		
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
								deleteFlag=levelDao.deleteLevelById(id);
							}
							if(!deleteFlag){
								throw new RuntimeException("LevelManagerImpl.deleteLevelByIds(),Fail.");
							}
						}else{
							throw new RuntimeException("LevelManagerImpl.deleteLevelByIds(), ids param null.");
						}
						
					}catch(Exception e){
						//record log
                        log.error(e);
                        // roll back
                        transactionStatus.setRollbackOnly();
                        throw new RuntimeException("LevelManagerImpl.deleteLevelByIds.exception:", e);
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
	public int queryLevelCountByQueryBean(LevelQuery levelQuery) {
		return levelDao.queryLevelCountByQueryBean(levelQuery);
	}

	public void setLevelDao(LevelDao levelDao) {
		this.levelDao = levelDao;
	}
	
	

}
