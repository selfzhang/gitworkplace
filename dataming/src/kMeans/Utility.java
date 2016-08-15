package kMeans;

public class Utility {
	/**
	 * ����a������b������ŷʽ������Ϊ�����ƶ�
	 * 
	 * @param a
	 *            ����a
	 * @param b
	 *            ����b
	 * @return ŷʽ���볤��
	 */
	public double calDis(double[] aVector, double[] bVector) {
		double dis = 0;
		int i = 0;
		/* ���һ��������ѵ������Ϊ��������Բ����� */
		for (; i < aVector.length; i++)
			dis += Math.pow(bVector[i] - aVector[i], 2);
		dis = Math.pow(dis, 0.5);
		return (double) dis;
	}

	/**
	 * �ж�������ֵ�����Ƿ����
	 * 
	 * @param a
	 *            ����a
	 * @param b
	 *            ����b
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
