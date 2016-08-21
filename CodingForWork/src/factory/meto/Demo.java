package factory.meto;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactoryI factory=new RedFactory();
		factory.getPen().write();
	}

}
