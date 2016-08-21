package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Permutation {
	public static ArrayList<String> permutation(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if (str == null || str.length() == 0)
			return list;
		StringBuilder stringBuilder=new StringBuilder(str);
		
		
		permutation(stringBuilder,0,list);
		Collections.sort(list);
		System.out.println(list);
		return list;
	}

	public static void permutation(StringBuilder str, int i, ArrayList<String> list) {
		if (i == str.length() - 1 ) {
			list.add(str.toString());
		} else {
			char temp;
			for (int j = i; j < str.length(); j++) {
				temp = str.charAt(i);
				str.setCharAt(i, str.charAt(j));
				str.setCharAt(j, temp);
				permutation(str, i + 1, list);
				temp = str.charAt(i);
				str.setCharAt(i, str.charAt(j));
				str.setCharAt(j, temp);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutation("aa");
	}

}
