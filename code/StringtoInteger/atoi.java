package atoi;

/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, 
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 * 
 * ������Ҫ����Character3��������С�˴���
 * Character.isWhitespace(char ch) 	�ж�ch�Ƿ���Java whitespace character 
 * Character.isDigit(char ch) 		Determines if the specified character is a digit. 
 * Character.getNumericValue 		Returns the int value that the specified Unicode character represents
 */
public class BestResult {
	public static void main(String[] args) {
		System.out.println(atoi(""));
	}
	
	private static final int maxDiv10 = Integer.MAX_VALUE / 10;
	
	public static int atoi(String str) {
		   int n = str.length();
		   int i = 0;
		   while (i < n && Character.isWhitespace(str.charAt(i))) i++;//�ҳ���һ����Ч�ַ�λ��
		   int sign = 1;
		   if (i < n && str.charAt(i) == '+') {
		      i++;
		   } else if (i < n && str.charAt(i) == '-') {
		      sign = -1;
		      i++;
		   }
		   int num = 0;
		   while (i < n && Character.isDigit(str.charAt(i))) {//��������ֱ�ӷ��ؽ��
		      int digit = Character.getNumericValue(str.charAt(i));//�����ַ���Ӧ����ֵ
		      if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {//�ж��Ƿ�������ֵ(����Integer.MIN_VALUE���һλ8)
		         return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		      }
		      num = num * 10 + digit;
		      i++;
		   }  
		   return sign * num;
		}
}