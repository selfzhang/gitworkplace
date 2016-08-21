package factory.abstarct;

public class ShangHai implements FactoryI {

	@Override
	public UpCloth getUpcloth() {
		// TODO Auto-generated method stub
		return new West(100, 200);
	}

	@Override
	public TrousersI getTrousers() {
		// TODO Auto-generated method stub
		return new WestT(300, 100);
	}

}
