package searchtrie;

import java.util.Iterator;
import java.util.List;

public class RootSearchTrieNode extends AbstractSearchTrieNode {
	public RootSearchTrieNode() {
		super(null);
	}


	@Override
	public void insert(String word) {
		char[] chars = word.toCharArray();

		if (hasChildren()) {

		} else {

		}
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
	public void find(String word) {

	}

	@Override
	public void remove(String word) {

	}

	public void addToChildren(SearchTrieNode node) {
		children.add(node);
	}
}
