package threadSynchronized;

public class Producer implements Runnable{
	private Storage storage;
	private int num;
	String name;
	public Producer(Storage storage,int num,String name) {
		this.storage=storage;
		this.num=num;
		this.name=name;
	}
	public void product(int num,String name) throws InterruptedException{
		this.storage.product(num,name);
	}
	@Override
	public void run() {
		while(true){
			try {
				product(num,name);
				Thread.sleep(30);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
