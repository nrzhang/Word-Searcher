
import java.io.File;
import java.util.ArrayList;

public class Word implements Comparable<Word>{

	private String text;
	private ArrayList<String> fileList;
	
	//constructor - initializing the values
	public Word(String text) {	
		
		this.text = text;
		this.fileList = new ArrayList<String>();
	}
	
	//setter word
	public void setWord(String text){
		
		this.text = text;
	}
	
	//getter word
	public String getWord() {
		
		return text;
	}
			
	
	//getter fileList
	public ArrayList<String> getfileList() {
		
		return this.fileList;
	}
	
	//add(String f) - adding String of file to fileList
	public void add(String f) {
		
		fileList.add(f);
		
	}
	
	//toString  - converting word object to string
	public String toString() {
		
		return "files containing " + this.text + ": " + String.join(" ", this.fileList);
		
	}
	
	//compareTo() - comparing text of one word object to another text of a word object
	public int compareTo(Word other) {
		
		int compareResult;
		compareResult = this.text.compareTo(other.text);
		
		return compareResult;
	}

}
