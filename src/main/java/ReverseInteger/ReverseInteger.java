package ReverseInteger;
/**
 * Reverse digits of an integer.                              
 * Example1: x = 123, return 321  
 * Example2: x = -123, return -321
 *
 * 注意：逆序后超过Integer.MAX_VALUE时返回0
 */
public class ReverseInteger {
	
	public static void main(String[] args) {
		System.out.println(reverse(Integer.MAX_VALUE));
	}
	
	public static int reverse(int x) {
		long res = 0;
		while(x != 0 ){
			res = res * 10 + x % 10;
			x = x / 10;
		}
		if(Math.abs(res) > Integer.MAX_VALUE) return 0;
		return (int)res;
    }
}
