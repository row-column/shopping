package com.haos.dao.send.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.send.SendTypeDao;
import com.haos.domain.send.SendType;
import com.haos.domain.send.query.SendTypeQuery;

/**
 * SendType information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class SendTypeDaoImpl extends BaseDao implements SendTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addSendType(SendType sendType) {
		return this.insert("SendType.insert", sendType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateSendType(SendType sendType) {
		return this.update("SendType.update", sendType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SendType getSendTypeById(Long id) {
		return (SendType)this.queryForObject("SendType.getSendTypeById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SendType getSendTypeBySendTypeCode(String sendTypeCode) {
		return (SendType)this.queryForObject("SendType.getSendTypeBySendTypeCode", sendTypeCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SendType> querySendTypeListByQueryBean(SendTypeQuery sendTypeQuery) {
		return this.queryForList("SendType.querySendTypeListByQueryBean",sendTypeQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SendType> querySendTypeListPageByQueryBean(SendTypeQuery sendTypeQuery) {
		return this.queryForList("SendType.querySendTypeListPageByQueryBean", sendTypeQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteSendTypeById(Long id) {
		return this.delete("SendType.deleteSendTypeById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int querySendTypeCountByQueryBean(SendTypeQuery sendTypeQuery) {
		return (Integer)this.queryForObject("SendType.querySendTypeCountByQueryBean", sendTypeQuery);
	}

}
