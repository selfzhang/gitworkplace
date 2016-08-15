package threadLock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
	private volatile LinkedList<Object> goods = new LinkedList<Object>();
	private final int MAX_NUM = 100;
	private final Lock myLock = new ReentrantLock();
	private final Condition full = myLock.newCondition();
	private final Condition empty = myLock.newCondition();

	public void product(int num, String name) {
		myLock.lock();

		try {
			while (goods.size() + num > MAX_NUM) {
				System.out.println(name + " can not product :" + "there is " + goods.size()
						+ " goods in storage ,is ready to product " + num);
				// goods.wait();

				full.await();

			}

			System.out.println(name + " beginning producting,there is " + goods.size() + " goods");
			for (int i = 0; i < num; i++) {
				goods.add(new Object());
			}
			
			empty.signal();
			
			System.out.println(name + " product " + num + " goods and there is " + goods.size() + " goods in storage ");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			myLock.unlock();
		}
	}

	public void consume(int num, String name)  {
		myLock.lock();
		try{
		while (goods.size() < num) {
			System.out.println(
					name + " can not cosume there is " + goods.size() + " goods, " + name + " want to consume " + num);
			empty.await();
			}

		System.out.println(name + " beginning comsume there is " + goods.size());

		for (int i = 0; i < num; i++) {
			goods.remove();
		}

		// goods.notifyAll();
		full.signal();
		System.out.println(name + " comsume " + num + " goods ," + "there is " + goods.size() + " goods in storage ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			myLock.unlock();
		}
	}

}
