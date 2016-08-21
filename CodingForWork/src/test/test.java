package test;

public class test {
	 
	static int count = 0;
//	private static int c2=0;
//	static int c1=0;
	
	static int c1 = 0;

	static int c2 = 0;
	public static void main(String[] args) {
		String S = "aabbccddn";
		String[] disc = { "a", "b", "c", "d" };
		
		System.out.print(getMaxSegs(S, disc, 4));
	}

	public static int getMaxSegs(String S, String[] dics, int n) {
	
		
		if (S.length() == 0) {
			
			return count;
		}

		else {
			if (S.length() == 1) {
				for (int i = 0; i < n; i++)
					if (S.contains(dics[i]))
					{
						return 1;
						
					}
				
			}
			
		}
		
		c1=getMaxSegs(S.substring(0, S.length() /2), dics, n);
		c2=getMaxSegs(S.substring(S.length() /2+1, S.length()), dics, n);
		System.out.println( "c1 "+ c1+"   c2 "+c2);
		count=c1+c2;
		System.out.println( "ll "+ count);
		return count;
	}
	
}
