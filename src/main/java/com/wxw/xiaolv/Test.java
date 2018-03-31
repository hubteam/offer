package com.wxw.xiaolv;

public class Test implements Comparable<Test>{

	private int a;

	public Test(int a){
		this.a = a;
	}
	public int compareTo(Test arg0) {
		return this.a < arg0.a?-1:(this.a == arg0.a?0:1);
	}
	@Override
	public String toString() {
		return "Test [a=" + a + "]";
	}
	
	
}
