public interface Cacheable<T> {
	public int getKey();
	public T getValue();
}
