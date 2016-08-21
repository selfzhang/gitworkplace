package factory.abstarct;

public class CowBoy implements UpCloth {
	private int weight;
	private int high;

	public CowBoy(int weight, int high) {
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
