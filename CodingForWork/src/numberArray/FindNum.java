package numberArray;

public class FindNum {

	public static void main(String[] args) {// 数组 从左到右递增，从上到下递增 ，查找数字存不存在
		// TODO Auto-generated method stub
		int[][] a = new int[][] { { 1, 2, 3, 4 }, { 3, 3, 4, 5 }, { 4, 5, 6, 7 }, { 6, 7, 8, 9 } };
		System.out.println(a.length + "  " + a[0].length);
		System.out.println(findNum(a, 8));
	}

	public static boolean findNum(int[][] num, int target) {
		if (num == null)
			return false;
		// 从右上角出发
		int rowIndex = 0;
		int colIndex = num[0].length - 1;

		if (num.length > 0 && num[0].length > 0) {
			while (rowIndex < num.length && colIndex > -1) {
				if (num[rowIndex][colIndex] == target) {
					return true;
				} else if (num[rowIndex][colIndex] > target) {
					colIndex--;
				} else if (num[rowIndex][colIndex] < target) {
					rowIndex++;
				}
			}
		}
		return false;
	}
}
