package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callable implements java.util.concurrent.Callable<Integer>{
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ing");
		Thread.sleep(100);
		int result=0;
		for(int i=0;i<100;i++){
			result+=i;
		}
		return result;
	}
	public static void main(String[] aStrings) {
		ExecutorService executorService=Executors.newCachedThreadPool();
		Callable callable=new  Callable();
		Future<Integer> result= executorService.submit(callable);
		executorService.shutdown();
		try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
         
        System.out.println("主线程在执行任务");
         
        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         
        System.out.println("所有任务执行完毕");
		
	}

}
