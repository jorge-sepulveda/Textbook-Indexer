# Java Project

Here is a readme for the textbook indexer for CSCE 314.

In this readme you'll find the classes I implemented and instructions on how to run this project.

#### List of classes:
- Word - holds the word and linenumbers
- Indexer - does the bulkwork of the file reading and word processing
- Driver - main class.

## Word Class


### Word Functions
- Word(string word, int linenumber) - constructor that initializes the Word
- countWord(int linenumber) -  this is for handling duplicates. if the same word is used then if the linenumber is in the queue. If not, then it will add it to the queue.
- compareTo() - overrides the compareTo function to do a comparison based on the wordtext. returns an integer depending on the string comparison
- toString() - overrides the toString function to return the word, count and linenumbers formatted and padded with .'s. this function helps out with the output files.
- getWordtext() - returns the word text.

## Indexer Class

The indexer class is doing the majority of the work. it's in charge of putting the words into the BST's while reading and writing the proper I/O handling.

### Indexer Functions

- Indexer(str filtername, str filename) - constructor that takes in the files from the main function to process them.
- doIndex() -
- fileExists() - boolean that validates the files existing in the directory
- FileFilterReader() - creates the filteredBST with the stop words
- FileWordReader() -  creates the indexedBST with all the valid words in the text files
- OutputResults() - outputs both trees into their respective files.

## How to run it

We can easily run it two different ways.

#### Using ant

from the Project directory:
```sh
$ ant build
$ ant run -Dargs0=gsl.txt -Dargs1=input1.txt
```

OR
```sh
$ ant run -Dargs0=gsl.txt -Dargs1=input2.txt
```

#### Without ant
from the src folder:


note: may need to move input files to the src folder.
```sh
$ javac *.java
$ java Driver gsl.txt <input1.txt or input2.txt>
```
