package observe.noJDK;

public class ObservableA extends Observable {
	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;

		notifyall();
	}
}
