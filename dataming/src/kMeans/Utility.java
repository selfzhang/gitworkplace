package kMeans;

public class Utility {
	/**
	 * 计算a样本和b样本的欧式距离作为不相似度
	 * 
	 * @param a
	 *            样本a
	 * @param b
	 *            样本b
	 * @return 欧式距离长度
	 */
	public double calDis(double[] aVector, double[] bVector) {
		double dis = 0;
		int i = 0;
		/* 最后一个数据在训练集中为结果，所以不考虑 */
		for (; i < aVector.length; i++)
			dis += Math.pow(bVector[i] - aVector[i], 2);
		dis = Math.pow(dis, 0.5);
		return (double) dis;
	}

	/**
	 * 判断两个均值向量是否相等
	 * 
	 * @param a
	 *            向量a
	 * @param b
	 *            向量b
	 * @return
	 */
	public boolean compareMean(double[] a, double[] b) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0 && b[i] > 0 && a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

}
