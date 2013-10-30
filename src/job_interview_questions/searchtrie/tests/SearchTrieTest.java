package searchtrie.tests;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import searchtrie.RootSearchTrieNode;
import searchtrie.SearchTrieNode;

public class SearchTrieTest {
	public RootSearchTrieNode trie;

	@Before
	public void setUp() {
		trie = new RootSearchTrieNode();
	}

	@Test
	public void testAddWordToGroup() {
		trie.insert("alphabet");
		Assert.assertEquals(true, trie.hasChildren());
		Assert.assertEquals(1, trie.getNumChildren());
	}

	@Test
	public void testFindChar() {
		SearchTrieNode node1 = new SearchTrieNode("blow");
		SearchTrieNode node2 = new SearchTrieNode("pipe");
		SearchTrieNode node3 = new SearchTrieNode("love");
		SearchTrieNode node4 = new SearchTrieNode("database");
		trie.addToChildren(node1);
		trie.addToChildren(node2);
		trie.addToChildren(node3);
		trie.addToChildren(node4);
		Assert.assertEquals(trie.findChar('b'), node1);
		Assert.assertEquals(trie.findChar('p'), node2);
		Assert.assertEquals(trie.findChar('l'), node3);
		Assert.assertEquals(trie.findChar('d'), node4);
		Assert.assertEquals(trie.findChar('a'), null);
	}
}
