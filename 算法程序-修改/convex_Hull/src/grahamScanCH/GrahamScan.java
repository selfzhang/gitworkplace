package grahamScanCH;

import java.util.Vector;
import java.lang.Math;

import common.IsRightTuring;
import common.SelectMiddle;
import common.pointTOpoler;
import common.polarQuickSort;
import common.quickSort;

import point.Point;

public class GrahamScan {
	private Vector<Point> GSpoint = new Vector<Point>();

	public Vector<Point> getGSpoint() {
		return GSpoint;
	}

	private Point YminPoint = new Point();

	public GrahamScan(Vector<Point> vecPoint) {
	    long time = 0;
		long startTime=System.currentTimeMillis(); 
		grahamScan(vecPoint);
		long endTime=System.currentTimeMillis(); 
		time = endTime-startTime;
		System.out.println("…®√Ë ±º‰"+time+"ms");
		
		// for (int i = 0; i < GSpoint.size(); i++) {
		// printPoint(GSpoint.get(i));
		// }
		// printPoint(GSpoint.get(0));

	}

	public GrahamScan() {

	}

	public Point getMinY(Vector<Point> point) {

		Point YminPoint = new Point();
		YminPoint = point.get(0);
		for (int i = 1; i < point.size(); i++) {
			if (point.get(i).getY() < YminPoint.getY()) {
				YminPoint = point.get(i);
			} else if (point.get(i).getY() == YminPoint.getY()
					&& point.get(i).getX() == YminPoint.getX()) {
				YminPoint = point.get(i);
			}
		}
		return YminPoint;
	}

	public void printPoint(Point point) {
		System.out.print("[" + point.getX() + "," + point.getY() + ","
				+ point.getAngle() + "]");
	}

	// public void printPoint(Point point) {
	// System.out.print("[" + point.getX() + "," + point.getY() + "]");
	// }

	public void grahamScan(Vector<Point> point) {

		YminPoint = getMinY(point);
		new pointTOpoler().PointToPoler(point, YminPoint);
		new polarQuickSort().quick(point);
		// for (int i = 0; i < point.size(); i++) {
		// printPoint(point.get(i));
		// }
		if (point.size() >= 3) {
			int top = 0;
			IsRightTuring isrighttruing = new IsRightTuring();

			GSpoint.add(top, point.get(top++));
			GSpoint.add(top, point.get(top++));
			GSpoint.add(top, point.get(top++));
			// System.out.println(top);
			top = 2;
			for (int i = 3; i < point.size(); i++) {
				while ((isrighttruing.isRightTuring(GSpoint.get(top),
						GSpoint.get(top - 1), point.get(i)))) {
					// System.out.println(top);

					GSpoint.remove(top);
					top--;
					if (top == 0) {
						break;
					}

				}
				top++;
				// GSpoint.insertElementAt(point.get(i), top);
				GSpoint.add(top, point.get(i));

			}

		} else {
			for (int i = 0; i < point.size(); i++) {
				GSpoint.add(point.get(i));
			}
		}
	}
}
