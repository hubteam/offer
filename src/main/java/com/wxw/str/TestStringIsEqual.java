package com.wxw.str;

/**
 * ����string�Ƿ�Ⱥ��ڴ�ռ��Ƿ���ͬһ��
 * 
 * @author ��ܰέ
 *
 */
public class TestStringIsEqual {

	/**
	 * == �ж��ǲ�����ͬ��ַ�ռ�
	 * equal �ж��Ƿ����
	 */
	public static void test(){
		String str1 = "hello world";
		String str2 = "hello world";
		if(str1 == str2){
			System.out.println("same");
		}else{
			System.out.println("not same");
		}
		
		if(str1.equals(str2)){
			System.out.println("equal");
		}else{
			System.out.println("not equal");
		}
		
		String str3 = new String("hello world");
		String str4 = new String("hello world");
		if(str3 == str4){
			System.out.println("same");
		}else{
			System.out.println("not same");
		}
		
		if(str3.equals(str4)){
			System.out.println("equal");
		}else{
			System.out.println("not equal");
		}
	}
	
	public static void main(String[] args) {
		test();
	}
}
