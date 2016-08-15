package common;

import java.util.Vector;

public class polarQuickSort {
	public void quick(Vector<point.Point> vecPoint2) {
		if (vecPoint2.size() > 0) {
			quickSort(vecPoint2, 0, vecPoint2.size() - 1);
		}
	}

	public void quickSort(Vector<point.Point> vecPoint2, int low, int high) {
		if (low < high) { // �����������жϵݹ���޷��˳����¶�ջ����쳣
			int middle = getMiddle(vecPoint2, low, high);
			quickSort(vecPoint2, 0, middle - 1);
			quickSort(vecPoint2, middle + 1, high);
		}
	}

	public int getMiddle(Vector<point.Point> vecPoint2, int low, int high) {
		point.Point temp = vecPoint2.get(low);// ��׼Ԫ��
		while (low < high) {
			// �ҵ��Ȼ�׼Ԫ��С��Ԫ��λ��
			while (low < high && vecPoint2.get(high).getAngle() >= temp.getAngle()) {
				high--;
			}
			vecPoint2.set(low, vecPoint2.get(high));
			while (low < high && vecPoint2.get(low).getAngle() <= temp.getAngle()) {
				low++;
			}
			vecPoint2.set(high, vecPoint2.get(low));
		}
		vecPoint2.set(low, temp);
		return low;
	}
}
