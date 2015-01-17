package ClimbingStairs;

import org.junit.Test;

import static ClimbingStairs.ClimbingStairs.climbStairs;
import static org.junit.Assert.assertEquals;

public class ClimbingStairsTests {

    @Test
    public void ClimbingStairsTest(){
        assertEquals(0, climbStairs(0));
        assertEquals(1, climbStairs(1));
        assertEquals(2, climbStairs(2));
        assertEquals(5, climbStairs(4));
    }
}
