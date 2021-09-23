import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileSearcher {

	public static BinarySearchTree<Word> tree = new BinarySearchTree<Word>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//scanning the directory to go through all the files in the directory
		File directory = new File(args[0]);
		scanFiles(directory);
		
		Scanner scan = new Scanner(System.in);
		String choice = "x";
		
		while (!choice.equals("q")) {
		
			System.out.println("Please enter a command (a, s, or q)>> ");
			choice = scan.nextLine();
			
			//prints tree
			if (choice.equals("a")) {
				 tree.printTree();
			}
			
			/*
			 * user asks for a word
			 * if word is in the tree, it will print the filelist
			 */
			
			else if (choice.equals("s")) {
				System.out.println("Word to find>> ");
				String text = scan.nextLine();
				
				Word word = new Word(text);
				
				if (tree.contains(word) == true) {
					
					//finding the word in the tree
					word = tree.find(word);
					//printing the fileList of the word
					System.out.println(word);
				}
				
				else {
					System.out.println(word.getWord() + " is not found"); //change to fit the text!!!!
				}
			}
		}
		
		System.out.println("Goodbye!");
	}
	
	//readFile(File) used to read each file
	public static void scanFiles(File folder) throws IOException {
		
		//get all files/subfiles in folder
		File[] list = folder.listFiles();
		
		//for each file in list
		for (int i = 0; i < list.length; i ++) {
			
			//pulling file from list of files
			File file = list[i];
			
			if(!file.isHidden()&& file.getName().charAt(0)!= '.'){
				
				//if the file is a directory, recursively calls scanFiles
				if (file.isDirectory() == true) {
					
					scanFiles(file);
					
				}
				
				//is text file
				else {					
					readfile(file);
				}	
			}
		}	
	}
	
	//readfile reads the file and separates words
	public static void readfile(File file) throws IOException {
		
		Scanner fr = new Scanner(file);
		
		while(fr.hasNext()) {
			
			//creating a word after each space
			String str = fr.next();
			
			//looking for any non-word/letter characters and replacing with a blank
			str = str.replaceAll("\\W", "");
			
			updateTree(str,file.getName());

		}
	}
	
	//update the tree and create word objects
	public static void updateTree(String str, String file) {

		//new word object
		Word word = new Word(str);

		//search tree - if word is in tree, add file to word object
		if (tree.contains(word)) {
			
			word = tree.find(word);
			word.add(file);
		}
		
		//else - word is not in tree, add word object to tree and its file to the word
		else {
			
			tree.insert(word);
			word.add(file);
		}		
	}
}
