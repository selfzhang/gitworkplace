package bruteForceCH;

import java.util.Vector;

import common.quickSort;

import point.Point;
import bruteForceCH.bruteForceCH;

public class bruteForceCH {
	private Vector<Point> vecPoint = new Vector<Point>();
	private Vector<Point> pointCH = new Vector<Point>();

	public Vector<Point> getPointCH() {
		return pointCH;
	}

	private Point XmaxPoint = new Point();
	private Point XminPoint = new Point();
	private quickSort sort = new quickSort();

	public bruteForceCH(Vector<Point> Point) {
		long time = 0;
		long startTime = System.currentTimeMillis();
		vecPoint = Point;
		XmaxPoint = getMaxX(vecPoint);
		XminPoint = getMinX(vecPoint);
		// System.out.println("所有点如下");
		// for (int i = 0; i < vecPoint.size(); i++) {
		// printPoint(vecPoint.get(i));
		// }
		// System.out.println();

		Vector<Point> vecPoint2 = new Vector<Point>();
		Vector<Point> vecUpPoint = new Vector<Point>();
		Vector<Point> vecDownPoint = new Vector<Point>();

		vecPoint2 = BruteForceCH(vecPoint);

		vecUpPoint = getUP(vecPoint2);
		sort.quick(vecUpPoint);

		vecDownPoint = getDown(vecPoint2);
		sort.quick(vecDownPoint);

		// System.out.println();
		// for (int i = 0; i < vecPoint2.size(); i++) {
		// System.out.print("[" + vecPoint2.get(i).getX() + ","
		// + vecPoint2.get(i).getY() + "]");
		// }
		// System.out.println();
		// System.out.println("======================");
		// for (int i = 0; i < vecUpPoint.size(); i++) {
		//
		// printPoint(vecUpPoint.get(i));
		//
		// }
		// System.out.println();
		// System.out.println("======================");
		// for (int i = 0; i < vecDownPoint.size(); i++) {
		//
		// printPoint(vecDownPoint.get(i));
		//
		// }
		// System.out.println();
		// //
		// System.out.println("============================================================================");
		// System.out.println();
		// System.out.println("凸包");
		pointCH.add(XminPoint);
		for (int i = 0; i < vecDownPoint.size(); i++) {
			pointCH.add(vecDownPoint.get(i));
		}
		pointCH.add(XmaxPoint);
		for (int i = vecUpPoint.size() - 1; i > -1; i--) {
			pointCH.add(vecUpPoint.get(i));
		}
		// for (int i = 0; i < pointCH.size(); i++) {
		//
		// printPoint(pointCH.get(i));
		//
		// }

		long endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("蛮力法时间" + time + "ms");

	}

	public Point getMinX(Vector<Point> point) {
		Point XminPoint = new Point();
		XminPoint = point.get(0);
		for (int i = 1; i < point.size(); i++) {
			if (point.get(i).getX() < XminPoint.getX()) {
				XminPoint = point.get(i);
			}
		}
		return XminPoint;
	}

	public Point getMaxX(Vector<Point> point) {
		Point XmaxPoint = new Point();
		XmaxPoint = point.get(0);
		for (int i = 1; i < point.size(); i++) {
			if (point.get(i).getX() > XmaxPoint.getX()) {
				XmaxPoint = point.get(i);
			}
		}
		return XmaxPoint;
	}

	public Vector<Point> BruteForceCH(Vector<Point> point) {
		Point point1 = new Point();
		Point point2 = new Point();
		Point point3 = new Point();
		Point point4 = new Point();
		int p1, p2, p3, p4;
		for (p1 = 0; p1 < point.size(); p1++) {
			point1 = point.get(p1);
			for (p2 = 0; p2 < point.size(); p2++) {
				if (p2 == p1) {
					continue;
				} else {
					point2 = point.get(p2);
					for (p3 = 0; p3 < point.size(); p3++) {
						if (p3 == p2 || p3 == p1) {
							continue;
						} else {
							point3 = point.get(p3);
							for (p4 = 0; p4 < point.size(); p4++) {
								if (p4 == p3 || p4 == p2 || p4 == p1) {
									continue;
								} else {
									point4 = point.get(p4);
									Triangleinterior(point1, point2, point3,
											point4, p4);
								}
							}
						}

					}
				}
			}
		}
		return point;
	}

	public void Triangleinterior(Point point1, Point point2, Point point3,
			Point point4, int index) {
		double temp = ((point2.getY() - point1.getY())
				* (point3.getX() - point1.getX()) - (point2.getX() - point1
				.getX()) * (point3.getY() - point1.getY()));
		double u = ((point3.getX() - point1.getX())
				* (point4.getY() - point1.getY()) - (point3.getY() - point1
				.getY()) * (point4.getX() - point1.getX()))
				/ temp;

		double v = ((point2.getY() - point1.getY())
				* (point4.getX() - point1.getX()) - (point2.getX() - point1
				.getX()) * (point4.getY() - point1.getY()))
				/ temp;
		if (u > 0 && v > 0 && u + v < 1) {
			vecPoint.remove(index);
		}

	}

	public int whichSide(Point point1, Point point2, Point point3) {
		double k = 0;
		double b = 0;

		if (((double) point2.getX() - (double) point1.getX()) != 0) {
			k = (double) (((double) point2.getY() - (double) point1.getY()) / ((double) point2
					.getX() - (double) point1.getX()));
			b = (double) ((point1.getY() * (point2.getX() - point1.getX()) - point1
					.getX() * (point2.getY() - point1.getY())) / (point2.getX() - point1
					.getX()));

			// System.out.print(b + " ");
			// System.out.print(k);
			// System.out.println();
			if ((point3.getY() - (k * point3.getX() + b)) > 0) {
				// System.out.print(point1);
				// System.out.print(point2);
				// System.out.print(point3);
				// System.out.println(1);
				return 1;
			} else if ((point3.getY() - (k * point3.getX() + b)) == 0) {
				// System.out.print(point1);
				// System.out.print(point2);
				// System.out.print(point3);
				// System.out.println(0);
				return 0;
			} else {
				// System.out.print(point1);
				// System.out.print(point2);
				// System.out.print(point3);
				// System.out.println(-1);
				return -1;
			}

		} else {
			if (point3.getX() > point1.getX()) {
				return 1;
			} else if (point3.getX() < point1.getX()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public void printPoint(Point point) {
		System.out.print("[" + point.getX() + "," + point.getY() + "]");
	}

	public Vector<Point> getUP(Vector<Point> point) {
		Vector<Point> upPoint = new Vector<Point>();
		for (int i = 0; i < point.size(); i++) {
			if (whichSide(XminPoint, XmaxPoint, point.get(i)) == 1) {
				upPoint.add(point.get(i));
			}
		}

		return upPoint;

	}

	public Vector<Point> getDown(Vector<Point> point) {
		Vector<Point> downPoint = new Vector<Point>();
		for (int i = 0; i < point.size(); i++) {
			if (whichSide(XminPoint, XmaxPoint, point.get(i)) == -1) {
				downPoint.add(point.get(i));
			}
		}
		return downPoint;

	}

}
