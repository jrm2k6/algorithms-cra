package searchtrie;

import java.util.Iterator;

public class SearchTrieNode extends AbstractSearchTrieNode {
	public SearchTrieNode(String _value, int _depth) {
		super(_value, _depth);
	}

	@Override
	public void insert(String word) {
		if (value.equals(word)) {
			return;
		}

		if (hasChildren()) {
			AbstractSearchTrieNode node = findWord(word.substring(0, this.getDepth() + 1));
			if (node != null) {
				node.insert(word);
				return;
			}
		}
		SearchTrieNode child = new SearchTrieNode(value.toString() + word.substring(this.getDepth(), this.getDepth()+1), this.getDepth() + 1);
		children.add(child);
		child.insert(word);
	}

	public AbstractSearchTrieNode findWord(String s) {
		Iterator<AbstractSearchTrieNode> it = children.iterator();
		while(it.hasNext()) {
			AbstractSearchTrieNode current = it.next();
			if (current.value.equals(s)) {
				return current;
			}
		}
		return null;
	}

	public void print() {
		for (AbstractSearchTrieNode n : children) {
			System.out.println(n.value);
			n.print();
		}
	}

	@Override
	public void find(String word) {

	}

	@Override
	public void remove(String word) {

	}
}