
import java.util.Scanner;

/*
 * TextBook social media class
 * @Author Roberto kJones
 */


public class TextBookDriver {
    /**
     * @param args
     */

    
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        TextBook textBook = new TextBook();

        
        System.out.print("Enter your name to enter the TextBook: ");
        String author = scnr.nextLine();
        System.out.println(author + " Welcome to TextBook, the best text-social media site ");
        boolean quit = false;
        displayerMenu();

        while(!quit){

            System.out.print("---------------------------------------\nSelect and option or M for menu: ");
            String userInput = scnr.nextLine().toLowerCase();

            switch (userInput){
                case "m":
                    displayerMenu();
                    break;
                
                case "p":
                    System.out.println(textBook.toString());
                    break;
                
                case "a":
                    System.out.print("Enter text for your new post: ");
                    String text = scnr.nextLine();
                    textBook.addPost(author, text); 
                    break;

                case "d":
                    try{
                    System.out.print("Enter index to delete: ");  
                    if (!scnr.hasNextInt()){
                        System.out.print("Error: Invalid input. Please enter a valid index: ");
                        scnr.nextLine();
                    }
                    int indexDelete = scnr.nextInt();
                    scnr.nextLine();
                    textBook.removePost(indexDelete);
                    if (true) {
                        System.out.println("Post deleted ");
                    } 
                    }catch(IndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "c":
                    try{
                    System.out.print("Enter index of the post on which to comment: ");
                    if (!scnr.hasNextInt()){
                        System.out.print("Error: Invalid input. Please enter a valid index: ");
                        scnr.nextLine();
                    }
                    int indexComment = scnr.nextInt(); 
                    scnr.nextLine();
                    System.out.print("Introduce comment: ");
                    String comment = scnr.nextLine();
                    textBook.addComment(indexComment, author, comment);
                    } catch(IndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case "r":
                    System.out.print("Enter the index of the post to read: ");
                    int indexRead = scnr.nextInt();
                    scnr.nextLine();
                    System.out.println(textBook.getPostString(indexRead));
                    break;
                
                case "q":
                    System.out.println("Goodbye " + author + "!");
                    quit = true;
                    scnr.close();
                    break;

                default:
                    System.out.println("Invalid option ");
                    break;
            } 
        }
        }
       
        private static void displayerMenu(){
        System.out.println("---------------------------------------");
        System.out.println("TextBook site menu");
        System.out.println("---------------------------------------");
        System.out.println("(P)rint TextBooks posts");
        System.out.println("(A)dd a new post");
        System.out.println("(D)elete a post");
        System.out.println("(C)omment on a post");
        System.out.println("(R)ead a post and its comments");
        System.out.println("(Q)uit");
        
        
    }
}