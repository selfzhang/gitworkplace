package dc_grahamScanCH;

import grahamScanCH.GrahamScan;

import java.util.Vector;

import point.Point;

import common.SelectMiddle;
import common.quickSort;

public class DCgrahamScanCH {

	private Vector<Point> leftPoint = new Vector<Point>();
	private Vector<Point> rightPoint = new Vector<Point>();

	private Vector<Point> mergePoint = new Vector<Point>();

	public Vector<Point> getMergePoint() {
		return mergePoint;
	}

	SelectMiddle select = new SelectMiddle();
	public long time = 0;
	public DCgrahamScanCH(Vector<Point> vecPoint) {

		long startTime=System.currentTimeMillis(); 
		mergePoint = divideCHpoint(vecPoint);
		long endTime=System.currentTimeMillis(); 
		time = endTime-startTime;
		System.out.println("分治时间"+time+"ms");
		
	
		// System.out.println();
		// System.out.println();
		// System.out.println("=========================================dccccc");
		//
		// for (int i = 0; i < mergePoint.size(); i++) {
		// printPoint(mergePoint.get(i));
		// }
	}

	public Vector<Point> divideCHpoint(Vector<Point> vpoint) {
		if (vpoint.size() < 4) {
			return vpoint;
		} else {
			double middle = select.select_middle(vpoint, 0, vpoint.size() - 1,
					vpoint.size());
			Vector<Point> left = new Vector<Point>();
			Vector<Point> right = new Vector<Point>();

			for (int i = 0; i < vpoint.size(); i++) {
				if (vpoint.get(i).getX() < middle) {
					left.add(vpoint.get(i));
				} else {
					right.add(vpoint.get(i));
				}

			}

			left = divideCHpoint(left);
			right = divideCHpoint(right);

			// new GrahamScan().grahamScan(left);
			// new GrahamScan().grahamScan(right);

			GrahamScan GSL = new GrahamScan(left);
			left = GSL.getGSpoint();

			GrahamScan GSR = new GrahamScan(right);
			right = GSR.getGSpoint();

//			System.out.println(left.size() + "+" + right.size());
			Vector<Point> mergePoint = new Vector<Point>();

			for (int i = 0; i < left.size(); i++) {
				mergePoint.add(left.get(i));
			}
			for (int i = 0; i < right.size(); i++) {
				mergePoint.add(right.get(i));
			}

			// new GrahamScan().grahamScan(mergePoint);
			GrahamScan GS = new GrahamScan(mergePoint);
			return GS.getGSpoint();

		}
	}

	public void printPoint(Point point) {
		System.out.print("[" + point.getX() + "," + point.getY() + "]");
	}

}
