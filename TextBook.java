import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


@SuppressWarnings("unused")
public class TextBook implements TextBookInterface{

    private ArrayList <Post> postsList;
    private int lastID;
    
    public TextBook(){
        
        postsList = new ArrayList<>();
        lastID = 0;

        try {
            Scanner scnr = new Scanner(new File(POST_LIST_FILENAME));
            while (scnr.hasNextInt()){
                int postID = scnr.nextInt();
                postsList.add(new Post(postID));

                if (postID > lastID){
                    lastID = postID;
                }
            }
            scnr.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error: File not found");
        }

    }
 
@Override
public int getLastID(){
   return lastID;
}

@Override
public int getPostCount(){
    return postsList.size();
}

@Override
public String getPostString(int index){
    if(index >= 0 && index < postsList.size()){
        return postsList.get(index).toString();
    } else {
        throw new IndexOutOfBoundsException("Index not valid");
    }
}

@Override
public void addPost(String author, String text){
    lastID++;
    Post newPost = new Post(lastID, author, text); 
    postsList.add(newPost);
    
    try {
        PrintWriter writer = new PrintWriter(new File(POST_LIST_FILENAME));
        for(Post post : postsList){
            writer.println(post.getPostID());
        }
        writer.close();
    } catch(FileNotFoundException e){
        System.out.println("Error: File not found");
    }
}

@Override
public Post removePost(int index){
    if (index >= 0 && index < postsList.size()){
        Post postDeleted = postsList.remove(index);

        try{
            PrintWriter writer = new PrintWriter(new File(POST_LIST_FILENAME));
            for (Post post : postsList){
                writer.println(post.getPostID());
            }
            writer.close();
        } catch(FileNotFoundException e){
            System.out.println("Error: File not found");
        } 
        return postDeleted;

    } else{
        throw new IndexOutOfBoundsException("Index not valid");
    }
}

@Override
public void addComment(int postIndex, String author, String text){
       if(postIndex >= 0 && postIndex < postsList.size()){
        Post post = postsList.get(postIndex);
        post.addComment(author, text);
       } else {
        throw new IndexOutOfBoundsException("Post does not exist");
       }
}

@Override
public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("TextBook contains ").append(postsList.size()).append(" posts:\n");

    for(int i = 0; i < postsList.size(); i++){
        sb.append(i).append(" - ").append(postsList.get(i).toStringPostOnly()).append("\n");
    }
    return sb.toString();
}

@Override
public ArrayList<Post> getPosts(){
    return new ArrayList<>(postsList);     
}
}
