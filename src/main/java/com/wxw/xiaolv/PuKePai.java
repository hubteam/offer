package com.wxw.xiaolv;

import java.util.Arrays;

/**
 * ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ������������ǲ��������ġ�AΪ1��JΪ11����С���������������֣��������0�����ظ����֣��Ͳ��������ģ�
 * 
 * ���裺
 * ����������
 * ͳ��0�ĸ���
 * ���ͳ������֮����������������֮��Ŀ�ȱ����
 * �����ȱ����С�ڻ��ߵ���0�ĸ���������������������ǲ�������
 * 
 * @author ��ܰέ
 *
 */
public class PuKePai {

	public boolean isContinuous(int[] number){
		if(number == null || number.length <= 0){
			return false;
		}
		Arrays.sort(number);
		
		int numberOfZero = 0;
		int numberOfGap = 0;
		//ͳ��0�ĸ���
		int i;
		for (i = 0; i < number.length && number[i] == 0; i++) {
			numberOfZero++;
		}
		
		//ͳ�Ƽ������Ŀ
		int small = i;
		int big = small + 1;
		
		while(big < number.length){
			
			if(number[small] == number[big]){//���������ظ�
				return false;
			}
			
			numberOfGap += number[big] - number[small] - 1;
			small = big;
			big++;
		}
		return numberOfGap > numberOfZero ? false : true;
	}
}
