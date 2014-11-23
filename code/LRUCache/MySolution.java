package LRUCache;

import java.util.HashMap;
import java.util.Map.Entry;
/**
 * 自己定义一个双向链表 包含头尾结点(不含数据 只负责移动用)
 *	
 */
public class solution2 {
	class LRUCache {
		
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		DoubleLinkMap list;
		
		public LRUCache(int capacity) {
			list = new DoubleLinkMap(capacity, map);
		}

		public void set(int key, int value) {
			Node temp = map.get(key);
			if(temp == null){
				//insert 
				Node newNode = new Node(null, null, value, key);
				map.put(key, newNode);
				//add list
				list.add(newNode);
				
			}else{
				temp.value = value;
				//Move Node to head
				list.MoveNodeToHead(temp);
			}
		}
		
		public int get(int key) {
			Node temp = map.get(key);
			if(temp == null)
				return -1;
			else{
				//Move Node to head
				list.MoveNodeToHead(temp);
				return temp.value;
			}
		}
		
		class Node{
			Node prev;
			Node next;
			int value;
			int key;
			public Node(Node p,Node n,int v,int k) {
				prev = p;
				next = n;
				value = v;
				key = k;
			}
		}
		
		class DoubleLinkMap{
			HashMap<Integer, Node> map;
			
			Node head;
			Node tail;
			int capacity;
			int currentCap;

			public DoubleLinkMap(int c, HashMap<Integer, Node> m) {
				map = m;
				capacity = c;
				currentCap = 0;
				head = tail = new Node(null, null, -1, -1);
				head.next = tail;
				tail.prev = head;
			}
			
			public void add(Node node){
				if(currentCap < capacity){
					//insert
					head.next.prev = node;
					node.next = head.next;
					head.next = node;
					node.prev = head;
					
					currentCap++;
				}else{
					//remove and insert
					head.next.prev = node;
					node.next = head.next;
					head.next = node;
					node.prev = head;
					
					map.remove(tail.prev.key);
					tail.prev.prev.next = tail;
					tail.prev = tail.prev.prev;
				}
			}
			
			public void MoveNodeToHead(Node node){
				if(node == head.next)
					return;
				else if(node == tail.prev){
					tail.prev = node.prev;
					node.prev.next = tail;
				}
				else{
					node.prev.next = node.next;
					node.next.prev = node.prev;
				}
				head.next.prev = node;
				node.next = head.next;
				head.next = node;
				node.prev = head;
			}
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new solution2().new LRUCache(3);
		
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.set(5, 5);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
	}
	
	public static void printmap(LRUCache cache){
		System.out.println("HashMap:");
		for(Entry<Integer, LRUCache.Node> temp : cache.map.entrySet()){
			System.out.println("Key: "+temp.getKey()+" Value: Node_key: "+temp.getValue().key+" Node_value "+temp.getValue().value);
		}
	}

}
