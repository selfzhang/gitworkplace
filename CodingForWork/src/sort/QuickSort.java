package sort;

public class QuickSort {

	public static int[] quickSort(int[] num, int start, int end, int length) {
		if (length <= 0 || num == null || start < 0 || end < 0 || end > length) {
			return null;
		}
		int index = partition(num, start, end, length);
//		System.out.println(index + " " + start + " " + end);
		if (index > start)
			quickSort(num, start, index - 1, length);
		if (index < end)
			quickSort(num, index + 1, end, length);
		return num;
	}

	public static int partition(int[] num, int start, int end, int length) {
		if (length <= 0 || num == null || start < 0 || end < 0 || end >= length) {
			return -1;
		}
		int index = start;
		int temp = num[index];
		num[index] = num[end];
		num[end] = temp;
		index = start - 1;
		for (int i = start; i < end + 1; i++) {
			if (num[i] < num[end]) {
				index++;
				if (index != i) {
					temp = num[i];
					num[i] = num[index];
					num[index] = temp;
				}
			}
		}
		index++;
		temp = num[end];
		num[end] = num[index];
		num[index] = temp;
		return index;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 2, 4, 8, 67, 44, 23, 21, 45, 88, 99, 33, 100, 44 };
		int[] data = quickSort(num, 0, num.length - 1, num.length);
		for (int i : data) {
			System.out.print(i + " ");
		}

	}

	public static void p(Object object) {
		System.out.println(object);
	}
}
