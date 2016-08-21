package celue;

public class Celue {
	private CookFish cookFish;

	public Celue(CookFish cookFish) {
		this.cookFish = cookFish;
	}

	public void action() {
		this.cookFish.cookFish();
	}
}
