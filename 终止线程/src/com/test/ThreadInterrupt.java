package com.test;

/**
 * 
 * @author lzl
 * 线程并不能直接立刻终止，只能是当前run()方法体执行完后才自动结束
 */

public class ThreadInterrupt extends Thread 
{ 
	   public void run() 
	    { 
		   
	        try 
	        { 
	        	
	            sleep(1000);  // 延迟50秒 
	        } 
	        catch (InterruptedException e) 
	        { 
	            System.out.println(e.getMessage()); 
	            System.out.println("线程已经退出!"); 
	        } 
	        
	    	while(true){
	    		 try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				System.out.println("线程执行!");
			}
	    } 
	    public static void main(String[] args) throws Exception 
	    { 
	        Thread thread = new ThreadInterrupt(); 
	        thread.start(); 
	        thread.interrupt(); 
//	        System.out.println("线程已经退出!"); 
//	        throw new Exception();
	       
	       
	    } 
} 