package com.wxw.nengli;

/**
 * �ַ���������ת������
 * 
 * ȫ����ת��ǰ��K����ת��ʣ�µ�����ת
 * 
 * @author ��ܰέ
 *
 */
public class LeftReverse {

	public static String leftreverse(String str, int k){
		char[] c = str.toCharArray();
		reverse(c, 0, k - 1);
		reverse(c, k, c.length - 1);
		reverse(c, 0, c.length - 1);
		
		String res = "";
		for (int i = 0; i < c.length; i++) {
			res += c[i];
		}
		return res;
	}
	
	public static void reverse(char[] c, int left, int right){
		
		for (int i = left, j = right; i < j; i++, --j) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(leftreverse(str, 2));
	}
}
