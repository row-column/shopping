package com.shopping.web.action.carrier.json;

import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.carrier.Carrier;
import com.shopping.service.carrier.CarrierService;


/**
 * Carrier JsonAction
 * @author WangYue
 *
 */
public class CarrierJsonAction extends BaseAction {
   // private final static Log logger = LogFactory.getLog(CarrierJsonAction.class);
    
	private static final long serialVersionUID = 1L;

	/**
     * Carrier information service interface
     */
    private CarrierService carrierService;
    
    /**
     * json result
     */
    private String result;
    
    /**
     * result msg
     */
    private String resultMsg;
    
    /**
     * Carrier information value class
     */
    private Carrier carrier;
    
    /**
     * ids array
     */
    private Long[]ids;



    /**
     *  Add carrier method
     *
     * @return
     */
    public String addCarrier() {
        if (null != carrier) {

            ResultCollection serviceResult = carrierService.addCarrier(carrier);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * Update carrier method
     *
     * @return
     */
    public String updateCarrier() {
        if (null != carrier) {

            ResultCollection serviceResult = carrierService.updateCarrier(carrier);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * Delete carrier method
     *
     * @return
     */
    public String deleteCarrier() {
        if (null != carrier.getId() && carrier.getId().intValue() > 0) {
            ResultCollection serviceResult = carrierService.deleteCarrierById(carrier.getId());
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }
    
    /**
     * Delete carriers method
     *
     * @return
     */
    public String deleteCarriers() {
        if(ids!=null&&ids.length>1){
            ResultCollection serviceResult = carrierService.deleteCarrierByIds(ids);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        }else {
            result = "false";
        }
        return "out";
    }
    
    
    /**
     * Check carrier code method
     *
     * @return
     */
    public String checkCarrierCode() {
        if (null != carrier) {

            ResultCollection serviceResult = carrierService.getCarrierByCarrierCode(carrier.getCarrierCode());
            
            if (null != serviceResult && serviceResult.getSuccess()) {
            	Carrier carrier=(Carrier)serviceResult.get("carrier");
            	if(carrier!=null&&carrier.getCarrierCode()!=null){
            		result = "exist";
            	}else{
            		result = "ok";
            	}
            } else {
            	result = "ok";
            }
        } 
        return "out";
    }

    public void setCarrierService(CarrierService carrierService) {
        this.carrierService = carrierService;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public CarrierService getCarrierService() {
		return carrierService;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
    
  
}
