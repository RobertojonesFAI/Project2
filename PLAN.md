# Part 1 : To be done before you start your project

## Program Overview

1. In your own words, explain the purpose of this program in at most
   three sentences.  (What does it do? What input will it need? What
   output does it produce?)

   The purpose of this program is to create a social media platform, text-based only no graphics, called Textbook, where users can add, delete and comment on posts. It will use file storage to maintain posts and comments, so the files can be recoverable in future sessions. The program will take user input to perform operatations on posts and display the output.


2. List each source file in the project and explain its purpose.  You
   don't have to use complete sentences.

   PostInterface.java = Defines the required methods for the post class.

   TextBookInterface.java = specifies the interface for the textBook class, it will use methods.

   PostUnitTester.java = it will test that all methods works correctly.

   TextBookUnitTester.java = It will validate the funcionality of the methods in the TextBook class

   Post.java = Represents a single post with attribuite like author, timespan, comment and it handles creation, file writing, comment managment and implementing PostInteface.

   TextBook.java = Collection of Post object, lets users to add, delete and read posts. This will handle the files recovery of posts.

   TextBookDriver.java = This will have the main method that runs the entire program, using a console menu for user interaction. It will use the user input, call methods and deliver outputs. 



# Program Requirements

In your own words, identify the programming concepts/skills from
current and prior modules that must be applied to achieve this
project's requirements.

Files recovery = Write and read files .

Encapsulation = restrict direct access to class members.

Getters and Setters = Control access to private data/lines.

ArrayList = Manages files of posts and comments.

Interfaces = standarizing classes.

Exceptions = Handling errors

Aggregation = Interactions between multiple objects like posts and comments. 

String Tokenizing = Handles CSV and other structured text data




# Concept References

Identify the slides (module and slide numbers) that introduce and
demonstrate each of the following concepts:

* Encapsulation = Module 6, slide 28
* Instance Variables = Module 6, slide 30
* Getters/Setters = Module 6, slide 22
* ArrayLists = Module 5. slide 7
* Interfaces = Module 6, slide 86
* Reading files = Module 6
* Writing files = Module 6, slide 92 
* Writing vs. appending to files = Module 6, slide 93 
* Purpose of constructor = Module 6, slide 20.
* Exception handling = module 6, slide 51
* Aggregation = module 6, module 107
* Tokenizing Strings/Handling CSV data = module 5, slide 57

 




# Activity Connections

This project requires writing different classes for specific jobs in
the project and getting them all to interact correctly.  You will also
need to frequently read and write files.

Reflecting on the Task activity and ToDoList activities, answer the following questions:

* Why did you need getters and setters in your classes?  What access
  modifier should be used for instance variables?  What access
  modifier should be used for methods that other classes need to call?

Getters and Setters are essential for accesing private lines. Private are for instance variable and public are for accesing modifiers for methods that need to be accesible by other classes. 


* What is the relationship between Task and ToDoList (using the class
  relationships defined in part 5 of module 6 slides)?

ToDoList class aggregates Task objects, following one to many relationship

* How did you find specific Tasks in the ToDoList?  How can you find
  specific Posts in the Textbook?

Loops or filters with in ToDoList can locate specific tasks, Similarly, a TextBook can use these techniques to search for posts ID's.

* How were Interfaces used in the activities?  What is the purpose of
  the Interfaces provided in this project?

Provides structure for objects, allows that Post and TextBook follow specified functions.

* In ToDoList, one constructor took a File object. How is this
  constructor similar to the TextBook constructor?  How can the file
  be used to populate the Textbook (think how it was used to populate
  the ToDoList)?

  Similar to ToDoList, the constructor reads file to initialize data, allowing TextBook to recover post data. 



# Testing Plan

How will you test this program during development to ensure it meets
all requirements? How will you know your program has met all
requirements?

PostUnitTester and TextBookUnitTester are validate individual classes

resgularly test TextBookDriver to verify overall interaction and data integrity.

Inspect the contents of files for correct data formatting and structure.

# Compile and Run Instructions

From the directory containing all source code (.java) files, what is the command-line command that compiles the program?

//javac *.java

From the directory containing the compiled class (.class) files, what is the command-line command that runs the program?

//java textBookDriver

Provide any additional instructions the user needs beyond the run command to run the program.

none



# Part 2: To be done after your program is done

## Sources

List all outside sources you used to help you on this project.  You do
not need to list slides, the book, or other class assignments.



## Reflection

1. Discuss one bug you encountered while programming.  How did you
   find the bug?  What process did you use to fix the bug?  What did
   you learn from this bug that might help you in the future?



2. What, if anything, are you going to do differently on the next
   assignment?  (Consider things like: What other sources did you
   need?  Did you spend too much time debugging that could have been
   avoided by planning? How early/late did you start the project too
   late? How often did you go to the Kount Learning Center to get
   help? What processes did you use that were useful that you intend
   to use in the future?)
