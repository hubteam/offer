package com.wxw.array;

/**
 * ��������˳��ʹ����λ��ż����ǰ�棺
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * @author ��ܰέ
 *
 */
public class ReorderOldEven {

	//����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿��
	public static void reorderOldEven(int[] array){
		if(array == null || array.length == 0){
			return;
		}
		
		int i = 0;
		int j = array.length - 1;
		
		while(i < j){
			while(i < j && array[i] % 2 != 0){
				i++;
			}
			while(i < j && array[j] % 2 == 0){
				j--;
			}
			if(i < j ){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
	}
	
	//��֤������������ż����ż��֮������λ�ò���
	public static void reorderOldEven2(int[] array){
		int i = 0;
		int j = 0;
		while(i < array.length && j < array.length){
			while(i < array.length && array[i] % 2 == 0){
				i++;
			}
			while(j < array.length && array[j] % 2 != 0){
				j++;
			}
			if( i > j){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
				int index = i;
				i = j;
				j = index;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		reorderOldEven(a);
		for (int i = 0; i < a.length; i++) {
			if(i == a.length - 1){
				System.out.print(a[i]);
			}else{
				System.out.print(a[i]+",");
			}
		}
		System.out.println();
		int b[] = {1,2,3,4,5};
		reorderOldEven2(b);
		for (int i = 0; i < b.length; i++) {
			if(i == b.length - 1){
				System.out.print(b[i]);
			}else{
				System.out.print(b[i]+",");
			}
		}
	}
}
