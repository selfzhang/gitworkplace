package factory.meto;

public class BuleFactory implements FactoryI {

	@Override
	public Pen getPen() {
		// TODO Auto-generated method stub
		return new BluePen();
	}

}
