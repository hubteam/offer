package com.wxw.str;

/**
 * ���⣺��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * 
 * ˼·����1����ԭ�����ַ������滻��Ҫ��֤������ַ����������㹻����ڴ棺�����漰�ƶ���ʱ�临�Ӷȸߡ�
 *     ��2�������µ��ַ��������µ��ַ��������滻����ô���ǿ����Լ������㹻����ڴ�
 * @author ��ܰέ
 *
 */
public class ReplaceSpace {

	public static String replaceSpace(StringBuffer str){
		if(str == null || str.length() <= 0){
			return null;
		}else{
			//���Ե�һ��ɨ�裬��Ҫ������ٿռ�
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == ' '){
					sb.append("%20");
				}else{
					sb.append(str.charAt(i));
				}
			}
			return sb.toString();
		}
		
	}
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("we are happy.");
		System.out.println(replaceSpace(sb));
	}
}
