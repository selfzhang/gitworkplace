package observe.noJDK;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
	public List<Observer> list = new ArrayList<Observer>();

	public void addObserver(Observer o) {
		this.list.add(o);
	}

	public void notifyall() {
		for (Observer o : list)
			o.action(this);
	}
}
