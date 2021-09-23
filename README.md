# Word-Searcher

scanFiles:
- The scan files method reads through all the files in the directory.
- It also identifies whether or not a file is in a directory.
- Calls readFiles method
- Essentially when scanFiles is called in the main method, it will create the whole tree from the directories

readFiles:
- Reads every word in the file and separates each word by a space. It then removes the punctuation from the word.
- calls updateTree method


updateTree:
- updateTree creates a word object for every word.
- The method then checks to see if the word object is in the tree.
- If the word object is in the tree, then it will append the file list of the word object in the tree
- If the word object is not in the tree, it will be added to the tree and the file that has the word will be added to fileList
