package common;

public class Point {

	private double x;

	private double y;

	private int ID;
	
	private int clusternum;

	private boolean isKey;

	private boolean isClassed;

	public boolean isKey() {

		return isKey;

	}

	public void setKey(boolean isKey) {

		this.isKey = isKey;

		this.isClassed = true;

	}

	public boolean isClassed() {

		return isClassed;

	}

	public void setClassed(boolean isClassed) {

		this.isClassed = isClassed;

	}

	public double getX() {

		return x;

	}

	public void setX(double x) {

		this.x = x;

	}

	public double getY() {

		return y;

	}

	public void setY(double y) {

		this.y = y;

	}

	public Point() {

		x = 0;

		y = 0;

	}

	public Point(double x, double y) {

		this.x = x;

		this.y = y;

	}
	
	public Point(int ID,double x,double y) {
		
		this.ID = ID;
		this.x = x;
		this.y = y;
		
	}
	public Point(double x, double y,int clusternum)
	{
		this.x = x;
		this.y = y;
		this.clusternum = clusternum;
	}
	
	public Point(String str) {

		String[] p = str.split(" ");

		this.x = Double.parseDouble(p[0]);

		this.y = Double.parseDouble(p[1]);
//		System.out.println(this.x+","+this.y);
	}

	public String print() {

		return "<" + this.x + "," + this.y + "," + this.clusternum + ">";

	}
	
	public String Kmeansprint() {

		return "<" +this.ID+", "+ this.x + "," + this.y + ", " + this.clusternum + ">";

	}

	public int getClusternum() {
		return clusternum;
	}

	public void setClusternum(int clusternum) {
		this.clusternum = clusternum;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
