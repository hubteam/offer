package com.wxw.datastructure;

/**
 * ��Ҫ�ظ���μ�����ͬ�������ʱ��
 * 
 * �ݹ麯������࣬���ǵ�����ʱ��Ϳռ������
 *        ���ǵݹ�ı����ǰ�һ������ֽ���������߶�����⣬������С��������໥�ص�����ô�ʹ����໥����
 *        ����ջ���
 * @author ��ܰέ
 *
 */
public class DiguiAndXunhuan {

	public static int cal(int n){
		if(n == 0){
			return 0;
		}else{
			return n + cal(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(cal(5));
	}
	
}
