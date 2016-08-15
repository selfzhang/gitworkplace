package common;

import java.util.Vector;

import point.Point;

public class pointTOpoler {

	public void PointToPoler(Vector<Point> point, Point centerPoint) {
		for (int i = 0; i < point.size(); i++) {
			if (point.get(i).getX() == centerPoint.getX()
					&& point.get(i).getY() == centerPoint.getY()) {
				point.get(i).setAngle(0.0);
			} else if (point.get(i).getX() == centerPoint.getX()
					&& point.get(i).getY() > centerPoint.getY()) {
				point.get(i).setAngle(90.0);
			} else if ((point.get(i).getY() == centerPoint.getY())
					&& (point.get(i).getX() > centerPoint.getX())) {
				point.get(i).setAngle(0.0);
			} else if ((point.get(i).getY() == centerPoint.getY())
					&& (point.get(i).getX() < centerPoint.getX())) {
				point.get(i).setAngle(180.0);
			} else {
				if (Math.toDegrees(Math.atan(getTain(point.get(i), centerPoint))) > 0) {
					point.get(i).setAngle(
							Math.toDegrees(Math.atan(getTain(point.get(i),
									centerPoint))));
				}
				if (Math.toDegrees(Math.atan(getTain(point.get(i), centerPoint))) < 0) {
					point.get(i).setAngle(
							Math.toDegrees(180 + Math.atan(getTain(
									point.get(i), centerPoint))));
				}

			}
		}

	}

	public double getTain(Point point, Point centerPoint) {
		double Tain = ((point.getY() - centerPoint.getY()))
				/ ((point.getX() - centerPoint.getX()));
		return Tain;
	}
}
