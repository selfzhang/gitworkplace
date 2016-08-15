package drawPoint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import point.Point;

import java.util.*;

public class DrawLine extends JFrame {
	private Vector<Point> sumPoint = new Vector<Point>();
	private Vector<Point> chPoint = new Vector<Point>();
	private int sumPointNum = 0;
	private int chPointNum = 0;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1768744717702320902L;

	public DrawLine(Vector<Point> sumPoint,Vector<Point> chPoint,int sumPointNum,int chPointNum,String name){
		this.setTitle(name);
		this.sumPoint=sumPoint;
		this.chPoint=chPoint;
		this.sumPointNum = sumPointNum;
		this.chPointNum = chPointNum;
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		this.setBounds(90, 90,500,500);
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		int sumX[] = new int[sumPointNum];
		int sumY[] = new int[sumPointNum];
		
		int chX[] = new int[chPointNum];
		int chY[] = new int[chPointNum];

		for(int i=0;i<sumPointNum;i++){
			sumX[i] = (int) sumPoint.get(i).getX();
			sumY[i] = (int) sumPoint.get(i).getY();
			g.fillOval((int) sumX[i], (int)sumY[i], 5, 5);
		}

		for(int i=0;i<chPointNum;i++){
			chX[i] = (int) chPoint.get(i).getX();
			chY[i] = (int) chPoint.get(i).getY();
			
		}
		
		g.drawPolygon(chX, chY, chPointNum);
		
		
	}

		
}