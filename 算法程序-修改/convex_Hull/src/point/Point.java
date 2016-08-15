package point;

public class Point {
	private double x;

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	private double y;

	private double angle;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Point() {
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
