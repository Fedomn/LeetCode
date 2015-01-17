package MaximumSubarray;
/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [?2,1,?3,4,?1,2,1,?5,4],
 * the contiguous subarray [4,?1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
	public static void main(String[] args) {
		int a[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.err.println(maxSubArray(a));
	}
	
	public static int maxSubArray(int[] A) {
		if(A == null) return -1;
		int max=A[0], maxSoFar=A[0];
		for(int i=1; i<A.length; i++){
			max = Math.max(max + A[i], A[i]);
			maxSoFar = Math.max(max, maxSoFar);
		}
		return maxSoFar;
    }
}