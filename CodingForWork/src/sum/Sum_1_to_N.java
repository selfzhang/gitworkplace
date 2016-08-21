package sum;

public class Sum_1_to_N {

	private static int count = 0;
	private static int sum=0;
	public Sum_1_to_N() {
		count++;
		sum+=count;
	}

	public static int getCount() {
		return sum;
	}

	public static void main(String[] arg) {
		Sum_1_to_N[] sum_1_to_Ns= new Sum_1_to_N[100];
		sum_1_to_Ns[1]=new Sum_1_to_N();
		System.out.println(Sum_1_to_N.getCount());
	}
}
