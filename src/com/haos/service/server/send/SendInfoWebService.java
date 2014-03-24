package com.haos.service.server.send;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.haos.domain.send.Send;


/**
 * 配送信息WebService接口
 * @author WangYue
 */
@WebService(targetNamespace = "http://www.haos.com")
public interface SendInfoWebService {

	/**
	 * 更新配送信息方法
	 * @param orderCode		//订单号码
	 * @param dealTime		//处理时间
	 * @param dealInformation		//处理信息
	 * @param remark		//备注
	 * @return true/false
	 */
	public boolean updateSendInfo(@WebParam(name = "sendCode") String sendCode,@WebParam(name = "orderCode") String orderCode,
			@WebParam(name = "dealInformation") String dealInformation,
			@WebParam(name = "remark") String remark,
			@WebParam(name = "operator") String operator); 
	
	/**
	 * 取得员工所负责的所有配送信息
	 * @param employeeCode		//员工账号
	 * @return 配送信息
	 */
	public List<Send> querySendInfoList(@WebParam(name = "employeeCode") String employeeCode);
	
	/**
	 * 根据配送编号 ，取得配送信息
	 * @param id 配送信息ID
	 * @return 配送信息
	 */
	public Send getSendInfoById(@WebParam(name = "id")Long id);
	
	/**
	 * 根据配送单号和订单号，取得所有配送信息
	 * @param sendCode  配送单号
	 * @param orderCode 订单号
	 * @return 配送信息集合
	 */
	public List<Send> querySendInfoListBySendCodeAndOrderCode(@WebParam(name = "sendCode")String sendCode,@WebParam(name = "orderCode")String orderCode);

}
