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

	@Override
	public AbstractSearchTrieNode find(String word) {
		if (word.equals(value)) {
			print();
			return this;
		} else {
			AbstractSearchTrieNode n = findValueMatching(word);
			if (n != null) {
				return n.find(word);
			} else {
				return null;
			}
		}
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

	public AbstractSearchTrieNode findValueMatching(String s) {
		for (AbstractSearchTrieNode n : children) {
			if (s.startsWith(n.value)) {
				return n;
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
	public void remove(String word) {

	}
}