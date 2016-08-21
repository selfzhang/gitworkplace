package factory.abstarct;

public class West implements UpCloth {
	private int weight;
	private int high;

	public West(int weight, int high) {
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
