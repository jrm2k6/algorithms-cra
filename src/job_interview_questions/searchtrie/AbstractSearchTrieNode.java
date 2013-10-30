package searchtrie;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSearchTrieNode {
	String value;
	List<AbstractSearchTrieNode> children;

	AbstractSearchTrieNode(String _value) {
		this.value = _value;
		this.children = new ArrayList<AbstractSearchTrieNode>();
	};

	abstract public void insert(String word);
	abstract public void find(String word);
	abstract public void remove(String word);

	public boolean hasChildren() { return children.size() > 0; }
	public int getNumChildren() { return children.size(); }
}

