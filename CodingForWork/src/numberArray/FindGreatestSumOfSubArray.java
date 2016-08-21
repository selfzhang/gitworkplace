package numberArray;

import java.util.ArrayList;
import java.util.List;

public class FindGreatestSumOfSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { -2, -8, -1, -5, -9 };
		findGreatestSumOfSubArray(array);

	}

	public static int findGreatestSumOfSubArray(int[] array) {

		if (array.length == 0 || array == null)
			return 0;
		List<Integer> list = new ArrayList<Integer>();
		int Sum = 0x80000000;
		System.out.println(Sum);
		int currentSum = 0;
		int begin = 0;
		int end = 0;
		for (int i = 0; i < array.length; i++) {
			if (currentSum < 0) {
				begin = i;

				currentSum = array[i];
			} else {
				currentSum += array[i];

			}
			if (currentSum > Sum) {
				end = i;
				Sum = currentSum;
			}
		}

		if (begin > end) {
			list.add(array[end]);
		} else {
			for (int i = begin; i <= end; i++) {
				list.add(array[i]);
			}
		}

		System.out.println(begin + "  " + end + "  " + Sum + "  " + list);
		return Sum;
	}

}
