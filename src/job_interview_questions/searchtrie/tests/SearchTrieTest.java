package searchtrie.tests;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import searchtrie.AbstractSearchTrieNode;
import searchtrie.RootSearchTrieNode;
import searchtrie.SearchTrieNode;

public class SearchTrieTest {
	public RootSearchTrieNode trie;

	@Before
	public void setUp() {
		trie = new RootSearchTrieNode();
	}

	public void createTestTrie() {
		trie.insert("col");
		trie.insert("column");
		trie.insert("dog");
		trie.insert("california");
		trie.insert("calife");
		trie.insert("crane");
		trie.insert("bridge");
		trie.insert("amateur");
		trie.insert("bride");
		trie.insert("amore");
		trie.insert("abort");
		trie.insert("sk");
		trie.insert("sqlite");
		trie.insert("skull");
	}

	@Test
	public void testAddEmptyWord() {
		trie.insert("");
		Assert.assertEquals(trie.getNumChildren(), 0);
	}
	@Test
	public void testAddWordToGroup() {
		trie.insert("col");

		AbstractSearchTrieNode current = trie;
		while (current.hasChildren()) {
			Assert.assertEquals(1, current.getNumChildren());
			current = current.getChildren().get(0);
		}
	}

	@Test
	public void testAddWordToExistingGroup() {
		trie.insert("col");
		trie.insert("can");

		Assert.assertEquals(trie.getNumChildren(), 1);
		Assert.assertEquals(trie.getChildren().get(0).getNumChildren(), 2);
	}

	@Test
	public void testExtendsWord() {
		trie.insert("col");
		trie.insert("column");

		Assert.assertEquals(trie.getNumChildren(), 1);
		Assert.assertEquals(trie.getChildren().get(0).getNumChildren(), 1);
	}

	@Test
	public void testExtendsWordBis() {
		trie.insert("col");
		trie.insert("column");
		trie.insert("dog");
		trie.insert("california");
		trie.insert("calife");
		trie.insert("crane");
		trie.insert("bridge");
		trie.insert("amateur");
		trie.insert("bride");
		trie.insert("amore");
		trie.insert("abort");
		trie.insert("sk");
		trie.insert("sqlite");
		trie.insert("skull");

		Assert.assertEquals(trie.getNumChildren(), 5);
		Assert.assertEquals(trie.getChildren().get(0).getNumChildren(), 3);
		Assert.assertEquals(trie.getChildren().get(1).getNumChildren(), 1);
		Assert.assertEquals(trie.getChildren().get(2).getNumChildren(), 1);
		Assert.assertEquals(trie.getChildren().get(3).getNumChildren(), 2);
	}

	@Test
	public void testFindMatchingWordsInTree() {
		createTestTrie();
		AbstractSearchTrieNode n = trie.find("californ");

		Assert.assertEquals(n.value, "californ");
		Assert.assertEquals(n.getNumChildren(), 1);
	}

	@Test
	public void testFindNoMatchingWordsInTree() {
		createTestTrie();
		//AbstractSearchTrieNode n = trie.find("Lol");
		trie.find("c");
		//Assert.assertEquals(n, null);
	}


	@Test
	public void testFindChar() {
		SearchTrieNode node1 = new SearchTrieNode("blow", 1);
		SearchTrieNode node2 = new SearchTrieNode("pipe", 1);
		SearchTrieNode node3 = new SearchTrieNode("love", 1);
		SearchTrieNode node4 = new SearchTrieNode("database", 1);
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
