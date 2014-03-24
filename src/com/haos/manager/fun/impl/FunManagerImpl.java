package com.haos.manager.fun.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.haos.common.util.manager.BaseManager;
import com.haos.common.util.page.PageModel;
import com.haos.common.util.page.PageModelImpl;
import com.haos.dao.fun.FunDao;
import com.haos.domain.fun.Fun;
import com.haos.domain.fun.query.FunQuery;
import com.haos.manager.fun.FunManager;

public class FunManagerImpl extends BaseManager implements FunManager {

	private static final Logger log = LogManager
			.getLogger(FunManagerImpl.class);

	private FunDao funDao;

	@Override
	public boolean addFun(final Fun fun) {
		boolean resultFlag = true;
		try {
			TransactionTemplate template = this
					.getDataSourceTransactionManager();
			template.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(
						TransactionStatus transactionStatus) {
					try {
						boolean insertFlag = false;
						if (fun != null) {
							
							insertFlag = funDao.addFun(fun);

							if (!insertFlag) {
								throw new RuntimeException(
										"FunManagerImpl.addFun.error.");
							} 

						} else {
							log.debug("FunManagerImpl.addFun.parameter.empty.");
							throw new RuntimeException(
									"FunManagerImpl.addFun.parameter.empty.");
						}
					} catch (Exception e) {
						log.error(e);
						transactionStatus.setRollbackOnly();
						throw new RuntimeException(
								"FunManagerImpl.addFun.exception:", e);
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
	public boolean updateFun(Fun fun) {
		boolean resultFlag = true;
		try {
			if (null != fun) {

				boolean updateRouteFlag = funDao.updateFun(fun);

				if (!updateRouteFlag) {

					throw new RuntimeException("FunManagerImpl.updateFun.fail.");
				}
			} else {
				log.debug("FunManagerImpl.updateFun.parameter.empty.");
				throw new RuntimeException(
						"FunManagerImpl.updateFun.parameter.empty.");
			}
		} catch (Exception e) {
			resultFlag = false;
			log.error(e);
			// System.out.println(e);
		}
		return resultFlag;
	}

	@Override
	public Fun getFunById(Long id) {
		return funDao.getFunById(id);
	}

	@Override
	public Fun getFunByFunCode(String funCode) {
		return funDao.getFunByFunCode(funCode);
	}

	@Override
	public List<Fun> queryFunListByQueryBean(FunQuery funQuery) {
		return funDao.queryFunListByQueryBean(funQuery);
	}

	@Override
	public PageModel<Fun> queryFunListPageByQueryBean(FunQuery funQuery,
			int pageIndex, int pageSize) {

		if (null == funQuery) {
			funQuery = new FunQuery();
		}
		int totalItem = funDao.queryFunCountByQueryBean(funQuery);

		PageModel<Fun> funs = new PageModelImpl<Fun>(pageIndex,
				pageSize);

		funs.setTotalItem(totalItem);

		funQuery.setStartRow(funs.getStartRow());

		funQuery.setEndRow(funs.getEndRow());

		List<Fun> funList = funDao.queryFunListPageByQueryBean(funQuery);

		funs.addAll(funList);

		return funs;
	}

	@Override
	public boolean deleteFunById(Long id) {

		boolean resultFlag = true;
		try {
			if (null != id && !("").equals(id)) {
				boolean deleteFlag = funDao.deleteFunById(id);
				if (!deleteFlag) {
					throw new RuntimeException("FunManagerImpl.deleteFun.fail.");
				}
			} else {
				log.debug("FunManagerImpl.deleteFun.empty.");
				throw new RuntimeException("");
			}
		} catch (Exception e) {
			resultFlag = false;
			log.error(e);
		}
		return resultFlag;
	}

	@Override
	public boolean deleteFunByIds(final Long[] ids) {

		// result flag
		boolean resultFlag = true;
		try {
			// deal with many data of transaction, you should execute this
			// transaction.
			TransactionTemplate template = this
					.getDataSourceTransactionManager();
			template.execute(new TransactionCallbackWithoutResult() {

				@Override
				protected void doInTransactionWithoutResult(
						TransactionStatus transactionStatus) {
					try {
						boolean deleteFlag = false; // delete result flag
						// judge on ids whether null or not
						if (ids != null && ids.length > 0) {
							// Traverse array ids
							for (Long id : ids) {
								deleteFlag = funDao.deleteFunById(id);
							}
							if (!deleteFlag) {
								throw new RuntimeException(
										"FunManagerImpl.deleteFunByIds(),Fail.");
							}
						} else {
							throw new RuntimeException(
									"FunManagerImpl.deleteFunByIds(), ids param null.");
						}

					} catch (Exception e) {
						// record log
						log.error(e);
						// roll back
						transactionStatus.setRollbackOnly();
						throw new RuntimeException(
								"FunManagerImpl.deleteFunByIds.exception:", e);
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
	public int queryFunCountByQueryBean(FunQuery funquery) {
		return funDao.queryFunCountByQueryBean(funquery);
	}

	public void setFunDao(FunDao funDao) {
		this.funDao = funDao;
	}

}
