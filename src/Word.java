import java.util.*;

public class Word implements Comparable<Word>
{
	private int count;
	private Queue<Integer> lineNumbers = new LinkedList<>();
	private String wordText;

	Word(){
		//System.out.println("unparametized c-structor called");
	}
	Word(String inWord,int lineNumber){
		wordText = inWord;
		lineNumbers.add(lineNumber);
		count = 1;
	}

	/**countWord happens when a duplication occurs in the tree.
	* It will check if the lineNumber is already in the queue.
	* if so, it will just add 1 to the count
	* otherwise, it will add the linenumber to the queue and add 1 to the count.
	*/
	public void countWord(int lineNumber){
		//checks to see if we are on the same line. if it is, then just add to the count.
		if (lineNumbers.contains(lineNumber)){
			count += 1;
			return;
		}
		else{
			lineNumbers.add(lineNumber);
			count+=1;
			//System.out.println("added + and to the count");
			return;
		}
	}

	/** get lineNumber checks the linenumber
	*@return top of the lineNumbers queue.
	*/
	public int getLineNumber(){
		return lineNumbers.peek();
	}
	/**getWord just returns the Word's wordText variable
	*@return the word of the Word object
	*/
	public String getWord(){
		return wordText;
	}

	/**
	* compareTo uses the String compareTo of the words to help with the BST
	* @return an integer based on the result of the string comparison
	*/
	public int compareTo(Word w){
		return (this.getWord()).compareTo(w.getWord());
	}
	//overriding equals function
	public boolean equals(Word w){
		return this.getWord().equals(w.getWord());
	}

	/**
	*toString override to help with text file output
	*strips the [] and the ,
	@return word..........count:lineNumbers
	*/
	public String toString(){
		String returnedStr;
		if (getWord().length() > 19){
			returnedStr =  String.format("%-23s%d:", getWord(),count ).replace(' ', '.') + lineNumbers;
		}
		else{
			returnedStr =  String.format("%-19s%5d:", getWord(),count ).replace(' ', '.') + lineNumbers;
		}

		returnedStr = returnedStr.replace("[", " ");
		returnedStr = returnedStr.replace("]", "");
		returnedStr = returnedStr.replace(",", "");
		returnedStr = returnedStr.trim();
		return returnedStr;
	}
}
