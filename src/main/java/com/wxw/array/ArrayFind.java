package com.wxw.array;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 解题思路：从右上角开始检查是否和target相等，如果等直接返回true，如果不等，大于target的时候，说明那一列都会大于target，去掉那一列
 *        如果小于target，那一行都小于target，直接去掉那一行
 * 1,2,8 ,9
 * 2,4,9 ,12
 * 4,7,10,13
 * 6,8,11,15
 * @author 王馨苇
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
