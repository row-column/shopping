package com.shopping.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginContextInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	private String enableUrl; // 允许通过的URL地址

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext(); // 取得
																			// ActionContext对象
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST); // 取得request对象
		String uri = request.getRequestURI(); // 取得请求的Url地址
		String[] enableUrls = enableUrl.split(",");
		boolean isFind = false;

		if (null != enableUrls && enableUrls.length > 0) {
			for (String eu : enableUrls) {
				if (uri.contains(eu)) {
					isFind = true;
					break;
				} else {
					isFind = false;
				}
			}
		}
		if (isFind) {
			return invocation.invoke();
		} else {
			Map<String, Object> map = actionContext.getSession(); // 取得session对象
			String loginEmployeeCode = (String) map.get("loginEmployeeCode"); // 从session中取得loginEmployeeCode

			if (!StringUtils.isBlank(loginEmployeeCode)) {
				return invocation.invoke();
			} else {
				return "toLogin";
			}
		}

	}

	public void setEnableUrl(String enableUrl) {
		this.enableUrl = enableUrl;
	}
}
