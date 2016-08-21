package factory.factory;

public class CarFactory {
	public CarI getCar(String name) {
		if (name.equals("BMW")) {
			return new BMW();
		} else {
			return new Bz();
		}
	}
}
