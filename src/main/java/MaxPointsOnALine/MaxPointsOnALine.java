package MaxPointsOnALine;

import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 思路：每次取出一个点 和剩余的点求斜率 统计出斜率相同的数目 最后取最大值 
 */
public final class MaxPointsOnALine {
    public static int getMaxPoints(Point[] points) {
    	int maxEnd = 0;
    	if(points.length < 3) return points.length;
    	
    	for(int i = 0; i < points.length; i++){
    		
    		int sameNum = 0;
			HashMap<Double, Integer> map = new HashMap<Double,Integer>();
			
    		for(int j = 0; j< points.length; j++){
    			
    			if(i == j) continue;
    			
    			//相同点
    			if(points[i].x == points[j].x && points[i].y == points[j].y){
    				sameNum++;continue;
    			}
    			//这里先要转成double在除
    			Double slope = points[i].x == points[j].x ? Double.MAX_VALUE : (double)(points[i].y - points[j].y)/(points[i].x - points[j].x);
    			if(map.get(slope) == null) map.put(slope, 1);
    			else map.put(slope, map.get(slope)+1);
    		}
    		
    		if(map.size() == 0){//防止全为相同点 map为空
    			return sameNum+1;
    		}else{
    			for(Double m : map.keySet()){
        			if(map.get(m) + sameNum > maxEnd)
        				maxEnd = map.get(m)+sameNum;
        		}
    		}
    	}
    	return maxEnd+1;
    }
}