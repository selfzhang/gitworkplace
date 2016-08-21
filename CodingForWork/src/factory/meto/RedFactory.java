package factory.meto;

public class RedFactory implements FactoryI {

	@Override
	public Pen getPen() {
		// TODO Auto-generated method stub
		return new RedPen();
	}

}
