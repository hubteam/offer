package com.wxw.daima;

/**
 * һ�����������η�
 * 
 * @author ��ܰέ
 *
 */
public class Power {

	/**
	 * ��򵥵ķ���
	 * ȱ����û�п���ָ��С��1�����Σ�����Ϊ0������
	 * @param base
	 * @param exp
	 * @return
	 */
	public static double power(double base, int exp){
		double result = 1.0;
		for (int i = 0; i < exp; i++) {
			result *= base;
		}
		return result;
	}
	
	//���ǲ����ķ�Χ����Ϊ���������������ÿ���0-1֮���ָ��
	public static double power2(double base, int exp){
		//base=0����exp<0��ʱ��
		//ע�⣺double���͵���0���ж�
		if(equal(base, 0.0) && exp < 0){
			throw new IllegalArgumentException("�Ƿ�����");
		}
		//ָ��С��0�����
		double result = power(base, Math.abs(exp));
		if(exp < 0){
			result = 1.0 / result;
		}
		return result;
	}
	
	private static boolean equal(double a, double b){
		if((a - b > -0.0000001) && (a - b < 0.0000001)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ��Ч�ķ�����An = A(n/2)A(n/2)ż��
	 *         An = A((n-1)/2)A((n-1)/2)A ����
	 * @param base
	 * @param exp
	 * @return
	 */
	public static double power3(double base, int exp){
		if(equal(base, 0.0) && exp < 0){
			throw new IllegalArgumentException("�Ƿ�����");
		}
		if(exp == 1){
			return base;
		}
		if(exp == 0){
			return 1;
		}
		//�����ƴ������2
		double res = power2(base, exp >> 1);
		res *= res;
		if(exp % 2 == 1){
			res *= base;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(power3(1000000000,1000000000));
	}
}
