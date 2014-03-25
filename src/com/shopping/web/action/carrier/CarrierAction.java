package com.shopping.web.action.carrier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.carrier.Carrier;
import com.shopping.domain.carrier.query.CarrierQuery;
import com.shopping.service.carrier.CarrierService;


/**
 * Carrier information  action
 * @author WangYue
 *
 */
public class CarrierAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(CarrierAction.class);
    
    /**
     * Carrier information Service
     */
    private CarrierService carrierService;
    /**
     * Carrier information query value class
     */
    private CarrierQuery carrierQuery;
    
    /**
     * Carrier information
     */
    private Carrier carrier;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;

    /**
     * To carrier information list page
     *
     * @return
     */
    public String carrierMain() {
       if (null == carrierQuery) {
    			carrierQuery = new CarrierQuery();
    	}
    	carrierQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
    	ResultCollection result = carrierService.queryCarrierListPageByQueryBean(carrierQuery, page, pageSize);
    	setValueStack(result);
    		
        return "carrierMain";
    }

    /**
     * 
     * To add carrier information page
     * @return
     */
    public String toAddCarrier() {
        this.setValueStack(null);
        return "toAddCarrier";
    }

    /**
     * 
     * To update carrier information page
     * @return
     */
    public String toUpdateCarrier() {
    	
        if (null != carrier) {
            // get carrier information by id
            ResultCollection result = carrierService.getCarrierById(carrier.getId());
            setValueStack(result);
        } else {
            log.error("CarrierAction!toUpdateCarrier() error!");
        }
        return "toUpdateCarrier";
    }
    
    /**
     * 
     * To delete carrier information page
     * @return
     */
    public String toDeleteCarrier() {
    	
        if (null != carrier) {
            // get carrier information by id
            ResultCollection result = carrierService.getCarrierById(carrier.getId());
            setValueStack(result);
        } else {
            log.error("CarrierAction!toUpdateCarrier() error!");
        }
        return "toDeleteCarrier";
    }

	public CarrierService getCarrierService() {
		return carrierService;
	}

	public void setCarrierService(CarrierService carrierService) {
		this.carrierService = carrierService;
	}

	public CarrierQuery getCarrierQuery() {
		return carrierQuery;
	}

	public void setCarrierQuery(CarrierQuery carrierQuery) {
		this.carrierQuery = carrierQuery;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

    
  
}
