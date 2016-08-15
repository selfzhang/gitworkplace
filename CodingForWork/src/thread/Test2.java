package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test2 extends Thread{
	public volatile boolean stop=false;
	@Override
	public void run(){
		while (!stop){
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+"hello");
		}
	}
	
	public static void main(String[] arg) {
		
		ScheduledExecutorService  executorService=Executors.newScheduledThreadPool(6);
		
		Test2 test2=new Test2();

		executorService.schedule(test2, 3, TimeUnit.SECONDS);;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		test2.stop=true;
//		test2.interrupt();
//		executorService.shutdown();
		
		
	}

}
