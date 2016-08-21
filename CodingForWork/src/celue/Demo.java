package celue;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CookFish cookFish = new ChinaCook();
		Celue celue = new Celue(cookFish);
		celue.action();
		LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put(2, 3);
		linkedHashMap.put(3, 3);
		linkedHashMap.put(7, 3);
		linkedHashMap.put(1, 3);
		linkedHashMap.put(8, 3);
		linkedHashMap.put(6, 3);

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		hashMap.put(2, 3);
		hashMap.put(3, 3);
		hashMap.put(7, 36);
		hashMap.put(10, 63);
		hashMap.put(8, 56);
		hashMap.put(6, 3);

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(2, 3);
		treeMap.put(3, 3);
		treeMap.put(7, 3);
		treeMap.put(1, 3);
		treeMap.put(8, 3);
		treeMap.put(6, 3);

		
		try{
			Iterator iterator = hashMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Integer> entry = (java.util.Map.Entry<Integer, Integer>) iterator.next();
				System.out.println(entry.getKey() + "   hashMap  " + entry.getValue());
			}
			return ;
		}finally{
			
			Iterator iterator = treeMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Integer> entry = (java.util.Map.Entry<Integer, Integer>) iterator.next();
				System.out.println(entry.getKey() + " treeMap " + entry.getValue());
			}
		}
		
	}

}
