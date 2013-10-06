public class ElementCache<T> implements Cacheable<T>{
	public int key;
	public T value;

	public ElementCache(int key, T value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int getKey() {
		return key;
	}

	@Override
	public T getValue() {
		return value;
	}
}
