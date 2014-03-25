package com.shopping.common.util.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

/**
 * struts日期转换类
 * @author WangYue
 *
 */
public class DateConverter extends StrutsTypeConverter {
	private static final Logger log = Logger.getLogger(DateConverter.class);
	private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_PATTERN = "yyyy-MM-dd";
	private static final String MONTH_PATTERN = "yyyy-MM";
	
	

	@Override
	public String convertToString(Map arg0, Object arg1) {
		String result = null;
		if (arg1 != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_PATTERN);
			if (arg1 instanceof Date) {
				result = simpleDateFormat.format(arg1);
			}
			return result;
		}
		return result;
	}
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class toType) {
		if(toType==Date.class){
		
			Date result = null;
			if (arg1 != null && arg1.length > 0 && StringUtils.isNotBlank(arg1[0])) {
				try {
					result = DateUtils.parseDate(arg1[0], new String[] { DATE_PATTERN, DATETIME_PATTERN, MONTH_PATTERN });
				}
				catch (ParseException e) {
					log.error("com.jd.bk.common.struts.action.DateConverter!convertFromString error", e);
				}
			}
			return result;
		}
		return null;
	}
	
	
}