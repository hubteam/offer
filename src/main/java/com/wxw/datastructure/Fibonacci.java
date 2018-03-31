package com.wxw.datastructure;

public class Fibonacci {

	/**
	 * �ݹ�������ص����⣺��ΪС���������кܶ��ظ����ظ��Ľڵ������N�����󣬼������󣬵ݹ鷽ʽ��ʱ�临�Ӷȣ�ָ�������ӡ�
	 * @param n
	 * @return
	 */
	public static int calRec(int n){
		if(n <= 0){
			return 0;
		}
		
		if(n == 1){
			return 1;
		}
		
		return calRec(n - 1) + calRec(n - 2);
	}
	
	/**
	 * ����ѭ������Ϊʵ�ã�ʱ�临�Ӷ���0(N)
	 * @param n
	 * @return
	 */
	public static int calLoop(int n){
		//����ǰ����
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else{
			int a = 0;
			int b = 1;
			int c = 0;
			for (int i = 2; i <= n; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			return c;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(calLoop(7));
	}
}
