package com.wxw.str;

import java.util.ArrayList;

/**
 * �ַ�����ȫ���У�����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 *            ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * 
 * ��������:��һ��λ�úͺ������е�λ�ý�����  ��һ��λ�ù̶���ʣ�µĲ����ظ���һ�εĲ�����
 * 
 * @author ��ܰέ
 *
 */
public class Permutation {

	/**
	 * �ݹ�
	 * @param str
	 * @return
	 */
	public static ArrayList<String> permutation(String str){
		if(str == null || str.length() <= 0){
			return null;
		}else{
			char[] c = str.toCharArray();
			ArrayList<String> arr = new ArrayList<String>();
			permutation(c, 0, arr);
			return arr;
		}
		
	}
	
	public static void permutation(char[] c, int begin, ArrayList<String> arr){
		if(c == null){
			return;
		}
		if(begin == c.length - 1){
			String s = "";
			for (int i = 0; i < c.length; i++) {
				s += c[i];
			}
			arr.add(s);
		}else{
			for (int i = begin; i < c.length; i++) {
				
				char temp = c[begin];
				c[begin] = c[i];
				c[i] = temp;
				
				permutation(c, begin + 1, arr);
				
				temp = c[begin];
				c[begin] = c[i];
				c[i] = temp;
			}
			
		}
	}
	
	public static void main(String[] args) {
		String str = "abc";
		permutation(str);
	}
}
