package LRUCache;

import java.util.HashMap;
/**
 * 自己定义一个双向链表 包含头尾结点(不含数据 只负责移动用)
 */
public class MyLRUCache implements Cache{
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	DoubleLinkMap list;

	public MyLRUCache(int capacity) {
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
