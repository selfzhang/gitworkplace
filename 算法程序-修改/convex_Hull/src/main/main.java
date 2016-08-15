package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import point.Point;

import dc_grahamScanCH.DC_GrahamScanCH;
import dc_grahamScanCH.DCgrahamScanCH;
import drawPoint.DrawLine;
import grahamScanCH.GrahamScan;
import bruteForceCH.bruteForceCH;

public class main {
	private static Vector<Point> vecPoint1 =new Vector<Point>();
	private static Vector<Point> vecPoint2 =new Vector<Point>();
	private static Vector<Point> vecPoint3 =new Vector<Point>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getPoint();
		// TODO Auto-generated method stub
		 Vector<Point> vecPoint0 =new Vector<Point>();
		for(int i =0;i<vecPoint1.size();i++){
			vecPoint0.add(vecPoint1.get(i));
		}
		System.out.println("----------------蛮力法------------------");
		bruteForceCH bFCH = new bruteForceCH(vecPoint1);
		
		System.out.println("----------------扫描法------------------");
		GrahamScan GS = new GrahamScan(vecPoint2);
		
		System.out.println("-----------------分治法-----------------");
		DCgrahamScanCH Dc = new DCgrahamScanCH(vecPoint3);
		
		System.out.println("----------------------------------");

		
	   new DrawLine(vecPoint0,bFCH.getPointCH(),vecPoint0.size(),bFCH.getPointCH().size(),"蛮力法凸包问题");

	   new DrawLine(vecPoint0,GS.getGSpoint(),vecPoint0.size(),GS.getGSpoint().size(),"扫描法凸包问题");
	   
	   new DrawLine(vecPoint0,Dc.getMergePoint(),vecPoint0.size(),Dc.getMergePoint().size(),"分治凸包问题");
	   
	}

	public static void getPoint() {
		for(int i=0;i<30;i++){
			Point point = new Point();
			point.setX((double)(int)(new Random().nextInt(435)+50));
			point.setY((double)(int)(new Random().nextInt(435)+50));
			vecPoint1.add(point);
			
			vecPoint2.add(point);
			
			vecPoint3.add(point);
		}
		

	}
}
