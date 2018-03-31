package com.wxw.xiaolv;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这五张牌是不是连续的。A为1，J为11，大小王可以是任意数字，（如果非0数字重复出现，就不是连续的）
 * 
 * 步骤：
 * 把数组排序，
 * 统计0的个数
 * 最后统计排序之后数组中相邻数字之间的空缺总数
 * 如果空缺总数小于或者等于0的个数，就是连续，否则就是不连续的
 * 
 * @author 王馨苇
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
		//统计0的个数
		int i;
		for (i = 0; i < number.length && number[i] == 0; i++) {
			numberOfZero++;
		}
		
		//统计间隔的数目
		int small = i;
		int big = small + 1;
		
		while(big < number.length){
			
			if(number[small] == number[big]){//连续两个重复
				return false;
			}
			
			numberOfGap += number[big] - number[small] - 1;
			small = big;
			big++;
		}
		return numberOfGap > numberOfZero ? false : true;
	}
}
