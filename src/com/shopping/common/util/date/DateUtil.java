package com.shopping.common.util.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 日期服务工具类
 * @author WY
 *
 */
public class DateUtil 
{
	public static Date toDate(String strDate) throws Exception
	{
		DateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.parse(strDate);
		
	}
	public static Date toDateWithoutHours(String strDate) throws Exception
	{
		DateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		return sf.parse(strDate);
		
	}
	public static String toString(Date date) throws RuntimeException
	{
		DateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}
	public static String toStringWithoutHours(Date date) throws RuntimeException
	{
		DateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}

	public static String getCurrentDate() throws Exception
	{
		DateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(new Date());
	}
	
	public static String getCurrentStringDate() throws Exception
	{ 
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(date);
		
	}
	
	public static String getOrderSerialNumber() throws Exception
	{ 
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(date)+(new Random().nextInt(1000)+1);
		
	}
	
	public static String getSerialNumber() throws Exception
	{ 
		return String.valueOf(System.currentTimeMillis());
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(getSerialNumber());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
