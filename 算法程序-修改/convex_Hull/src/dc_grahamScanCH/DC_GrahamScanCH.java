package dc_grahamScanCH;

import java.util.Iterator;
import java.util.Vector;

import point.Point;

import common.SelectMiddle;
import common.quickSort;

public class DC_GrahamScanCH {
//	private Vector<Point> vecPoint = new Vector<Point>();
	private Vector<Point> DCGSCH = new Vector<Point>();
	private Vector<Point> leftPoint = new Vector<Point>();
	private Vector<Point> rightPoint = new Vector<Point>();

	private Point P1 = new Point(1, 1);
	private Point P6 = new Point(3, 1.5);
	private Point P3 = new Point(5, 2);
	private Point P5 = new Point(5, 4);
	private Point P4 = new Point(3, 4);
	private Point P2 = new Point(3, 2);
	private Point P7 = new Point(2, 2);
	private Point P8 = new Point(4, 3);
	private Point P9 = new Point(4, 1);
	private Point XmaxPoint = new Point();
	private Point XminPoint = new Point();
	private quickSort sort = new quickSort();

	public DC_GrahamScanCH(Vector<Point> vecPoint) {
		

		System.out.println("=========================================");

		double middle = new SelectMiddle().select_middle(vecPoint, 0,
				vecPoint.size() - 1, vecPoint.size());
		for (int i = 0; i <vecPoint.size() - 1; i++) {
			if (vecPoint.get(i).getX() <= middle) {
				leftPoint.add(vecPoint.get(i));
			} else
				rightPoint.add(vecPoint.get(i));
		}
	
		DCGSCH=getConvexHulls(vecPoint);
		System.out.println("=========================================dddddd");
		for (int i = 0; i < DCGSCH.size(); i++) {
			printPoint(DCGSCH.get(i));
		}
	}
	
    public Vector<Point> getConvexHulls(Vector<Point> point){
        //��͹��������result������
    	Vector<Point> result = new Vector<Point>(); 
        
        Point temp1 = point.remove(0);
        Point temp2 = point.remove(point.size()-1);
        result.add(temp1);
        result.add(temp2);
        
        //�ݹ�Ĵ���temp1 ---> temp2��������ĵ�
        dealWithLeft(temp1,temp2,result,point);
        dealWithLeft(temp2,temp1,result,point);//ע��ÿ��Ҫ��result���ţ���Ž����
        
        return result;
    }
	private static void dealWithLeft(Point p1,Point p2,Vector<Point> result,Vector<Point> list){
        //�ݹ�Ĵ���p1��p2���ɵ�������ߵĵ�
        Iterator it = list.iterator();
        
        //�ҳ������ߵĵ�Pmax
        Point Pmax = null;
        double max = 0;
        while(it.hasNext())
        {
            Point next = (Point) it.next();
            double x1 = p1.getX();
            double y1 = p1.getY();
            double x2 = p2.getX(),y2 = p2.getY();
            double x3 = next.getX(),y3 = next.getY();
            
            double compute = x1*y2 + x3*y1 + x2*y3 - x3*y2 - x2*y1 - x1*y3;
            if(compute > max)
            {
                max = compute;
                Pmax = next;
            }    
        }
        
        //���ҵ���һ������
        if(Pmax != null)
        {
            result.add(Pmax);
            list.remove(Pmax);
            
            //�ݹ�
            dealWithLeft(p1,Pmax,result,list);
            dealWithLeft(Pmax,p2,result,list);    
        }
    }
    
    private static boolean onLeft(Point target,Point p1,Point p2){
        //�ж�target�Ƿ���p1--->p2���ߵ����
        double x1 = p1.getX(),y1 = p1.getY();
        double x2 = p2.getX(),y2 = p2.getY();
        double x3 = target.getX(),y3 = target.getY();
        
        double compute = x1*y2 + x3*y1 + x2*y3 - x3*y2 - x2*y1 - x1*y3;
        if(compute > 0)
            return true;
        else
            return false;
    }
    
    

	public void printPoint(Point point) {
		System.out.print("[" + point.getX() + "," + point.getY() + "]");
	}
}
