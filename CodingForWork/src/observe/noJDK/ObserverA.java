package observe.noJDK;

public class ObserverA implements Observer{

	@Override
	public void action(Observable o) {
		// TODO Auto-generated method stub
		ObservableA a=(ObservableA) o;
		System.out.println("changed "+a.getData());
		
	}

}
