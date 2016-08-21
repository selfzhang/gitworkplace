package observe;

import java.util.Observable;

public class NumObserver implements java.util.Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Numobserve result=(Numobserve) o;
		System.out.println("Changed"+result.getData());
	}

}
