package com.shopping.manager.send.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.date.DateUtil;
import com.shopping.common.util.manager.BaseManager;
import com.shopping.common.util.page.PageModel;
import com.shopping.common.util.page.PageModelImpl;
import com.shopping.dao.send.SendTypeDao;
import com.shopping.domain.send.SendType;
import com.shopping.domain.send.query.SendTypeQuery;
import com.shopping.manager.send.SendTypeManager;

public class SendTypeManagerImpl extends BaseManager implements SendTypeManager {

	/**
	 * ��־
	 */
	private static final Logger log = LogManager
			.getLogger(SendTypeManagerImpl.class);

	private SendTypeDao sendTypeDao;

	@Override
	public boolean addSendType(final SendType sendType) {
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
						if (sendType != null) {
							sendType.setSendTypeCode(DateUtil.getSerialNumber()); // set
																					// send
																					// type
																					// code
							sendType.setCreateTime(new Date()); // set create
																// time
							sendType.setUpdateTime(new Date()); // set update
																// time
							sendType.setYn(CommonConstant.YN_NO_DELETE); // set
																			// yn=0

							insertFlag = sendTypeDao.addSendType(sendType);

							if (!insertFlag) {
								throw new RuntimeException(
										"SendTypeManagerImpl.addSendType.error.");
							} else {
							}

						} else {
							log.debug("SendTypeManagerImpl.addSendType.parameter.empty.");
							throw new RuntimeException(
									"SendTypeManagerImpl.addSendType.parameter.empty.");
						}
					} catch (Exception e) {
						log.error(e);
						transactionStatus.setRollbackOnly();
						throw new RuntimeException(
								"SendTypeManagerImpl.addSendType.exception:", e);
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
	public boolean updateSendType(SendType sendType) {
		boolean resultFlag = true;
		try {
			if (null != sendType) {
				sendType.setUpdateTime(new Date()); // set update time

				boolean updateRouteFlag = sendTypeDao.updateSendType(sendType);

				if (!updateRouteFlag) {

					throw new RuntimeException(
							"SendTypeManagerImpl.updateSendType.fail.");
				}
			} else {
				log.debug("SendTypeManagerImpl.updateSendType.parameter.empty.");
				throw new RuntimeException(
						"SendTypeManagerImpl.updateSendType.parameter.empty.");
			}
		} catch (Exception e) {
			resultFlag = false;
			log.error(e);
		}
		return resultFlag;
	}

	@Override
	public SendType getSendTypeById(Long id) {
		return sendTypeDao.getSendTypeById(id);
	}

	@Override
	public SendType getSendTypeBySendTypeCode(String sendTypeCode) {
		return sendTypeDao.getSendTypeBySendTypeCode(sendTypeCode);
	}

	@Override
	public List<SendType> querySendTypeListByQueryBean(
			SendTypeQuery sendTypeQuery) {
		return sendTypeDao.querySendTypeListByQueryBean(sendTypeQuery);
	}

	@Override
	public PageModel<SendType> querySendTypeListPageByQueryBean(
			SendTypeQuery sendTypeQuery, int pageIndex, int pageSize) {

		if (null == sendTypeQuery) {
			sendTypeQuery = new SendTypeQuery();
		}
		int totalItem = sendTypeDao
				.querySendTypeCountByQueryBean(sendTypeQuery);

		PageModel<SendType> sendTypes = new PageModelImpl<SendType>(pageIndex,
				pageSize);

		sendTypes.setTotalItem(totalItem);

		sendTypeQuery.setStartRow(sendTypes.getStartRow());

		sendTypeQuery.setEndRow(sendTypes.getEndRow());

		List<SendType> sendTypeList = sendTypeDao
				.querySendTypeListPageByQueryBean(sendTypeQuery);

		sendTypes.addAll(sendTypeList);

		return sendTypes;
	}

	@Override
	public boolean deleteSendTypeById(Long id) {

		boolean resultFlag = true;
		try {
			if (null != id && !("").equals(id)) {
				boolean deleteFlag = sendTypeDao.deleteSendTypeById(id);
				if (!deleteFlag) {
					throw new RuntimeException(
							"SendTypeManagerImpl.deleteSendType.fail.");
				}
			} else {
				log.debug("SendTypeManagerImpl.deleteSendType.empty.");
				throw new RuntimeException("");
			}
		} catch (Exception e) {
			resultFlag = false;
			log.error(e);
		}
		return resultFlag;
	}

	@Override
	public boolean deleteSendTypeByIds(final Long[] ids) {

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
								deleteFlag = sendTypeDao.deleteSendTypeById(id);
							}
							if (!deleteFlag) {
								throw new RuntimeException(
										"SendTypeManagerImpl.deleteSendTypeByIds(),Fail.");
							}
						} else {
							throw new RuntimeException(
									"SendTypeManagerImpl.deleteSendTypeByIds(), ids param null.");
						}

					} catch (Exception e) {
						// record log
						log.error(e);
						// roll back
						transactionStatus.setRollbackOnly();
						throw new RuntimeException(
								"SendTypeManagerImpl.deleteSendTypeByIds.exception:",
								e);
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
	public int querySendTypeCountByQueryBean(SendTypeQuery sendTypeQuery) {
		return sendTypeDao.querySendTypeCountByQueryBean(sendTypeQuery);
	}

	public void setSendTypeDao(SendTypeDao sendTypeDao) {
		this.sendTypeDao = sendTypeDao;
	}

}
