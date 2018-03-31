package com.wxw.buchong;

/**
 * ������ʽƥ��
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
 *  �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 * @author ��ܰέ
 *
 */
public class RegexPiPei {

	/**
	 * ���õݹ�ķ�����
	 * 1����һλ��*
	 *  1.1 ƥ��ɹ���match(str+1,pattern)
	 *  1.2
	 * @param str
	 * @param pattern
	 * @return
	 */
	public boolean match(char[] str, char[] pattern){
		if(str == null || pattern == null){
			return false;
		}
		return false;
	}
	
	public boolean matchRegCore(char[] str, int i, int length1, char[] pattern, int j, int length2){
		if(i != length1 && j == length2){
			return false;
		}
		if(i == length1){//����ƥ�䵽ĩβ
			if(j == length2){
				return true;
			}else{
				return false;
			}
		}
		
		//���ģʽ������һ���ַ���*,
		//(1)ģʽ���ĵ�ǰ�ַ������������ַ�����ƥ�䣬�����������
		//1.ģʽ���ĵ�ǰ�ַ�ƥ�䵽0���ַ������������䣬ģʽ���ƶ������ַ�
		//2.ģʽ���ĵ�ǰ�ַ�ƥ�䵽1���ַ��������ƶ�һ��λ�ã�ģʽ���ƶ�����λ��
		//3.ģʽ��ƥ�䵽����ַ��������ƶ�һ��λ�ã�ģʽ���ƶ�����λ��
		//(2)�����һ���ַ�����*,����ַ�ƥ��
		//(3)ģʽ������һ���ַ���.�������һ���ַ�ƥ��
		if(j + 1 < length2 && pattern[j+1] == '*'){
			if(str[i] == pattern[j] || pattern[j] == '.'){
				return matchRegCore(str, i + 1, length1, pattern, j + 2, length2);
			}else{
				return matchRegCore(str, i, length1, pattern, j + 2, length2);
			}
		}
		
		if(i < length1 && (str[i] == pattern[j] || pattern[j] == '.')){
			return matchRegCore(str, i + 1, length1, pattern, j + 1, length2);
		}
		return false;
	}
}
