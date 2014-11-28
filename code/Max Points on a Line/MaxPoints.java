package MaxPoints;

import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * ˼·��ÿ��ȡ��һ���� ��ʣ��ĵ���б�� ͳ�Ƴ�б����ͬ����Ŀ ���ȡ���ֵ 
 */
public class MaxPoints {

	public static void main(String[] args) {
		MaxPoints.Point p1 = new MaxPoints().new Point(-1,-1);
		MaxPoints.Point p2 = new MaxPoints().new Point(-5,-5);
		MaxPoints.Point p3 = new MaxPoints().new Point(2,2);
		MaxPoints.Point p4 = new MaxPoints().new Point(3,3);
		Point[] p ={p1,p2,p3,p4};
		int num = maxPoints(p);
		
		System.out.println(num);
		
	}
	
	class Point {
		 int x;
		 int y;
		 Point() { x = 0; y = 0; }
		 Point(int a, int b) { x = a; y = b; }
	}
	
	
	
    public static int maxPoints(Point[] points) {
    	int maxEnd = 0;
    	if(points.length < 3) return points.length;
    	
    	for(int i = 0; i < points.length; i++){
    		
    		int sameNum = 0;
			HashMap<Double, Integer> map = new HashMap<Double,Integer>();
			
    		for(int j = 0; j< points.length; j++){
    			
    			if(i == j) continue;
    			
    			//��ͬ��
    			if(points[i].x == points[j].x && points[i].y == points[j].y){
    				sameNum++;continue;
    			}
    			//������Ҫת��double�ڳ�
    			Double slope = points[i].x == points[j].x ? Double.MAX_VALUE : (double)(points[i].y - points[j].y)/(points[i].x - points[j].x);
    			if(map.get(slope) == null) map.put(slope, 1);
    			else map.put(slope, map.get(slope)+1);
    		}
    		
    		if(map.size() == 0){//��ֹȫΪ��ͬ�� mapΪ��
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