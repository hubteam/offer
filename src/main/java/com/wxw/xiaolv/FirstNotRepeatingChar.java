package com.wxw.xiaolv;

import java.util.HashMap;
import java.util.Map.Entry;

public class FirstNotRepeatingChar {

	public String first(String str){
		char[] c = str.toCharArray();
		HashMap<String, Integer> hs = new HashMap<String, Integer>();
		for (int i = 0; i < c.length; i++) {
			if(hs.containsKey(c[i])){
				int count = hs.get(c[i]);
				hs.put(c[i]+"", count+1);
			}else{
				hs.put(c[i]+"", 1);
			}
		}
		return null;
	}
	
	public static void test(){
		HashMap<String, Integer> hs = new HashMap<String, Integer>();
		
		hs.put("a", 1);
		hs.put("c", 1);
		hs.put("f", 1);
		hs.put("d", 1);
		hs.put("e", 1);
		hs.put("n", 1);
		hs.put("m", 1);
		hs.put("s", 1);
		hs.put("t", 1);

		for (Entry<String, Integer> entry : hs.entrySet()) {
			System.out.print(entry.getKey()+" ");
			System.out.println(entry.getValue());
		}
	}
	public static void main(String[] args) {
		test();
	}
}
