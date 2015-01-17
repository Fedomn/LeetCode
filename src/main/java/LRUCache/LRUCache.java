package LRUCache;
/**
 * 	Design and implement a data structure for Least Recently Used (LRU) cache.
 *  It should support the following operations: get and set.
 *	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *	set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 *	it should invalidate the least recently used item before inserting a new item.
 * 
 */
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class LRUCache extends LinkedHashMap<Integer, Integer> implements Cache{
	  private int capacity;
	
	  public LRUCache(int capacity) {
	    super(16, 0.75f, true);
	    this.capacity = capacity;
	  }
	  
	  //重写父类get，为null时范围-1
	  public int get(int key) {
	    Integer v = super.get(key);
	    if (v != null)
	      return v;
	    else
	      return -1;
	  }
	  
	  //重写父类方法，当超过缓存容量时，就删除最老的
	  public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
	    return size() > capacity;
	  }
	
	  public void set(int key, int value) {
	    super.put(key, value);
	  }
}