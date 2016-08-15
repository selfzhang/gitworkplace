package hcl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import common.Point;
import drawCluster.DrawCluster;

public class HCL {

	private static ArrayList<DataPoint> dpoints = new ArrayList<DataPoint>();
	private Utility utility = new Utility();
	
	private static List<List<Point>> FinalresultList = new ArrayList<List<Point>>();
	
	private static List<Cluster> clusters;
	private static ArrayList<Point> points = new ArrayList<Point>();
	private static String split=" ";
	
	public List<Cluster> startAnalysis(List<DataPoint> dataPoints,
			int ClusterNum) {

		List<Cluster> finalClusters = new ArrayList<Cluster>();
		List<Cluster> originalClusters = initialCluster(dataPoints);
		finalClusters = originalClusters;
		
		while (finalClusters.size() > ClusterNum) {

			double min = Double.MAX_VALUE;

			int mergeIndexA = 0;
			int mergeIndexB = 0;

			for (int i = 0; i < finalClusters.size(); i++) {
				for (int j = 0; j < finalClusters.size(); j++) {
					if (i != j) {
						
						Cluster clusterA = finalClusters.get(i);
						Cluster clusterB = finalClusters.get(j);
						List<DataPoint> dataPointsA = clusterA.getDataPoints();
						List<DataPoint> dataPointsB = clusterB.getDataPoints();
						
						for (int m = 0; m < dataPointsA.size(); m++) {
							for (int n = 0; n < dataPointsB.size(); n++) {
								double tempDis = utility.getDistance(
										dataPointsA.get(m), dataPointsB.get(n));
								if (tempDis < min) {
									min = tempDis;
									mergeIndexA = i;
									mergeIndexB = j;
								}
							}
						}
					}
				}
			}
			
//			utility.mergeResult(FinalresultList,mergeIndexA,mergeIndexB);
			
			finalClusters = utility.mergeCluster(FinalresultList,finalClusters, mergeIndexA,
					mergeIndexB);
			
			
			
		}
		return finalClusters;
	}

	// 初始化类簇
	private List<Cluster> initialCluster(List<DataPoint> dataPoints) {
		
		List<Cluster> originalClusters = new ArrayList<Cluster>();
		
		for (int i = 0; i < dataPoints.size(); i++) {
			
			List<DataPoint> tempDataPoints = new ArrayList<DataPoint>();
			DataPoint tempDataPoint = dataPoints.get(i);
			tempDataPoints.add(tempDataPoint);
			Cluster tempCluster = new Cluster();
			tempCluster.setClusterName("Cluster " + String.valueOf(i));
			tempCluster.setDataPoints(tempDataPoints);
			tempDataPoint.setCluster(tempCluster);
			originalClusters.add(tempCluster);
			points.get(i).setClusternum(i);//加入点
			
		}
		
//		System.out.println("eeee "+FinalresultList.get(2).size());
		return originalClusters;
	}

	public static void readData(String trainingFileName) {
		try {
			FileReader fr = new FileReader(trainingFileName);
			BufferedReader br = new BufferedReader(fr);
			// 存放数据的临时变量
			String lineData = null;
			String[] splitData = null;
			int line = 1;
			// 按行读取
			while (br.ready()) {
				// 得到原始的字符串
				lineData = br.readLine();
				splitData = lineData.split(split);
				List<Point> tpList=new ArrayList<Point>();
				// 转化为数据
				if (splitData.length > 1) {
					double[] a = { 0, 0 };
					for (int i = 0; i < splitData.length; i++) {

						// 将数据截取之后放进数组
						a[i] = Double.parseDouble(splitData[i]);
					}
					
					dpoints.add(new DataPoint(a, line));
					
					points.add(new Point(line,
							Double.parseDouble(splitData[0]), Double
									.parseDouble(splitData[1])));
					tpList.add(new Point(line,
							Double.parseDouble(splitData[0]), Double
									.parseDouble(splitData[1])));
					FinalresultList.add(tpList);//把每一个点加入最终的结果
					line++;
					
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public void disply() {
		
		readData("E:\\dbscan.txt");
		int clusterNum = 6; // 类簇数
		clusters = startAnalysis(dpoints, clusterNum);
		
		System.out.println(FinalresultList.size());
		
		for(int i=0;i<FinalresultList.size();i++){
			
			for(int j=0;j<FinalresultList.get(i).size();j++){
				
				System.out.println(FinalresultList.get(i).size());
				
			}
			
		}
		
		for (Cluster cl : clusters) {
			System.out.println("------" + cl.getClusterName() + "------");
			List<DataPoint> tempDps = cl.getDataPoints();
			for (DataPoint tempdp : tempDps) {
				System.out.println(tempdp.getDataPointName());
			}
		}
	}

	public void main() {
		
		disply();
		
		JFrame aFrame = new JFrame("HCL");
		DrawCluster aa = new DrawCluster(FinalresultList);
		aFrame.setSize(700, 600);
		aFrame.setVisible(true);
		aFrame.add(aa);
		aFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
}