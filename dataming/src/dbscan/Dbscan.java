package dbscan;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import java.util.*;

import javax.swing.JFrame;

import common.Point;

import drawCluster.DrawCluster;

public class Dbscan {

	private static List<Point> pointsList = new ArrayList<Point>();// 存储所有点的集合

	private static List<List<Point>> resultList = new ArrayList<List<Point>>();// 存储DBSCAN算法返回的结果集
	
	private static List<List<Point>> FinalresultList = new ArrayList<List<Point>>();// 存储DBSCAN算法返回的结果集
	
	private static int e = 2;// e半径

	private static int minp = 3;// 密度阈值

	/**
	 * 
	 * 打印数据点
	 * 将结果存入FinaresultList方便画图
	 * 
	 */

	public static void display() {

		int index = 1;

		for (Iterator<List<Point>> it = resultList.iterator(); it.hasNext();) {

			List<Point> lst = it.next();

			if (lst.isEmpty()) {

				continue;

			}
//			System.out.println("-----第" + index + "个聚类-----");
			FinalresultList.add(lst);
//			for (Iterator<Point> it1 = lst.iterator(); it1.hasNext();) {
//
//				Point p = it1.next();
//				p.setClusternum(index);
//				
////				System.out.println(p.print());
//
//			}

			index++;

		}


	}

	// 找出所有可以直达的聚类

	private static void applyDbscan() {

		try {

			pointsList = Utility.getPointsList();

			for (Iterator<Point> it = pointsList.iterator(); it.hasNext();) {

				Point p = it.next();

				if (!p.isClassed()) {

					List<Point> tmpLst = new ArrayList<Point>();

					if ((tmpLst = Utility.isKeyPoint(pointsList, p, e, minp)) != null) {

						// 为所有聚类完毕的点做标示

						Utility.setListClassed(tmpLst);

						resultList.add(tmpLst);

					}

				}

			}

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	// 对所有可以直达的聚类进行合并，即找出间接可达的点并进行合并

	public static List<List<Point>> getResult() {

		applyDbscan();// 找到所有直达的聚类

		int length = resultList.size();

		for (int i = 0; i < length; ++i) {

			for (int j = i + 1; j < length; ++j) {

				if (Utility.mergeList(resultList.get(i), resultList.get(j))) {

					resultList.get(j).clear();

				}

			}

		}

		return resultList;

	}

	/**
	 * 
	 * 程序主函数
	 * 
	 * @param args
	 */

	public void main() {

		getResult();
		display();
		
		JFrame aFrame=new JFrame("DBScan");
		DrawCluster aa=new DrawCluster(FinalresultList);
		aFrame.setSize(700,600);
		aFrame.setVisible(true);
		aFrame.add(aa);
		aFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		
		// System.out.println(Utility.getDistance(new Point(0,0), new
		// Point(0,2)));

	}

}