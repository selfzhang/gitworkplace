package hcl;

import java.util.List;

import common.Point;

public class Utility {
	// 计算两个样本点之间的欧几里得距离
		public double getDistance(DataPoint dpA, DataPoint dpB) {
			double distance = 0;
			double[] dimA = dpA.getDimensioin();
			double[] dimB = dpB.getDimensioin();
			if (dimA.length == dimB.length) {
				for (int i = 0; i < dimA.length; i++) {
					double temp = Math.pow((dimA[i] - dimB[i]), 2);
					distance = distance + temp;
				}
				distance = Math.pow(distance, 0.5);
			}
			return distance;
		}
		
		public List<Cluster> mergeCluster(List<List<Point>> FinalresultList,List<Cluster> clusters, int mergeIndexA,
				int mergeIndexB) {
			
			if (mergeIndexA != mergeIndexB) {
				
				Cluster clusterA = clusters.get(mergeIndexA);
				Cluster clusterB = clusters.get(mergeIndexB);
				List<DataPoint> dpA = clusterA.getDataPoints();
				List<DataPoint> dpB = clusterB.getDataPoints();
				
				List<Point> tempA=FinalresultList.get(mergeIndexA);
				List<Point> tempB=FinalresultList.get(mergeIndexB);
				
				for(int i=0;i<dpB.size();i++){
					DataPoint tempDp = new DataPoint();
					tempDp.setDataPointName(dpB.get(i).getDataPointName());
					tempDp.setDimensioin(dpB.get(i).getDimensioin());
					tempDp.setCluster(clusterA);
					dpA.add(tempDp);
					tempA.add(tempB.get(i));
				}
				
				clusterA.setDataPoints(dpA);
				clusters.remove(mergeIndexB);
				
				FinalresultList.set(mergeIndexA, tempA);//合并两个类
				FinalresultList.remove(mergeIndexB);
			}
			return clusters;
		}
		
}
