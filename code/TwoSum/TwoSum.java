package TwoSum;

import java.util.HashMap;

/** Question:
	Given an array of integers, find two numbers such that they add up to a specific target number.
	The function twoSum should return indices of the two numbers such that they add up to the target, 
	where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
	You may assume that each input would have exactly one solution.
	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
 *
 */
public class solution {
	public static void main(String[] args) {
		int[] res = new int[2];
		int[] num = {2, 7, 11, 15};
		res = twoSum(num,19);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
	
	
	
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if(map.containsKey(target-numbers[i])){
				return new int[]{map.get(target-numbers[i]) + 1, i + 1};
			}
			map.put(numbers[i],i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
