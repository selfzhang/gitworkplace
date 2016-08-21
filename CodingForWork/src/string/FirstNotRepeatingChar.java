package string;

import java.util.HashMap;

public class FirstNotRepeatingChar {
	public char firstNotRepeatingChar(String str) {
        char pos = 0 ;
        if(str==null || str.length()<=0){
           return pos;
        }
        HashMap <Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }
            else {
                map.put(str.charAt(i), 1);
            }
        }
         
        int i=0;
        for(;i<str.length();i++){
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return c;
            }
        }
        return pos;
    }
}
