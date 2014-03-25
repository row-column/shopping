package com.shopping.web.action.send;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentDeal {
	// 创建一个可缓存的线程池
	ExecutorService pool = Executors.newCachedThreadPool();
	Queue<Map> queue= null;
	DealWithOrderThread thread=null;
	Map map= null;
	public boolean doWork(Map map){
		if(null ==queue) {
			queue=new ConcurrentLinkedQueue<Map>();  
		}
	   
	    if(queue.offer(map)){
	    	thread= new DealWithOrderThread(queue);
	    	pool.execute(thread);
	    	
	    }
	    return false;
	    	
		
	}
	

	class DealWithOrderThread implements Runnable{
		private  Queue<Map> queue;
		
		public DealWithOrderThread(Queue queeu){
			this.queue=queue;
		}
		
		@Override
		public void run() {
			
			synchronized(queue) {    
				if(!queue.isEmpty()) {    
					Map m=(Map)queue.poll(); 
					String msg=(String)m.get("msg");
					Integer id=(Integer)m.get("id");
					System.out.println(msg+"id"+id);
				}    
			}    
		}
		
	}
}

