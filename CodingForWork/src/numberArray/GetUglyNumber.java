package numberArray;

import java.util.HashMap;

public class GetUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getUglyNumber(1500);
	}

	public static int getUglyNumber(int index) {
		if (index <= 0)
			return 0;
		int num = 0;
		int ugly = 0;
		while (ugly < index) {
			num++;
			if (isUgly(num)) {

				ugly++;
			}
		}
		System.out.println(num);
		return num;
	}

	public static boolean isUgly(int num) {
		while (num % 2 == 0)
			num = num / 2;
		while (num % 3 == 0)
			num = num / 3;
		while (num % 5 == 0)
			num = num / 5;
		if (num == 1)
			return true;
		return false;
	}
	
	 
}
