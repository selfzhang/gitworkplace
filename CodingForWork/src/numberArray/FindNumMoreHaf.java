package numberArray;

public class FindNumMoreHaf {

	public static void main(String[] args) {//一定存在这个数，出现次数大于一半
		int[] num1 = { 0, 0, 1, 4,4,4,4,4,4,4,4,4,4, 0,0,0, 0,0,3, 4 };
		System.out.println(findNumMoreHalf(num1));
	}

	public static int findNumMoreHalf(int[] num) {
		int result = num[0];
		int count = 1;
		for (int i = 1; i < num.length; i++) {
			if (num[i] == result) {
				count++;
			} else if (count == 0) {
				result = num[i];
				count = 1;
			} else {
				count--;
			}
		}
		if (count > 0) {
			return result;
		} else {

			return -1;
		}

	}

}
