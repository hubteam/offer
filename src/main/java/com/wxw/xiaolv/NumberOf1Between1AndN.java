package com.wxw.xiaolv;

/**
 * ��1��N������1���ֵĴ���������һ������N�����1��N�����N�������е�ʮ���Ʊ�ʾ��1���ֵĴ�����
 * ����12����1��12��Щ�����а�����1��������1,10,11,12��   1һ��������5��
 * 
 * @author ��ܰέ
 *
 */
public class NumberOf1Between1AndN {

	/**
	 * ����1����ÿ��������10���ж������ǲ���1��
	 * ʱ�临�Ӷ���O(NlogN),��Ϊ����һ������N������logNλ
	 * @param n
	 * @return
	 */
	public static int fangfa1(int n){
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += numberof1(i);
		}
		return sum;
	}
	
	public static int numberof1(int n){
		int sum = 0;
		while(n != 0){
			if(n % 10 == 1){
				sum++;
			}
			n /= 10;
		}
		return sum;
	}
	
	/**
	 * O(logN)
	 * ����2�������ֹ������֣����ʱ��Ч��
	 * @param n
	 * @return
	 */
	public static int fangfa2(int n){
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)    
			ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
		return ones;
	}
	
	/**
	 * O(logN)
	 * @param n
	 * @return
	 */
	public static int fangfa3(int n){
		int count = 0;  
		int i = 1;  
		int current = 0,after = 0,before = 0;  
        while((n / i) != 0) {  
            current = (n / i) % 10; //��ǰλ����  
            before = n / (i * 10); //��λ����  
            after = n - (n / i) * i; //��λ����  
            if (current > 1)  
                count = count + (before + 1) * i;  
            else if (current == 0)  
                count = count + before * i;  
            else if(current == 1)  
                count = count + before * i + after + 1;  
            i = i * 10;  
        }  
        return count; 
	}
	
	public static void main(String[] args) {
		System.out.println(fangfa2(12));
	}
}
