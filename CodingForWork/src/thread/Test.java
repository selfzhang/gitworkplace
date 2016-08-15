package thread;

public class Test implements Runnable{
	
	public static int count =0;
	
	public static synchronized void method() {

		count++;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			
		
		method();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread[] thread=new Thread[100];
		for (int i = 0; i < 100; i++) {
			Test test=new Test();
			thread[i]=new Thread(test);
        }
		for(int i=0;i<100;i++){
			thread[i].start();
		}
		for(int i=0;i<100;i++){
			thread[i].join();
		}
		System.out.println("运行结果:Counter.count=" + Test.count);
	}

	

}
