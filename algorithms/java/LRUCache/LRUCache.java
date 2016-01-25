package LRUCache;

//todo

import java.util.HashMap;

public class LRUCache {


	public static void main(String[] a) {

		LRUCache test = new LRUCache();
		test.run();
	}

	private void run() {
		int cache_size = 5;
		Cache cache = new Cache(cache_size);

		cache.setKeyValue(1, "1");
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(2, "2");
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(3, "3");
		System.out.println(cache.getCacheAsString());
		cache.getValue(1);
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(4, "4");
		System.out.println(cache.getCacheAsString());
		cache.getValue(2);
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(5, "5");
		System.out.println(cache.getCacheAsString());
		cache.getValue(5);
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(6, "6");
		System.out.println(cache.getCacheAsString());
		cache.getValue(1);
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(5, "5a");
		System.out.println(cache.getCacheAsString());
		cache.getValue(3);
		System.out.println(cache.getCacheAsString());
	}

	class Cache {

		public LinkedListNode listTail = null;
		private int maxCacheSize;
		private HashMap<Integer, LinkedListNode> map = new HashMap<>();
		private LinkedListNode listHead = null;


		public Cache(int maxSize) {
			maxCacheSize = maxSize;
		}

		/* Get value for key and mark as most recently used. */
		public String getValue(int key) {
			LinkedListNode item = map.get(key);
			if (item == null) {
				return null;
			}

		/* Move to front of list to mark as most recently used. */
			if (item != listHead) {
				removeFromLinkedList(item);
				insertAtFrontOfLinkedList(item);
			}
			return item.value;
		}

		/* Remove node from linked list. */
		private void removeFromLinkedList(LinkedListNode node) {
			if (node == null) {
				return;
			}
			if (node.prev != null) {
				node.prev.next = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			}
			if (node == listTail) {
				listTail = node.prev;
			}
			if (node == listHead) {
				listHead = node.next;
			}
		}

		/* Insert node at front of linked list. */
		private void insertAtFrontOfLinkedList(LinkedListNode node) {
			if (listHead == null) {
	        /* init doubly linked list */
				listHead = node;
				listTail = node;
			} else {
            /* update doubly linked list */
				listHead.prev = node;
				node.next = listHead;
				listHead = node;
			}
		}

		/* Remove key, value pair from cache, deleting from hash table
		 * and linked list. */
		public boolean removeKey(int key) {
			LinkedListNode node = map.get(key);
			removeFromLinkedList(node);
			map.remove(key);
			return true;
		}

		/* Put key, value pair in cache. Removes old value for key if
		 * necessary. Inserts pair into linked list and hash table.*/
		public void setKeyValue(int key, String value) {
        /* Remove if already there. */
			removeKey(key);

		/* If full, remove least recently used item from cache, so we can make room*/
			if (map.size() >= maxCacheSize && listTail != null) {
				removeKey(listTail.key);
			}

		/* Insert new node. */
			LinkedListNode node = new LinkedListNode(key, value);
			insertAtFrontOfLinkedList(node);
			map.put(key, node);
		}

		/*iterate through linked list printing it*/
		public String getCacheAsString() {
			if (listHead == null) return "";
			return listHead.printForward();
		}

		private class LinkedListNode {
			public int key;
			public String value;
			private LinkedListNode next;
			private LinkedListNode prev;

			public LinkedListNode(int k, String v) {
				key = k;
				value = v;
			}

			public String printForward() {
				String data = "(" + key + "," + value + ")";
				if (next != null) {
					return data + "->" + next.printForward();
				} else {
					return data;
				}
			}

			public String toString() {
				return value;
			}
		}
	}
}
