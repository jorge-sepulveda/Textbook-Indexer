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
		//System.out.println("c-structor called with word: " + wordText + " and line num: " + lineNumbers.peek());
		count = 1;
	}

	public void countWord(int lineNumber){
		lineNumbers.add(lineNumber);
		count+=1;
		System.out.println("added ln and to the count");
	}

	public String getWord(){
		return wordText;
	}

	public int compareTo(Word w){
		return (this.getWord()).compareTo(w.getWord());
	}

	public boolean equals(Word w){
		return this.getWord().equals(w.getWord());
	}

	public String toString(){
		return getWord();
	}
}