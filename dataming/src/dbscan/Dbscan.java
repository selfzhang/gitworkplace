package dbscan;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import java.util.*;

import javax.swing.JFrame;

import common.Point;

import drawCluster.DrawCluster;

public class Dbscan {

	private static List<Point> pointsList = new ArrayList<Point>();// �洢���е�ļ���

	private static List<List<Point>> resultList = new ArrayList<List<Point>>();// �洢DBSCAN�㷨���صĽ����
	
	private static List<List<Point>> FinalresultList = new ArrayList<List<Point>>();// �洢DBSCAN�㷨���صĽ����
	
	private static int e = 2;// e�뾶

	private static int minp = 3;// �ܶ���ֵ

	/**
	 * 
	 * ��ӡ���ݵ�
	 * ���������FinaresultList���㻭ͼ
	 * 
	 */

	public static void display() {

		int index = 1;

		for (Iterator<List<Point>> it = resultList.iterator(); it.hasNext();) {

			List<Point> lst = it.next();

			if (lst.isEmpty()) {

				continue;

			}
//			System.out.println("-----��" + index + "������-----");
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

	// �ҳ����п���ֱ��ľ���

	private static void applyDbscan() {

		try {

			pointsList = Utility.getPointsList();

			for (Iterator<Point> it = pointsList.iterator(); it.hasNext();) {

				Point p = it.next();

				if (!p.isClassed()) {

					List<Point> tmpLst = new ArrayList<Point>();

					if ((tmpLst = Utility.isKeyPoint(pointsList, p, e, minp)) != null) {

						// Ϊ���о�����ϵĵ�����ʾ

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

	// �����п���ֱ��ľ�����кϲ������ҳ���ӿɴ�ĵ㲢���кϲ�

	public static List<List<Point>> getResult() {

		applyDbscan();// �ҵ�����ֱ��ľ���

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
	 * ����������
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