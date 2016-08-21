package observe;

import observe.noJDK.ObservableA;
import observe.noJDK.ObserverA;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObservableA numobserve=new ObservableA();
		numobserve.addObserver(new ObserverA());
		numobserve.setData(2);
		numobserve.setData(3);
		numobserve.setData(4);

	}

}
