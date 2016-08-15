package drawCluster;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import common.Point;

public class DrawCluster extends JPanel {
	private common.Point DbPoint;
	
	private List<List<Point>> FinalresultList = new ArrayList<List<Point>>();// 存储DBSCAN算法返回的结果集

	public DrawCluster(List<List<Point>> finalresultList){
		
		FinalresultList=finalresultList;
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
//		super.paint(g);
		for (Iterator<List<Point>> it = FinalresultList.iterator(); it.hasNext();) {

			List<Point> lst = it.next();

			if (lst.isEmpty()) {
				continue;
			}
			Random R=new Random();
			int r = R.nextInt(255);
			int G = R.nextInt(255);
			int b = R.nextInt(255);
			
			Color c = new Color(r,G,b); 
			
			for (Iterator<Point> it1 = lst.iterator(); it1.hasNext();) {

				DbPoint = it1.next();
				g.setColor(c); 

				g.fillOval((int)DbPoint.getX()*10, (int)DbPoint.getY()*10, 4, 4);
			}
		}
	
	}
	
}