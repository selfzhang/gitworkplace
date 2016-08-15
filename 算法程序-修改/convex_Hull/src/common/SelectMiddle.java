package common;

import java.util.Vector;

import point.Point;

public class SelectMiddle {
	Point tempPoint = new Point();
	public void exch (Vector<Point> point, int i, int j)  
	{  
	    if (i!=j)  
	    {  
	    	
	    	tempPoint = point.get(i);
	    	point.set(i, point.get(j));
	    	point.set(j, tempPoint);
	    	
	    }  
	}
	        
	public double select_middle (Vector<Point> point, int beg, int end, int n)  
	{  
		
	    if (n == 1)  
	        return point.get(n).getX();  
	    int i = beg, j;  
	    for (j=i+1; j<=end; ++j)  
	        if (point.get(j).getX()<=point.get(beg).getX())  
	        {  
	            i++;  
	            exch (point, i, j);  
	        }  
	    exch (point, beg, i);  
	        
	    if (i < n/2)  
	        return select_middle (point, i+1, end, n);  
	    else if (i > n/2)  
	        return select_middle (point, beg, i-1, n);  
	    else  
	    {  
	        if (n%2==0)  
	            return point.get(i).getX();  
	        else  
	        {  
	            double m=point.get(0).getX();  
	            for (int k=1; k<i; ++k)  
	                if (point.get(k).getX() > m)  
	                    m=point.get(k).getX();  
	            return (double)(point.get(i).getX()+m)/2;  
	        }  
	    }  
	} 
}

