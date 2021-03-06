package searchtrie;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSearchTrieNode {
	public String value;
	public List<AbstractSearchTrieNode> children;
	public int depth;
	public Boolean isWord = false;

	AbstractSearchTrieNode(String _value, int _depth) {
		this.value = _value;
		this.children = new ArrayList<AbstractSearchTrieNode>();
		this.depth = _depth;
	}

	abstract public void print();
	abstract public void insert(String word);
	abstract public AbstractSearchTrieNode find(String word);

	public boolean hasChildren() { return children.size() > 0; }
	public int getNumChildren() { return children.size(); }
	public List<AbstractSearchTrieNode> getChildren() { return children; }
	public int getDepth() { return depth; }
}

