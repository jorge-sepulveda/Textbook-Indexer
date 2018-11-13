import java.util.*;
import java.io.*;

public class Indexer
{
	private String datafile;
	private String filterfile;
	private BinarySearchTree<Word> filteredBST;
	private BinarySearchTree<Word> indexedBST;

	public Indexer(String filterName, String dataFile){
		try{
			datafile = dataFile;
			filterfile = filterName;

			if (fileExists()){
				System.out.println("both files exists!");
			}
			else{
				System.out.println("incorrect file setting");
				return;
			}

			DoIndex();

		}catch( Exception e){
			e.printStackTrace();
		}
		return;
	}

	private void DoIndex(){
		try{
			filteredBST = new BinarySearchTree<Word>();
			indexedBST = new BinarySearchTree<Word>();
			FileFilterReader();
			OutputResults();
		}catch( Exception e){
			e.printStackTrace();
		}
		return;
		
		
		//System.out.println("in DoIndex");
		//run file word reader and filefilter reader and output results

	}
	/**
     * Checks if the file exists in the directory.
     * @return true if both files exists.
     */
	private boolean fileExists(){
		return (new File(datafile).exists() && new File(filterfile).exists());
	}

	private void FileWordReader(){
		System.out.println("file filter reader");
	}

	private void FileFilterReader() throws IOException{
		BufferedReader lineReader;
		System.out.println("file word reader");
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

	private void OutputResults() throws FileNotFoundException{
		System.out.println("Output stuff here.");
		PrintStream console = System.out; 
		PrintStream out = new PrintStream(new FileOutputStream("filterResults.txt", false));
		System.setOut(out);
		filteredBST.printInOrder();
		System.setOut(console);
		out.close();
		//System.out.println("did a text file thing!");
		return;
	}

	public void printFilteredTree(){
		filteredBST.printInOrder();
	}

}