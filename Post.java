import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class Post implements PostInterface {

   private String author;
   private String text;
   private Instant timestamp;
   private int postID;
   private ArrayList <String> commentsList;


   public Post(int postID, String author, String text){
    this.postID = postID;
    this.author = author;
    this.text = text;
    this.timestamp = Instant.now();
    this.commentsList = new ArrayList<String>();

    try{
    
    DecimalFormat df = new DecimalFormat("00000");    
    PrintWriter writer = new PrintWriter(new File(getFilename())); 
    writer.println(df.format(postID) + " " + timestamp.toString() +  " " + author + " " + text);
    writer.close();
    } catch(FileNotFoundException e){
        System.out.println("Error: File not found");
    }
    } 

    public Post(int postID){
        this.postID = postID;
        this.commentsList = new ArrayList<>();

        try{
            Scanner scnr = new Scanner(new File(getFilename()));

            if(scnr.hasNextLine()){
                String[] firstLine = scnr.nextLine().split(" ", 4);
                this.postID = Integer.parseInt(firstLine[0]);
                this.timestamp = Instant.parse(firstLine[1]);
                this.author = firstLine[2];
                this.text = firstLine[3];
            }
            while(scnr.hasNextLine()){
                commentsList.add(scnr.nextLine());
            }
            scnr.close();

            } catch(FileNotFoundException e){
                System.out.println("Error: File not found");
            }
            }         
        
    
   @Override
   public void addComment(String author, String text){
    String timestampComment = Instant.now().toString();
    String commentComment = timestampComment + " " + author + " " + text;
    commentsList.add(commentComment);

    try{
        PrintWriter writer = new PrintWriter(new File(getFilename()));
        writer.println(toStringPostOnly());

        for(String com : commentsList){
            writer.println(com);
        }
        writer.close();

        } catch(FileNotFoundException e){
            System.out.println("Error: File not found");
        }
    }

   @Override
   public String getFilename(){
    DecimalFormat df = new DecimalFormat("00000");
    return "Post-" + df.format(postID) + ".txt";
   }

   @Override
   public String toStringPostOnly(){
    DecimalFormat df = new DecimalFormat("00000");
    return df.format(postID) + " " + timestamp.toString() + " " + author +  " " + text;
   }

   @Override
   public String toString(){
    StringBuilder sb = new StringBuilder("Post: \n" + toStringPostOnly());
    sb.append("\nComments: ");
    for (String coms : commentsList){
        sb.append("\n").append(coms);
    }
    return sb.toString();
   }

   @Override
   public int getPostID(){
    return postID;
   }

   @Override
   public String getText(){
    return text;
   }

   @Override
   public Instant getTimestamp(){
    return timestamp;
   }

   @Override
   public String getAuthor(){
    return author;
   }
}

