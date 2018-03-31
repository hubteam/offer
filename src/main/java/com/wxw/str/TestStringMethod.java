package com.wxw.str;

/**
 * String的内容是不可更改的
 * 
 * @author 王馨苇
 *
 */
public class TestStringMethod {

	/**
	 * 虽然对string做了大写转换和截断操作，但是string本身内容没有改变
	 * 
	 * 试图改变string，改变之后的值会通过返回值得到，连续多次修改，每一次修改都会产生一个临时对象，开销太大影响效率
	 * 
	 * 定义一个新的与字符串相关的类型stringbuilder,能够容纳修改后的结果
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
