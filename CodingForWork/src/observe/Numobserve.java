package observe;

import java.util.Observable;

public class Numobserve extends Observable {
	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
		setChanged();
		notifyObservers();
	}
	
}
