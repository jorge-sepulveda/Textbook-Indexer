import java.util.*;

public class Indexer
{
	private String datafile;
	private String filterfile;
	private BinarySearchTree<Word> filteredBST = new BinarySearchTree<Word>();
	private BinarySearchTree<Word> indexedBST = new BinarySearchTree<Word>();
}