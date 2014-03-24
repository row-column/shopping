package com.haos.dao.carrier.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.carrier.CarrierDao;
import com.haos.domain.carrier.Carrier;
import com.haos.domain.carrier.query.CarrierQuery;

/**
 * Carrier information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class CarrierDaoImpl extends BaseDao implements CarrierDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addCarrier(Carrier carrier) {
		return this.insert("Carrier.insert", carrier);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateCarrier(Carrier carrier) {
		return this.update("Carrier.update", carrier);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Carrier getCarrierById(Long id) {
		return (Carrier)this.queryForObject("Carrier.getCarrierById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Carrier getCarrierByCarrierCode(String carrierCode) {
		return (Carrier)this.queryForObject("Carrier.getCarrierByCarrierCode", carrierCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrier> queryCarrierListByQueryBean(CarrierQuery carrierQuery) {
		return this.queryForList("Carrier.queryCarrierListByQueryBean",carrierQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrier> queryCarrierListPageByQueryBean(CarrierQuery carrierQuery) {
		return this.queryForList("Carrier.queryCarrierListPageByQueryBean", carrierQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteCarrierById(Long id) {
		return this.delete("Carrier.deleteCarrierById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryCarrierCountByQueryBean(CarrierQuery carrierQuery) {
		return (Integer)this.queryForObject("Carrier.queryCarrierCountByQueryBean", carrierQuery);
	}

}
