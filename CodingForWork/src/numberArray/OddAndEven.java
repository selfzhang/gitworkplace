package numberArray;

public class OddAndEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1,2,3,4,5,6,7,8,9};
		oddAndeven(num);
	}

	public static void oddAndeven(int[] num) {
		if (num == null)
			return;
		int p = -1;
		int q = 0;
		while (q < num.length) {
			if (num[q] % 2 != 0) {
				int i = q;
				p++;
				int temp = num[q];
				while (i > p) {
					num[i] = num[i - 1];
					i--;
				}
				num[p] = temp;
			}
			q++;
		}
		Util.printArray(num);
	}
}
