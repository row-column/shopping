package com.haos.dao.send.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.send.SendDao;
import com.haos.domain.send.Send;
import com.haos.domain.send.query.SendQuery;

/**
 * Send information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class SendDaoImpl extends BaseDao implements SendDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addSend(Send send) {
		return this.insert("Send.insert", send);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateSend(Send send) {
		return this.update("Send.update", send);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Send getSendById(Long id) {
		return (Send)this.queryForObject("Send.getSendById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Send> getSendBySendCode(String sendCode) {
		return this.queryForList("Send.getSendBySendCode", sendCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Send> querySendListWithUniqueByQueryBean(SendQuery sendQuery) {
		return this.queryForList("Send.querySendListWithUniqueByQueryBean",sendQuery);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Send> querySendListByQueryBean(SendQuery sendQuery) {
		return this.queryForList("Send.querySendListByQueryBean",sendQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Send> querySendListPageByQueryBean(SendQuery sendQuery) {
		return this.queryForList("Send.querySendListPageByQueryBean", sendQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteSendById(Long id) {
		return this.delete("Send.deleteSendById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int querySendCountByQueryBean(SendQuery sendQuery) {
		return (Integer)this.queryForObject("Send.querySendCountByQueryBean", sendQuery);
	}

}
