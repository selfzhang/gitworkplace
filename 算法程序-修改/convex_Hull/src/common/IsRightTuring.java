package common;

import point.Point;

public class IsRightTuring {
	public Boolean isRightTuring(Point point1, Point point2, Point point0) {
//		if ((point1.getX() - point0.getX()) * (point2.getY() - point0.getY())
//				- (point1.getY() - point0.getY())
//				* (point2.getX() - point0.getX()) >= 0) {
//			return 1;
//		} else
//			return 0;
		
		
		double x1 = point2.getX() - point1.getX();
		double y1 = point2.getY() - point1.getY();

		double x2 = point0.getX() -  point2.getX();
		double y2 = point0.getY() -  point2.getY();

		double u = x1*y2 - x2*y1;
		if(u > 0)
			return true;
		else
			return false;

	}

}
