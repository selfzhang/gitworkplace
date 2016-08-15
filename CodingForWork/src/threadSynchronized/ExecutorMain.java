package threadSynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {
	public static void main(String[] arg) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Storage storage = new Storage();

		for (int i = 1; i < 10; i++) {
			Thread thread =null;
			if (i % 3 != 0) {
				String name="Producer " + i;
				thread = new Thread(new Producer(storage, i * 5 ,name));
			} else {
				String name="Consumer " + i;
				thread = new Thread(new Consumer(storage, i * 6,name));
			}

			executorService.execute(thread);
		}
		executorService.shutdown();
	}
}
