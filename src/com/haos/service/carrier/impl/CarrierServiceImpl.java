package com.haos.service.carrier.impl;

import java.util.Date;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.haos.common.util.page.ResultCollection;
import com.haos.domain.carrier.Carrier;
import com.haos.domain.carrier.query.CarrierQuery;
import com.haos.manager.carrier.CarrierManager;
import com.haos.service.carrier.CarrierService;

/**
 * Carrier information service interface
 * @author WangYue
 *
 */
public class CarrierServiceImpl implements CarrierService {
	  /**
     * ��־
     */
    private static final Logger log = LogManager.getLogger(CarrierServiceImpl.class);
	private CarrierManager carrierManager;
	@Override
	public ResultCollection addCarrier(Carrier carrier) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = carrierManager.addCarrier(carrier);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("CarrierServiceImpl -> addCarrier() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection updateCarrier(Carrier carrier) {
		 ResultCollection result = new ResultCollection();
		 carrier.setUpdateTime(new Date());
	        try {
	            boolean resultFlag = carrierManager.updateCarrier(carrier);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("CarrierServiceImpl -> updateCarrier() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getCarrierById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            Carrier carrier = carrierManager.getCarrierById(id);
	            result.addDefaultModel("carrier", carrier);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("CarrierServiceImpl -> getCarrierById() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection getCarrierByCarrierCode(String carrierCode) {
		 ResultCollection result = new ResultCollection();
	        try {
	            Carrier carrier = carrierManager.getCarrierByCarrierCode(carrierCode);
	            result.addDefaultModel("carrier", carrier);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("CarrierServiceImpl -> getCarrierByCarrierCode() error!!", e);
	        }
	        return result;
	}

	@Override
	public ResultCollection queryCarrierListByQueryBean(CarrierQuery carrierQuery) {
		ResultCollection result = new ResultCollection();
        try {
            List<Carrier> carrierList = carrierManager.queryCarrierListByQueryBean(carrierQuery);
            result.addDefaultModel("carrierList", carrierList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CarrierServiceImpl -> queryCarrierListByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection queryCarrierListPageByQueryBean(CarrierQuery carrierQuery,
			int pageIndex, int pageSize) {
		ResultCollection result = new ResultCollection();
        try {
            List<Carrier> carrierList = carrierManager.queryCarrierListPageByQueryBean(carrierQuery,pageIndex,pageSize);
            result.addDefaultModel("carrierList", carrierList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CarrierServiceImpl -> queryCarrierListPageByQueryBean() error!!", e);
        }
        return result;
	}

	@Override
	public ResultCollection deleteCarrierById(Long id) {
		 ResultCollection result = new ResultCollection();
	        try {
	            boolean resultFlag = carrierManager.deleteCarrierById(id);
	            result.addDefaultModel("resultFlag", resultFlag);
	            result.setSuccess(true);
	        } catch (Exception e) {
	            log.error("CarrierServiceImpl -> deleteCarrierById() error!!", e);
	        }
	        return result;
	}
	
	
	@Override
	public ResultCollection deleteCarrierByIds(Long ids[]){
		 ResultCollection result = new ResultCollection();
	        try {
	        	if(null!=ids&&ids.length>0){
	        		boolean resultFlag = carrierManager.deleteCarrierByIds(ids);
	        		result.addDefaultModel("resultFlag", resultFlag);
	        		result.setSuccess(true);
	        		
	        	}else{
	        		 log.error("CarrierServiceImpl -> deleteCarrierById() ids param null!!");
	        	}
	        } catch (Exception e) {
	            log.error("CarrierServiceImpl -> deleteCarrierById() error!!", e);
	        }
	    return result;
	}


	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}


}
