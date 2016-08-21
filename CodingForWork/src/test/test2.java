package test;

import java.util.ArrayList;

public class test2 {

	/**
	 * @param args
	 */
	public static int Sum;
	public static int first = 0;
	public static int second;
	// public static ArrayList<Integer> vec =new ArrayList<Integer>();
	public static int A[] = new int[10];
	public static int index = 0;

	public static void find(int front, int me, int count) {

		if (count > 0) {

			for (int i = 0; i < 10; i++) {
				if (i != front && i != me) {
					// vec.add(i);
					A[index++] = i;
					find(me, i, count - 1);
					// vec.remove(vec.size()-1);
					--index;
				}

			}
		} else {

			// System.out.print(vec);
			for (int i = 0; i < index; i++)
				System.out.print(A[i] + " ");

			System.out.print("    ");

			Sum++;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 3;// 传播的次数
		for (int i = 1; i < 10; i++) {
			second = i;
			// vec.add(first);
			// vec.add(second);
			A[index++] = first;
			A[index++] = second;
			find(0, i, count - 1);
			System.out.println();
			// vec.clear();
			index = 0;
		}
		System.out.println(Sum);

	}

}
