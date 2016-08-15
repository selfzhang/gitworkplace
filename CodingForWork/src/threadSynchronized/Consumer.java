package threadSynchronized;

public class Consumer implements Runnable {

	private Storage storage;
	private int num;
	String name;
	public Consumer(Storage storage, int num,String name) {
		this.storage = storage;
		this.num = num;
		this.name=name;
	}

	public void consume(int num,String name) throws InterruptedException {
		this.storage.consume(num,name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
			
				consume(num,name);
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
