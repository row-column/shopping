package com.shopping.common.util.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.shopping.common.util.page.ResultCollection;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * User: Administrator
 * Date: 2010-4-27
 * Time: 11:42:43
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    protected HttpServletResponse response;
    protected HttpServletRequest request;

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }



    public static final int PAGE_SIZE = 20;


    protected int page=1;

    public void setPage(int page) {
        if (page <= 0) {
            page = 1;
        }
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    protected void setValueStack(ResultCollection result) {
        ValueStack context = ActionContext.getContext().getValueStack();
        context.set("textProvider", this);
        context.set("datePickerLocale", getDatePickerLocale());
        if(null != result){
            context.set("result", result);
            Set<String> set = result.keySet();
            for (String key : set) {
                context.set(key, result.get(key));
            }
            String resultCode = result.getResultCode();
            if (StringUtils.isNotBlank(resultCode)) {
                String text;
                String[] params = result.getResultCodeParams();
                if (params != null && params.length > 0) {
                    text = getText(resultCode, params);
                } else {
                    text = getText(resultCode);
                }
                if (result.getSuccess()) {
                    addActionMessage(text);
                } else {
                    addActionError(text);
                }
            }
        }
    }

    /**
     * Get locale time
     * @return
     */
    private String getDatePickerLocale() {
        String locale = getLocale().toString().toLowerCase();
        String[] arr = locale.split("_");
        if (arr[0].equals("en")) {
            locale = arr[0];
        } else {
            locale = arr[0] + "-" + arr[1];
        }
        return locale;
    }



}
