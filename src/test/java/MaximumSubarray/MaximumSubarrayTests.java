package MaximumSubarray;

import org.junit.Assert;
import org.junit.Test;

import static MaximumSubarray.MaximumSubarray.maxSubArray;

public class MaximumSubarrayTests {
    private int[] testData = {-2,1,-3,4,-1,2,1,-5,4};
    private int testResult = 6;

    @Test
    public void MaximumSubarrayTest(){
        Assert.assertEquals(testResult, maxSubArray(testData));
    }
}
