package numberArray;

import java.util.ArrayList;

public class FindMinKNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = { 3, 4, 5, 6, 2, 3, 9, 12, 5, 85, 45, 22, 66, 4, 5, 55, 22, 21 };
		Util.printList(findMinKNum(num1, num1.length - 8));
	}

	public static ArrayList<Integer> findMinKNum(int[] num, int k) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if (num != null && k < num.length + 1 && k > 0) {
			int start = 0;
			int end = num.length - 1;
			int index = Partition(num, start, end);
			while (index != (k - 1)) {
				if (index > k - 1) {
					end = index - 1;
					index = Partition(num, start, end);
				} else {
					start = index + 1;
					index = Partition(num, start, end);
				}
			}
			for (int i = 0; i < k - 1; i++) {
				arrayList.add(num[i]);
			}
		}
		return arrayList;
	}

	public static int Partition(int[] num, int start, int end) {
		int index = start;
		int temp = num[index];
		num[index] = num[end];
		num[end] = temp;
		index = -1;
		for (int i = 0; i < num.length; i++) {
			if (num[i] < num[end]) {
				index++;
				if (i != index) {
					temp = num[index];
					num[index] = num[i];
					num[i] = temp;
				}
			}
		}
		index++;
		temp = num[index];
		num[index] = num[end];
		num[end] = temp;
		return index;
	}
}
