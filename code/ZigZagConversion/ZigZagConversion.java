package com.ZigZagConversion;
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * 思路：  根据指定字符串 按照Z字形排列，按行取出连接成新字符串
 *  例：
 *  *           *
 *  *       *   *
 *  *   *       *
 *  *           *
 *  常规 先遍历字符串s里的字符，计算下标插入对应的StringBuilder里 明显效率低 而且计算量多
 *  所以 思路要转换过来 ---> 顺序取出s里字符，由于行数给定，可以分步填String 在填的同时移动s的字符下标 实现了一次遍历
 */

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.print(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int nRows) {
        StringBuilder[] res = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) res[i] = new StringBuilder();        
        
        int site = 0;
        int length = s.length();
        while(site < length){
            for(int index = 0; index < nRows && site < length; index++)
                res[index].append(s.charAt(site++));
            for (int index = nRows-2; index >= 1 && site < length; index--) 
                res[index].append(s.charAt(site++));
        }
        
        for (int i = 1; i < nRows; i++) {
            res[0].append(res[i]);
        }
        return res[0].toString();
    }
}
