package com.wxw.daima;

/**
 * ��ӡ1������Nλ��
 * 
 * ע��㣺N�Ĵ�С��֪����������long���������
 * 
 * ����ȫ���У��ݹ飬�ȵ�һλ���ڶ�λ�͵�һλ��ͬ�ķ������������ݹ���ȥ
 * @author ��ܰέ
 *
 */
public class Print1ToMax {

	public static void printToMaxNdigit(int n){
		if(n <= 0){
			return;
		}else{
			int[] a = new int[n];
			printArray(a, 0);
		}
	}
	
	public static void printArray(int[] a, int n){
		for (int i = 0; i < 10; i++) {
			a[n] = i;
			if(n != a.length - 1){//�ݹ�Ĳ���
				printArray(a, n + 1);
			}else{
				boolean flag = false;
				//��һλΪ0��ʱ�����
				for (int j = 0; j < a.length; j++) {
					if(a[j] != 0){
						System.out.print(a[j]);
						flag = true;//�Ѿ��������
					}else{
						if(flag){//�ǾͿ���ֱ�������
							System.out.print(a[j]);
						}
					}
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		printToMaxNdigit(3);
	}
	
}
