package pattern;

public abstract class Template {
	public void oprationAfter() {
		System.out.println("oprationAfter");
	}

	public void oprationBefore() {
		System.out.println("oprationBefore");
	}

	public abstract void opration();

	public void logic() {
		oprationBefore();
		opration();
		oprationAfter();
	}
}
