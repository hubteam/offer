package com.wxw.silu;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * @author 王馨苇
 *
 */
public class PrintMatrix {

	private static ArrayList<Integer> array = new ArrayList<Integer>();
	
	//不一定是方阵
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
	       
		if(matrix == null){
			return null;
		}
		
	    int start = 0;
	    while(start * 2 < (matrix.length-1) && start * 2 < (matrix.length-1)){
	    	print(matrix, matrix.length - 1, matrix[0].length - 1, start - 1);
	    	++start;
	    }
	    return array;
    }
	
	public static void print(int[][] matrix ,int row, int col, int start){
		int endx = col - start;
		int endy = row - start;
		
		//从左到右
		for (int i = start; i <= endx; i++) {
			array.add(matrix[start][i]);
		}
		if(start < endy){
			//从上到下
			for (int i = start + 1; i <= endy; i++) {
				array.add(matrix[i][endx]);
			}
		}
		if(start < endx){
			//从右向左
			for (int i = endx - 1; i >= start; i--) {
				array.add(matrix[endy][i]);
			}
		}
		
		if(start < endy - 1 && start < endx){
			//从下到上，记得i > start，不然会报错
			for (int i = endy - 1; i > start; i--) {
				array.add(matrix[i][start]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
