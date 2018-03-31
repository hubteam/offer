package com.wxw.daima;

/**
 * ���ַ���ת��������
 * ���ǵ��������ֵ̫���������ֵ����ĸ���쳣���룻����ǰ���������
 * @author ��ܰέ
 *
 */
public class StrToInteger {

	public int strToInt(String str) throws Exception{
		if(str == null || str.length() == 0){
			return 0;
		}
		int result = 0;
		int begin = 0;
		boolean minus = false;
		char[] c = str.toCharArray();
		//���ǿ�ʼ������
		if(c[0] == '-'){
			begin++;
			minus = true;
		}else if(c[0] == '+'){
			begin++;
		}
		
		for (int i = c.length - 1, j = 0; i >= begin; i--, j++) {
			//�����쳣ֵ
			if(c[i] < 48 || c[i] > 57){
				throw new IllegalArgumentException("�����쳣");
			}else{
				int flag = minus ? -1 : 1;
				result += (c[i] - 48) * Math.pow(10, j) * flag;
				//�������
				if(result > 2147483647 || result < -2147483648){
					throw new Exception("Խ���쳣");
				}
			}
		}
		return result;
	}
}
