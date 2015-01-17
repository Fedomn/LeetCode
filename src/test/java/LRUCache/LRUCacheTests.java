package LRUCache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LRUCacheTests {

    private MyLRUCache myCache = new MyLRUCache(3);
    private LRUCache cache = new LRUCache(3);



    private void commonTest(Object obj){
        Cache cache = (Cache)obj;
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);
        assertEquals(4, cache.get(4));
        assertEquals(3, cache.get(3));
        assertEquals(2, cache.get(2));
        assertEquals(-1, cache.get(1));

        cache.set(5, 5);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
        assertEquals(3, cache.get(3));
        assertEquals(-1, cache.get(4));
        assertEquals(5, cache.get(5));
    }

    @Test
    public void LRUCacheTest(){
        commonTest(myCache);
    }

    @Test
    public void MyLRUCacheTest(){
        commonTest(cache);
    }
}
