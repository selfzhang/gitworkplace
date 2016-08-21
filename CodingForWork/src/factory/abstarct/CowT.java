package factory.abstarct;

import factory.meto.FactoryI;
import factory.meto.Pen;

public class CowT implements TrousersI {

	private int weight;
	private int high;

	public CowT(int weight, int high) {
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
