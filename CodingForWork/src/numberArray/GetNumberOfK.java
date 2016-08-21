package numberArray;

public class GetNumberOfK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 3, 3, 3, 3, 4, 5 };
		// new GetNumberOfK().getNumberOfK(array, 3);
		System.out.println(new GetNumberOfK().getNumberOfK(array, 3));
	}

	public int getNumberOfK(int[] array, int k) {
		if (array.length == 0 || array == null)
			return 0;
		int lastIndex = getLastK(array, k);
		int firstIndex = getFistK(array, k);
		if (lastIndex == -1) {
			return 0;
		}
		return lastIndex - firstIndex + 1;
	}

	public int getFistK(int[] array, int k) {
		int begin = 0;
		int end = array.length - 1;
		int mid = 0;
		while (begin <= end) {
			mid = (begin + end) / 2;
			if (array[mid] == k) {
				if (mid > 0 && array[mid - 1] != k || mid == 0)
					return mid;
				else
					end = mid - 1;
			} else {
				if (array[mid] > k)
					end = mid - 1;
				else if (array[mid] < k)
					begin = mid + 1;
			}
		}
		if (begin > end) {
			return -1;
		}
		return mid;
	}

	public int getLastK(int[] array, int k) {
		int begin = 0;
		int end = array.length - 1;
		int mid = 0;
		while (begin <= end) {
			mid = (begin + end) / 2;
			if (array[mid] == k) {
				if (mid < array.length - 1 && array[mid + 1] != k || mid == array.length - 1)
					return mid;
				else
					begin = mid + 1;
			} else {
				if (array[mid] > k)
					end = mid - 1;
				else if (array[mid] < k)
					begin = mid + 1;
			}
		}
		if (begin > end) {
			return -1;
		}
		return mid;
	}
}
