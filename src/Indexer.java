import java.util.*;
import java.lang.*;
import java.io.*;

public class Indexer
{
	private String datafile;
	private String filterfile;
	private BinarySearchTree<Word> filteredBST;
	private BinarySearchTree<Word> indexedBST;


	/**
	*Indexer constructor takes in the file names from args and calls all the functions
	*needed to construct the BST's
	*/

	public Indexer(String filterName, String dataFile){
		try{
			datafile = dataFile;
			filterfile = filterName;

			if (fileExists()){
				//System.out.println("both files exists!");
			}
			else{
				throw new Exception("Could not find file");
			}

			DoIndex();

		}catch( Exception e){
			e.printStackTrace();
		}
		return;
	}
	 /**
	 *Do Index ties up the Indexer constructor by calling the FileReaders and
	 *calling the output functions
	 *
	 */
	private void DoIndex(){
		try{
			filteredBST = new BinarySearchTree<Word>();
			indexedBST = new BinarySearchTree<Word>();
			FileFilterReader();
			FileWordReader();
			OutputResults();
		}catch( Exception e){
			e.printStackTrace();
		}
		return;

	}
	/**
     * Checks if the file exists in the directory.
     * @return true if both files exists.
     */
	private boolean fileExists(){
		return (new File(datafile).exists() && new File(filterfile).exists());
	}

	/**
	 * FileFilterReader reads the stop words file by reading the file line by line
	 * and it inserts each word into the filteredBST.since the stop words file is
	 * clean, I didn't do any Regex filtering, I just lowercased each word that goes in.
	 */
	private void FileFilterReader() throws IOException{
		BufferedReader lineReader;
		System.out.println("file filter reader");
		lineReader = new BufferedReader(new FileReader(filterfile));

		String line;
		while (true){
			line = lineReader.readLine();

			if (line == null){
				lineReader.close();
				return;
			}
			line = line.toLowerCase();
			Word w = new Word(line, 0);
			filteredBST.insert(w);
		}
	}

	/**
	 * FileWordReader reads the input file by reading the file line by line
	 * and it inserts each word into the indexedBST. These files have a lot more of
	 * unnecessary characters there is some Regex checking and cleaning and a lot of it.
	 */
	private void FileWordReader() throws IOException{
		BufferedReader lineReaderWord;
		System.out.println("file filter reader");
		lineReaderWord = new BufferedReader(new FileReader(datafile));

		String line;
		int currentLineNumber=1;
		while (true){
			line = lineReaderWord.readLine();

			if (line == null){
				lineReaderWord.close();
				return;
			}
			line = line.toLowerCase();
            line = line.replaceAll("[^a-zA-Z'-]", " ");
            line = line.replaceAll("(?<=\\s|^)'+(?=\\w)|(?<=\\w)'(?=\\s|$)|(?<=\\s|^)-(?=\\w)|(?<=\\w)-(?=\\s|$)|'-|$=|-'|-\\s|'\\s", "");//the regex expression to end all regex expressions

            String[] lineArr = line.split("\\s+");
            for (String l : lineArr) {
            	if (l.matches(".*[a-zA-Z]+.*")){
            		Word w = new Word(l, currentLineNumber);
	            	if (filteredBST.contains(w)){
	            		//System.out.println("stop word!");
	            		continue;
	            	}
	            	else{
	            		indexedBST.insert(w);
	            	}
            	}
            }
			//add line to a list and then iterate through it to add it.
			currentLineNumber+=1;
		}

	}



	/**
	 * OutputResults sets the output stream to the proper results file and prints
	 * each tree doing an inorder traversal. that way, we get a lexicographical
	 * order of the tree displayed in the output results.
	 */
	private void OutputResults() throws FileNotFoundException{
		System.out.println("Output stuff here.");
		PrintStream console = System.out;
		PrintStream out = new PrintStream(new FileOutputStream("filterResults.txt", false));
		System.setOut(out);
		filteredBST.printInOrder();
		System.setOut(console);
		out.close();

		System.out.println("Output index here.");
		PrintStream outIndex = new PrintStream(new FileOutputStream("input2output.txt", false));
		System.setOut(outIndex);
		indexedBST.printInOrder();
		System.setOut(console);
		out.close();
		//System.out.println("did a text file thing!");
		return;
	}
	//dfsfd
	/**
	*These two function call each respective trees print function.
	*/
	public void printFilteredTree(){
		filteredBST.printInOrder();
	}

	public void printIndexedTree(){
		indexedBST.printInOrder();
	}

}
