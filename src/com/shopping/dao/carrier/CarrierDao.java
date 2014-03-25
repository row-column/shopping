package com.shopping.dao.carrier;

import java.util.List;

import com.shopping.domain.carrier.Carrier;
import com.shopping.domain.carrier.query.CarrierQuery;


/**
 * Carrier information DAO interface
 * @author WangYue
 *
 */
public interface CarrierDao {

	/**
	 * add carrier information
	 * @param carrier   carrier value class
	 * @return true:success;false:fail
	 */
	public boolean addCarrier(Carrier carrier);
	
	/**
	 * update carrier information
	 * @param carrier  carrier value class
	 * @return true:success;false:fail
	 */
	public boolean updateCarrier(Carrier carrier);
	
	/**
	 * according to carrier id ,query carrier information.
	 * @param id  carrier id
	 * @return  Carrier  carrier value class
	 */
	public Carrier getCarrierById(Long id);
	
	/**
	 * according to carrier code ,query carrier information.
	 * @param carrierCode  carrier code
	 * @return Carrier  carrier value class
	 */
	public Carrier getCarrierByCarrierCode(String carrierCode);
	
	/**
	 * query all carrier information
	 * @param query  Query carrier value class
	 * @return Carrier  carrier value class
	 */
	public List<Carrier> queryCarrierListByQueryBean(CarrierQuery carrierQuery);
	
	/**
	 * query carrier information with page
	 * @param query Query carrier value class
	 * @return Carrier carrier value class
	 */
	public List<Carrier> queryCarrierListPageByQueryBean(CarrierQuery carrierQuery);
	
	/**
	 * according to carrier id,delete carrier information.
	 * @param id  carrier id
	 * @return true:success;false:fail.
	 */
	public boolean deleteCarrierById(Long id);
	
	/**
	 * get carrier records 
	 * @param query  Query carrier value class 
	 * @return carrier count 
	 */
	public int queryCarrierCountByQueryBean(CarrierQuery carrierQuery);
	
	
}
