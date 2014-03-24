package com.haos.service.carrier;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.carrier.Carrier;
import com.haos.domain.carrier.query.CarrierQuery;

/**
 * Carrier information service interface
 * @author WangYue
 *
 */
public interface CarrierService {

	/**
	 * add carrier information
	 * @param carrier   carrier value class
	 * @return Result 
	 */
	public ResultCollection addCarrier(Carrier carrier);
	
	/**
	 * update carrier information
	 * @param carrier  carrier value class
	 * @return Result 
	 */
	public ResultCollection updateCarrier(Carrier carrier);
	
	/**
	 * according to carrier id ,query carrier information.
	 * @param id  carrier id
	 * @return  Result
	 */
	public ResultCollection getCarrierById(Long id);
	
	/**
	 * according to carrier code ,query carrier information.
	 * @param carrierCode  carrier code
	 * @return Result
	 */
	public ResultCollection getCarrierByCarrierCode(String carrierCode);
	
	/**
	 * query carrier information with page
	 * @param query Query carrier value class
	 * @return Result
	 */
	public ResultCollection queryCarrierListByQueryBean(CarrierQuery carrierQuery);
	
	/**
	 * query carrier information with page
	 * @param query Query carrier value class
	 * @return Result
	 */
	public ResultCollection queryCarrierListPageByQueryBean(CarrierQuery carrierQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to carrier id,delete carrier information.
	 * @param id  carrier id
	 * @return Result .
	 */
	public ResultCollection deleteCarrierById(Long id);
	

	/**
	 * according to carrier id,delete carrier information.
	 * @param id  carrier id array
	 * @return Result .
	 */
	public ResultCollection deleteCarrierByIds(Long[] id);
	
}
