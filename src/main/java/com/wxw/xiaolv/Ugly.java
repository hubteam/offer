package com.wxw.xiaolv;

/**
 * ������ֻ��������2��3��5������Ϊ����
 * Ҳ����˵һ�����ܱ�2���������ǰ�����������2������ܱ�3����������������3������ܱ�5����������������5��������õ�1����������ǳ���
 * 
 * @author ��ܰέ
 *
 */
public class Ugly {

	public boolean isUgly(int number){
		while(number % 2 == 0)
			number /= 2;
		while(number % 3 == 0)
			number /= 3;
		while(number % 5 == 0)
			number /= 5;
		return (number == 1)? true : false;
	}
	//��һ�ַ���������ж�ÿ��Ԫ�ء�Ч�ʱȽϵͣ���Ϊ���ǳ���ҲҪȥ�жϡ�
	//�ڶ��ַ�����
	//���ݳ����Ķ���ɵã�����Ӧ����һ����������2��3��5�Ľ�������ǿ��Դ������飬������������ź���ĳ���
	public static int getUglyNumber(int index){
		if(index <= 0){
			return 0;
		}
		
		int[] uglyNumber = new int[index];
		uglyNumber[0] = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		int next = 1;
		while(next < index){
			int min = min(uglyNumber[index2] * 2, uglyNumber[index3] * 3, uglyNumber[index5] * 5);
			uglyNumber[next] = min;
			
			while(uglyNumber[index2] * 2 <= uglyNumber[next]){
				index2++;
			}
			while(uglyNumber[index3] * 3 <= uglyNumber[next]){
				index3++;
			}
			while(uglyNumber[index5] * 5 <= uglyNumber[next]){
				index5++;
			}
			++next;
		}
		return uglyNumber[next-1];
	}
	
	public static int min(int a, int b, int c){
		if(a <= b && a <= c){
			return a;
		}else if(b <= a && b <= c){
			return b;
		}else{
			return c;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getUglyNumber(6));
	}
}
