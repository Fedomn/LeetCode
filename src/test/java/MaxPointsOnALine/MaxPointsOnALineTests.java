package MaxPointsOnALine;

import org.junit.Test;

import static MaxPointsOnALine.MaxPointsOnALine.getMaxPoints;
import static junit.framework.Assert.assertEquals;

public class MaxPointsOnALineTests {
    private static Point[] testData = {
        new Point(-1,-1),
        new Point(-5,-5),
        new Point(2,2),
        new Point(3,3)
    };

    @Test
    public void MaxPointsOnALineTest(){
        assertEquals(4, getMaxPoints(testData));
    }
}
