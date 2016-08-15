package packageAnswer;

public class Main {
	private static int packetC = (int) (Math.random() * 10000 + 1);

	private static int things_count = 10000;
	
	private static double e=0.2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weight = new int[things_count + 1];
		int[] value = new int[things_count + 1];
		int[] value2 = new int[things_count + 1];
		for (int i = 1; i <= things_count; i++) {

			weight[i] = ((int) (Math.random() * 10000 + 1));
			value2[i]=value[i] = ((int) (Math.random() * 10000 + 1));
//			System.out.print("["+weight[i]+","+value[i]+"] ");

		}
		new PackageAnswer(weight, value, things_count, packetC);
		new ApproxPackageAnswe(weight, value, things_count, packetC,e);
		
		System.out.println("动态规划时间   "+PackageAnswer.time);
		
		System.out.println("近似算法时间   "+ApproxPackageAnswe.time);
	}

}
