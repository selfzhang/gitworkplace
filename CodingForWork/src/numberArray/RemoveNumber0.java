package numberArray;

public class RemoveNumber0 {
	public static int[] removeNumber0(int[] num) {
		if (num == null) {
			return null;
		}
		int firstIndexZero = -1;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0 && firstIndexZero == -1)
				firstIndexZero = i;
			if (num[i] != 0 && firstIndexZero != -1) {

				num[firstIndexZero] = num[i];
				num[i] = 0;
				if (num[firstIndexZero + 1] == 0) {
					firstIndexZero++;
				} else {
					firstIndexZero = i;
				}
			}
		}
		return num;
	}
	public static int[] removeNumberZero(int[] num) {
		if(num==null)
			return null;
		int begin=0;
		int end =num.length-1;
		while(begin<end){
			while((begin<end) && (num[begin]!=0))
				begin++;
			while((begin<end) && (num[end]==0))
				end--;

			num[begin]=num[end];
			num[end]=0;
		}
		return num;
	}
	public static void main(String[] args) {
		int[] num1 = { 0, 0, 1, 4, 0, 0, 3, 4 };
		int[] num2 = { 1, 2, 0, 0, 3, 4 };
		int[] num3 = { 0, 1, 7, 0, 3, 4 };
		int[] num4 = { 0, 0, 1, 4, 0, 0, 3, 4, 0, 0 };
		Util.printArray(removeNumberZero(num1));
		Util.printArray(removeNumberZero(num2));
		Util.printArray(removeNumberZero(num3));
		Util.printArray(removeNumberZero(num4));
		
		System.out.println("-------------------");

		Util.printArray(removeNumber0(num1));
		Util.printArray(removeNumber0(num2));
		Util.printArray(removeNumber0(num3));
		Util.printArray(removeNumber0(num4));
	}

	
}
