package threadSynchronized;

import java.util.LinkedList;

public class Storage {
	private volatile LinkedList<Object> goods = new LinkedList<Object>();
	private final int MAX_NUM = 100;

	
	public void product(int num,String name) throws InterruptedException {
		synchronized (goods) {
			while (goods.size() + num > MAX_NUM) {
				System.out.println(name +" can not product :" + "there is " + goods.size()+ " goods in storage ,is ready to product " +num);
				goods.wait();

			}

			System.out.println(name +" beginning producting,there is "+ goods.size()+" goods");
			for (int i = 0; i < num; i++) {
				goods.add(new Object());
			}
			goods.notifyAll();
			System.out.println(name+" product "+num+" goods and there is " + goods.size() + " goods in storage ");
		}

	}

	public void consume(int num,String name) throws InterruptedException {
		synchronized (goods) {
			while (goods.size() < num) {
				System.out.println(name +" can not cosume there is " + goods.size()+" goods, "+ name+ " want to consume "+ num);
				goods.wait();
			}
			
			System.out.println(name +" beginning comsume there is "+ goods.size());
			
			for (int i = 0; i < num; i++) {
				goods.remove();
			}
			
			goods.notifyAll();
			System.out.println(name +" comsume "+num+" goods ,"+"there is " + goods.size()  + " goods in storage ");

		}

	}

}
