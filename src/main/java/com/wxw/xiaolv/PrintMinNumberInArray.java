package com.wxw.xiaolv;

import java.util.Arrays;
import java.util.Comparator;

/**
 * �������ų���С����
 * 
 * ע�⣺����������Ԫ��ƴ�ӳ�һ�������᲻�����������������ַ���
 * 
 * @author ��ܰέ
 *
 */
public class PrintMinNumberInArray {

	/**
	 * 
	 * @param numbers
	 * @return
	 */
    public static String PrintMinNumber(int [] numbers) {

    	if(numbers == null || numbers.length <= 0){
    		return "";
    	}else{
    		String res = "";
    		String[] str = new String[numbers.length];
    		for (int i = 0; i < str.length; i++) {
				str[i] = numbers[i]+"";
			}
    		Arrays.sort(str, new Comparator<String>() {

				@Override
				public int compare(String a, String b) {
					String left = a + b;
			    	String right = b + a;
			    	for (int i = 0; i < left.length();i++) {
						if(left.charAt(i) < right.charAt(i)){
							return -1;
						}else if(left.charAt(i) > right.charAt(i)){
							return 1;
						}
					}
			    	return 0;
				}
			});
    		for (int i = 0; i < str.length; i++) {
				res += str[i];
			}
    		return res;
    	}
    }
    
    public static void main(String[] args) {
		int[] a = {3,32,321};
		System.out.println(PrintMinNumber(a));
	}
}
