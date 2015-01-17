package PalindromeNumber;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	
	public static void main(String[] args) {
		PalindromeNumber.Algorithm a = new PalindromeNumber().new Algorithm();
		boolean is = a.isPalindrome(1);
		System.out.println(is);
	}
	
	class Algorithm{
		public boolean isPalindrome(int x) {
			if(x < 0 ) return false;
			int start=0;
			int end = getLength(x) - 1;
			
			while(start <= end){
				int a = (int)(x / Math.pow((double)10, (double)start++) %10);
				int b = (int)(x / Math.pow((double)10, (double)end--) % 10);
				if(a != b) 
					return false;
			}
			return true;
	    }
		
		public int getLength(int x){
			int i=1;
			while(x / 10 != 0){
				i++;
				x = x / 10;
			}
			return i;
		}
	}
}