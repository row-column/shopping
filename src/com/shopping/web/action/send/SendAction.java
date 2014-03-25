package com.shopping.web.action.send;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.carrier.query.CarrierQuery;
import com.shopping.domain.send.Send;
import com.shopping.domain.send.query.SendQuery;
import com.shopping.domain.send.query.SendTypeQuery;
import com.shopping.service.carrier.CarrierService;
import com.shopping.service.send.SendService;
import com.shopping.service.send.SendTypeService;

/**
 * Send information action
 * 
 * @author WangYue
 * 
 */
public class SendAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(SendAction.class);

	/**
	 * Send information Service
	 */
	private SendService sendService;
	/**
	 * Send information query value class
	 */
	private SendQuery sendQuery;

	/**
	 * Send information
	 */
	private Send send;

	/**
	 * Page size
	 */
	private int pageSize = CommonConstant.PAGESIZE;
	/**
	 * Carrier information Service
	 */

	private CarrierService carrierService;

	/**
	 * Send type information Service
	 */
	private SendTypeService sendTypeService;

	/**
	 * To Send information list page
	 * 
	 * @return
	 */
	public String sendMain() {
		if (null == sendQuery) {
			sendQuery = new SendQuery();
		}
		sendQuery.setYn(CommonConstant.YN_NO_DELETE); // not delete
		ResultCollection result = sendService.querySendListPageByQueryBean(
				sendQuery, page, pageSize);
		setValueStack(result);
		return "sendMain";
	}

	/**
	 * 
	 * To add Send information page
	 * 
	 * @return
	 */
	public String toAddSend() {

		SendTypeQuery sendTypeQuery = new SendTypeQuery(); // new carrierQuery
															// object
		sendTypeQuery.setYn(CommonConstant.YN_NO_DELETE);
		ResultCollection sendTypeResult = sendTypeService
				.querySendTypeListByQueryBean(sendTypeQuery); // call
																// querySendTypeListByQueryBean()method

		CarrierQuery carrierQuery = new CarrierQuery(); // new carrierQuery
														// object
		carrierQuery.setYn(CommonConstant.YN_NO_DELETE);
		ResultCollection carrierResult = carrierService
				.queryCarrierListByQueryBean(carrierQuery); // call
															// queryCarrierListByQueryBean()method
		this.setValueStack(sendTypeResult);
		this.setValueStack(carrierResult);
		return "toAddSend";
	}

	/**
	 * 
	 * To update Send information page
	 * 
	 * @return
	 */
	public String toUpdateSend() {

		SendTypeQuery sendTypeQuery = new SendTypeQuery(); // new carrierQuery
															// object
		sendTypeQuery.setYn(CommonConstant.YN_NO_DELETE);
		ResultCollection sendTypeResult = sendTypeService
				.querySendTypeListByQueryBean(sendTypeQuery); // call
																// querySendTypeListByQueryBean()method

		CarrierQuery carrierQuery = new CarrierQuery(); // new carrierQuery
														// object
		carrierQuery.setYn(CommonConstant.YN_NO_DELETE);
		ResultCollection carrierResult = carrierService
				.queryCarrierListByQueryBean(carrierQuery); // call
															// queryCarrierListByQueryBean()method
		this.setValueStack(sendTypeResult);
		this.setValueStack(carrierResult);

		if (null != send) {
			// get Send information by id
			ResultCollection result = sendService.getSendById(send.getId());
			setValueStack(result);
		} else {
			log.error("SendAction!toUpdateSend() error!");
		}
		return "toUpdateSend";
	}

	/**
	 * 
	 * To update Send information page
	 * 
	 * @return
	 */
	public String toViewSend() {

		SendTypeQuery sendTypeQuery = new SendTypeQuery(); // new carrierQuery
															// object
		sendTypeQuery.setYn(CommonConstant.YN_NO_DELETE);
		ResultCollection sendTypeResult = sendTypeService
				.querySendTypeListByQueryBean(sendTypeQuery); // call
																// querySendTypeListByQueryBean()method

		CarrierQuery carrierQuery = new CarrierQuery(); // new carrierQuery
														// object
		carrierQuery.setYn(CommonConstant.YN_NO_DELETE);
		ResultCollection carrierResult = carrierService
				.queryCarrierListByQueryBean(carrierQuery); // call
															// queryCarrierListByQueryBean()method
		this.setValueStack(sendTypeResult);
		this.setValueStack(carrierResult);

		if (null != send) {
			// get Send information by id
			ResultCollection result = sendService.getSendById(send.getId());
			if (null != result && result.getSuccess()) {
				send = (Send) result.get("send");
				SendQuery sendQuery = new SendQuery();
				sendQuery.setSendCode(send.getSendCode());
				sendQuery.setOrderCode(send.getOrderCode());
				sendQuery.setTypeCode(send.getTypeCode());
				sendQuery.setCarrierCode(send.getCarrierCode());
				this.setValueStack(sendService
						.querySendListByQueryBean(sendQuery));
			}
			setValueStack(result);
		} else {
			log.error("SendAction!toViewSend() error!");
		}
		return "toViewSend";
	}

	/**
	 * 
	 * To update Send information page
	 * 
	 * @return
	 */
	public String toDeleteSend() {

		SendTypeQuery sendTypeQuery = new SendTypeQuery(); // new carrierQuery
															// object
		sendTypeQuery.setYn(CommonConstant.YN_NO_DELETE);
		ResultCollection sendTypeResult = sendTypeService
				.querySendTypeListByQueryBean(sendTypeQuery); // call
																// querySendTypeListByQueryBean()method

		CarrierQuery carrierQuery = new CarrierQuery(); // new carrierQuery
														// object
		carrierQuery.setYn(CommonConstant.YN_NO_DELETE);
		ResultCollection carrierResult = carrierService
				.queryCarrierListByQueryBean(carrierQuery); // call
															// queryCarrierListByQueryBean()method
		this.setValueStack(sendTypeResult);
		this.setValueStack(carrierResult);

		if (null != send) {
			// get Send information by id
			ResultCollection result = sendService.getSendById(send.getId());
			if (null != result && result.getSuccess()) {
				send = (Send) result.get("send");
				SendQuery sendQuery = new SendQuery();
				sendQuery.setSendCode(send.getSendCode());
				sendQuery.setOrderCode(send.getOrderCode());
				sendQuery.setTypeCode(send.getTypeCode());
				sendQuery.setCarrierCode(send.getCarrierCode());
				this.setValueStack(sendService
						.querySendListByQueryBean(sendQuery));
			}
			setValueStack(result);
		} else {
			log.error("SendAction!toDeleteSend() error!");
		}
		return "toDeleteSend";
	}

	public Send getSend() {
		return send;
	}

	public void setSend(Send send) {
		this.send = send;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setSendService(SendService sendService) {
		this.sendService = sendService;
	}

	public void setSendQuery(SendQuery sendQuery) {
		this.sendQuery = sendQuery;
	}

	public void setCarrierService(CarrierService carrierService) {
		this.carrierService = carrierService;
	}

	public void setSendTypeService(SendTypeService sendTypeService) {
		this.sendTypeService = sendTypeService;
	}

}
