import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LRUCache {
	private ArrayList<Integer> recentlyAccessedKeys;
	private HashMap<Integer, String> cache;
	private int size;

	public LRUCache(int _size) {
		recentlyAccessedKeys = new ArrayList<Integer>(size);
		cache = new HashMap<Integer, String>();
		size = _size;
	}

	public String get(int key) {
		if (recentlyAccessedKeys.contains(key)) {
			int index = recentlyAccessedKeys.indexOf(key);
			recentlyAccessedKeys.remove(index);
		}
		recentlyAccessedKeys.add(key);
		System.out.println("New least is "+ cache.get(recentlyAccessedKeys.get(0)));
		return cache.get(key);
	}

	public void insert(int key, String value) {
		System.out.println("Insert operation in cache of size " + size);

		if (cache.containsKey(key)) {
			cache.put(key, value);
			return;
		}

		if (recentlyAccessedKeys.size() >= size) {
			int leastUsedKey = recentlyAccessedKeys.get(0);
			recentlyAccessedKeys.remove(0);
			String objectToRemove = cache.get(leastUsedKey);
			cache.values().remove(objectToRemove);
			System.out.println("Cache full - object with value " + objectToRemove + " removed");
		}
		
		cache.put(key, value);
		recentlyAccessedKeys.add(key);
		System.out.println("Object \"" + value + "\" inserted");
	}

	public void printCache() {
		Iterator it = cache.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
		}
	}

	public void printLeastAccessedQueue() {
		Iterator<Integer> it = recentlyAccessedKeys.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
