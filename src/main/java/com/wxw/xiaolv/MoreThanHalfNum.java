package com.wxw.xiaolv;

/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 * 
 * ������������������ԣ���������һ�����ֳ��ִ�����������ĳ��ȵ�һ�룬����������������ô����֮��λ�������м������һ�������Ǹ����ִ����������鳤��һ������֣���λ����
 * @author ��ܰέ
 *
 */
public class MoreThanHalfNum {

	/**
	 * �ܿ��������㷨������ O(N)
	 * 
	 * ע��Ҫ���������������Ϸ���Ҳ���Ǽ��鷵�ص��Ǹ��������������Ƿ񳬹���һ��
	 * 
	 * @param array
	 * @return
	 */
	public static int MoreThanHalfNum_Solution(int[] array) {
		if(array == null || array.length <= 0){
			return 0;
		}
        int mid = array.length / 2;
        int i = partition(array, 0, array.length - 1);
        while(mid != i){
        	if(i < mid){
        		i = partition(array, i + 1, array.length - 1);
        	}else if(i > mid){
        		i = partition(array, 0, i - 1);
        	}
        }
        int result = array[mid];
        if(check(array, result)){
        	return array[mid];
        }else{
        	return 0;
        }
        
    }
	
	/**
	 * ��������������ص��ҳ���O(N)
	 * 
	 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬Ҳ����˵�����ֵĴ����������������ֳ��ֵĴ����ĺͻ�Ҫ�࣬
	 * �ڱ��������ʱ�򱣴�����ֵ��һ����������һ�����֣�һ���Ǵ���������������һ�����ֵ�ʱ�������һ�����ֺ�����֮ǰ�����������ͬ������+1������-1��
	 * �������Ϊ0��������Ҫ������һ�����֣��Ѵ�����Ϊ1��Ҫ�ҵ����ֿ϶������һ�ΰѴ�����Ϊ1��Ӧ������
	 * 
	 * @param array
	 * @return
	 */
	public static int fangfa2(int[] array){
		
		int result = array[0];
		int times = 1;
		for (int i = 1; i < array.length; i++) {
			System.out.println("times:"+times);
			//����Ϊ0��ʱ�򣬱�����һ������
			if(times == 0){
				result = array[i];
				times = 1;
			}else if(array[i] == result){
				times++;
			}else{
				times--;
			}
		}
		return result;
	}
	
	public static boolean check(int[] array, int key){
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == key){
				count++;
			}
		}
		if(count > array.length / 2){
			return true;
		}else{
			return false;
		}
	}
	
	public static int partition(int[] array, int left, int right){
		if(left < right){
			int i = left;
			int j = right;
			int temp = array[j];
			while(i < j){
				while(i < j && array[i] < temp){
					i++;
				}
				if(i < j){
					array[j] = array[i];
					j--;
				}
				while(i < j && array[j] > temp){
					j--;
				}
				if(i < j){
					array[i] = array[j];
					i++;
				}
			}
			array[j] = temp;
			return j;
		}
		return right;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalfNum_Solution(a));
		int[] b = {1,2,3,2,2,2,5,4,2};
		System.out.println(fangfa2(b));
	}
}
