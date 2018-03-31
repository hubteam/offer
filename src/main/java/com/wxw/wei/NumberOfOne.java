package com.wxw.wei;

/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * 
 * @author ��ܰέ
 *
 */
public class NumberOfOne {

	//һ��ⷨ������������ѭ���������ж�һ�������Ķ����������һλ�ǲ���1����������һλ����ʱԭ�����ڴ��ұ�����ĵڶ�λ���Ƶ����ұ��ˣ����ж��ǲ���1��ÿ���ƶ�һλ��ֱ��Ϊ0
	//���ͣ�����һλ�൱�ڳ��������ǲ����ó���2����Ϊ������Ч�ʸ�
	//    �ж��ǲ���һ������1�Ĳ���
	//���⣺����Ǹ������ͻ������ѭ��
	public static int numberOfOne1(int n){
		
		int count = 0;
		while(n != 0){
			if((n & 1) == 1){
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	
	//���������ѭ�������⣺��ÿ����������һλ��Ϊ1����1λ
	public static int numberOfOne2(int n){
		
		int count = 0;
		int flag = 1;
		while(n != flag){
			if((n & flag) == 1){
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	//�����ַ�����һ��������ȥ1���ں�ԭ���������������㣬����������ұߵ�1���0����ôһ�������Ķ������ж���1���Ϳ��Խ��ж��ٴ�����
	public static int numberOfOne3(int n){
		
		int count = 0;
		while(n != 0){
			n = (n - 1) & n;
			count++;
		}
		return count;
	}
}
