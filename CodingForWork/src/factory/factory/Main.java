package factory.factory;

public class Main {
	public static void main(String[] ar) {
		CarFactory factory=new CarFactory();
		CarI bmw=factory.getCar("BMW");
		bmw.drive();
	}
}
