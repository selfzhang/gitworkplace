package packageAnswer;

public class ApproxPackageAnswe {
	public static long time = 0;
	public ApproxPackageAnswe(int[] weight, int[] value, int things_count,
			int packetC,double e) {
		long startTime=System.currentTimeMillis(); 
		double K=(double) (things_count / e);
		
		int Vmax= 0;
		for(int i =1;i<things_count+1;i++){
			if(value[i]>=Vmax){
				Vmax = value[i];
			}
		}
		for(int i=1;i<things_count+1;i++){
			value[i]= (int) (value[i]*(K/Vmax));
		}
		getApproxPackageAnswer(weight, value, things_count, packetC);
		long endTime=System.currentTimeMillis(); 
		System.out.println();
		time = endTime-startTime;
	}
	public ApproxPackageAnswe(){
		
	}
	public void getApproxPackageAnswer(int[] weight, int[] value, int things_count,
			int packetC) {
		int[][] thing = new int[things_count + 1][packetC + 1];

		for (int i = 1; i <= min(weight[things_count] - 1,packetC); i++) {
			thing[things_count][i] = 0;
		}

		for (int i = weight[things_count]; i <= packetC; i++) {
			thing[things_count][i] = value[things_count];
		}

		for (int i = things_count - 1; i > 1; i--) {
			for (int j = 0; j <= min(weight[i] - 1,packetC); j++) {
				thing[i][j] = thing[i + 1][j];
			}
			for (int j = weight[i]; j <= packetC; j++) {
				thing[i][j] = thing[i + 1][j - weight[i]] + value[i];
				if (thing[i][j] < thing[i + 1][j])
					thing[i][j] = thing[i + 1][j];
			}
		}
//		thing[1][packetC] = thing[2][packetC - weight[1]] + value[1];
//		if (thing[1][packetC] < thing[2][packetC])
//			thing[1][packetC] = thing[2][packetC];
		
		if (packetC < weight[1]) {
			thing[1][packetC] = thing[2][packetC];
		} else {
			thing[1][packetC] = thing[2][packetC - weight[1]] + value[1];
			if (thing[1][packetC] < thing[2][packetC])
				thing[1][packetC] = thing[2][packetC];
		}
		for (int i = 0; i < things_count; i++) {
			for (int j = 0; j < packetC; j++) {
				System.out.print(thing[i][j] + " ");
			}
			System.out.println();
		}
		
		int index=packetC;
		int x[]=new int[things_count+1];
		for (int i=0;i<things_count;i++){
			if(thing[i][index]==thing[i+1][index]){
				x[i]=0;
			}else{
				x[i]=1;
				index=index-weight[i];
			}
		}
		if(thing[things_count][index]==0)
			x[things_count]=0;
		else 
			x[things_count]=1;
		System.out.println();
		System.out.println();
		int maxValue=0;
		int maxWeight = 0;
		for(int i=1;i<things_count+1;i++){
//			System.out.print(x[i]+" ");
			if(x[i]==1){
				maxValue+=value[i];
				maxWeight+=weight[i];
				System.out.print("["+weight[i]+" , "+ value[i]+"] " );
			}
		}
		System.out.print("maxWeight= "+maxWeight+" packetC="+packetC+"  maxValue="+maxValue );
	}
	public int min(int a,int b){
		if (a<=b)
			return a;
		else 
			return b;
	}
}
