package com.shopping.web.action.send;

import java.util.HashMap;
import java.util.Map;

public class TestConcurent {
	
     public static void main(String[] args) {
    	 ConcurrentDeal conn=new ConcurrentDeal();
    	 Map map=null;
    	 for(int i=0;i<100;i++){
    		 map=new HashMap();
    		 map.put("msg", "queue"+i);
    		 map.put("id", i);
    		 conn.doWork(map);
 		}
	}

}
