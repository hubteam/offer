package com.wxw.str;

/**
 * String�������ǲ��ɸ��ĵ�
 * 
 * @author ��ܰέ
 *
 */
public class TestStringMethod {

	/**
	 * ��Ȼ��string���˴�дת���ͽضϲ���������string��������û�иı�
	 * 
	 * ��ͼ�ı�string���ı�֮���ֵ��ͨ������ֵ�õ�����������޸ģ�ÿһ���޸Ķ������һ����ʱ���󣬿���̫��Ӱ��Ч��
	 * 
	 * ����һ���µ����ַ�����ص�����stringbuilder,�ܹ������޸ĺ�Ľ��
	 */
	public static void test(){
		String str = "hello";
		str.toUpperCase();
		System.out.println(str);
		str.substring(0,2);
		System.out.println(str);
	}
	
	public static void valueOfReference(){
		String text = "hello";
		modify(text);
		System.out.println(text);
		
		String text1 = new String("hello");
		modify(text1);
		System.out.println(text1);
	}
	
	public static void modify(String str){
		str = "new";
	}
	
	public static void main(String[] args) {
		test();
		valueOfReference();
	}
}
