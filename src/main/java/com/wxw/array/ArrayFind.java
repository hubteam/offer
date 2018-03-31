package com.wxw.array;

/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * 
 * ����˼·�������Ͻǿ�ʼ����Ƿ��target��ȣ������ֱ�ӷ���true��������ȣ�����target��ʱ��˵����һ�ж������target��ȥ����һ��
 *        ���С��target����һ�ж�С��target��ֱ��ȥ����һ��
 * 1,2,8 ,9
 * 2,4,9 ,12
 * 4,7,10,13
 * 6,8,11,15
 * @author ��ܰέ
 *
 */
public class ArrayFind {
	
	public static boolean find(int target, int[][] array){
		
		if(array != null){

			int row = 0;
			int col = array[0].length - 1;
			while(row < array.length && col >= 0){
				if(array[row][col] == target){
					return true;
				}else if(array[row][col] > target){
					col -= 1;
				}else if(array[row][col] < target){
					row += 1;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(find(5, array));
	}
}
