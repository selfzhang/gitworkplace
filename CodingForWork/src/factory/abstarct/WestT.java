package factory.abstarct;

public class WestT implements TrousersI {

	private int weight;
	private int high;

	public WestT(int weight, int high) {
		this.weight = weight;
		this.high = high;

	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public int getHight() {
		// TODO Auto-generated method stub
		return this.high;
	}
}
