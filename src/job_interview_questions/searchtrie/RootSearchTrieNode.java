package searchtrie;

import java.util.Iterator;

public class RootSearchTrieNode extends AbstractSearchTrieNode {
	public RootSearchTrieNode() {
		super(null, 0);
	}


	@Override
	public void print() {
		for (AbstractSearchTrieNode n : children) {
			n.print();
		}
	}

	@Override
	public void insert(String word) {
		if (word.length() == 0) {
			return;
		}

		if (hasChildren()) {
			AbstractSearchTrieNode node = findChar(word.charAt(0));
			if (node != null) {
				node.insert(word);
				return;
			}
		}
		SearchTrieNode child = new SearchTrieNode(word.substring(0, 1), 1);
		children.add(child);
		child.insert(word);
	}

	public AbstractSearchTrieNode findChar(char c) {
		Iterator<AbstractSearchTrieNode> it = children.iterator();
		while(it.hasNext()) {
			AbstractSearchTrieNode current = it.next();
			if (current.value.charAt(0) == c) {
				return current;
			}
		}
		return null;
	}

	@Override
	public AbstractSearchTrieNode find(String word) {
		for (AbstractSearchTrieNode n : children) {
			if (n.value.charAt(0) == word.charAt(0)) {
				return n.find(word);
			}
		}
		return null;
	}

	public void addToChildren(SearchTrieNode node) {
		children.add(node);
	}
}
