package com.wxw.xiaolv;

/**
 * ԲȦ�����ʣ�µ����֣�0��N-1��N�������ų�һ��ԲȦ��������0��ʼÿ�δ����ԲȦ��ɾ����M�����֣����ԲȦ��ʣ�µ����һ������
 * �����Լɪ������
 * @author ��ܰέ
 *
 */
public class DigitLeaveInCircle {

	public static int getLeave(int n, int m){
		
		int s = 0;
		for (int i = 2; i <= n; i++) {
			s = (s + m) % i;
			System.out.println(s);
		}
		return s;
	}
	
	public static void main(String[] args) {
		getLeave(6, 3);
	}
}
