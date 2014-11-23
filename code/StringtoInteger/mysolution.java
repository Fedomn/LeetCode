public class Solution {
    public int atoi(String str) {
        if(str == null) return 0;
		str = str.trim();
		boolean negtive = false;
		long res = 0;
		int length = str.length();
		
		if(length > 0 ){
			int index = 0;
			char firstchar = str.charAt(0);
			if(firstchar == '-') {
				negtive = true;
				index = 1;
			}
			else if(firstchar == '+'){
				negtive = false;
				index = 1;
			}
			else{
				negtive = false;
				index = 0;
			}
			while(index < length){
				char c = str.charAt(index++);
				if(c >= '0' && c <= '9'){
					res = res * 10 + (c - '0');
				}else{//包含非数字字符 直接退出
					return (int)(negtive ? -res : res);
				}
				if(negtive == false  && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
				if(negtive == true && res > 2147483648l) return Integer.MIN_VALUE;
			}
		}else{
			return 0;
		}
		return (int)(negtive ? -res : res);
    }
}