package com.shopping.web.action.send.json;

public class Test {
	public static void main(String args[]){
		String msg="abc;abd;";
		/*if(msg.contains("不正确")){
			System.out.println("true");
		}else {
			System.out.println("false");
		}*/
		
		System.out.println(msg);
		msg=msg.replace("abc"+";","");
		System.out.println(msg);
	}

}
