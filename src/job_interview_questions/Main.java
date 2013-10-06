public class Main {
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(3);

		lru.insert(1, "Item 1");
		lru.insert(2, "item 2");
		lru.insert(3, "item 3");
		lru.get(1);
		lru.get(2);
		lru.insert(4, "item 4");
		lru.insert(3, "new item 3");


		lru.printCache();
		lru.printLeastAccessedQueue();
	}
}
