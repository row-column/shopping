package com.haos.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 后台登陆拦截器
 * @author WangYue
 * 
 */
public class AdminLoginContextInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	private String enableUrl; // 允许通过的URL地址

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext(); // 取得
																			// ActionContext对象
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST); // 取得request对象
		String url=request.getRequestURL().toString();
		String uri = request.getRequestURI(); // 取得请求的URL地址
		String[] enableUrls = enableUrl.split(",");
        if(!url.contains("/backgroud")){
        	return invocation.invoke();
        }
		if (null != enableUrls && enableUrls.length > 0) {
			for (String eu : enableUrls) {
				if (uri.contains(eu)) {
					return invocation.invoke();
				} else {
					Map<String, Object> map = actionContext.getSession(); // 取得session对象
					String employeeCode = (String) map.get("employeeCode"); // 从session中取得employeeCode

					if (StringUtils.isNotBlank(employeeCode)) {
						return invocation.invoke();
					} else {
						return "backLogin";
					}
				}
			}
		}
		return "backLogin";

	}

	public void setEnableUrl(String enableUrl) {
		this.enableUrl = enableUrl;
	}

}
