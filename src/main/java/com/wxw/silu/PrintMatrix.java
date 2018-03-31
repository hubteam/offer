package com.wxw.silu;

import java.util.ArrayList;

/**
 * ˳ʱ���ӡ����
 * @author ��ܰέ
 *
 */
public class PrintMatrix {

	private static ArrayList<Integer> array = new ArrayList<Integer>();
	
	//��һ���Ƿ���
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
		
		//������
		for (int i = start; i <= endx; i++) {
			array.add(matrix[start][i]);
		}
		if(start < endy){
			//���ϵ���
			for (int i = start + 1; i <= endy; i++) {
				array.add(matrix[i][endx]);
			}
		}
		if(start < endx){
			//��������
			for (int i = endx - 1; i >= start; i--) {
				array.add(matrix[endy][i]);
			}
		}
		
		if(start < endy - 1 && start < endx){
			//���µ��ϣ��ǵ�i > start����Ȼ�ᱨ��
			for (int i = endy - 1; i > start; i--) {
				array.add(matrix[i][start]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
