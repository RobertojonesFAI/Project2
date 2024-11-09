public class yourPostTester {

    private static final int TOTAL_TESTS = 5;
    private static int testsPassed = 0;
    private static int status = 0;

    public static void main(String[] args) {

        try {
        //Test 1: Create a new post
        Post post = new Post(1, "Alice", "This is a test post");
        if(post.getPostID() == 1 ){
            testsPassed++;
        }  else {
            System.out.println("Test 1 failed");
        }
        /*assert post.getAuthor().equals("Alice") : "Test 1 failed";
        assert post.getText().equals("This is a test post") : "Test 1 failed";
        testsPassed++;*/

        //Test 2: Add Comment to the post
        post.addComment("Roberto", "This is a comment");
        if(post.toString().contains("Roberto This is a comment")){
        testsPassed++;
        } else {
            System.out.println("Test 2 failed");
        }

        //Test 3: Post toString
        //String postString = post.toString();
        //if(postString.contains("Ramirez This is a test post"))
         //   if(postString.contains("Roberto This is a comment"))
        //testsPassed++;
          //  }
        //} else {
        //    System.out.println("Test 3 failed");
        //}
        

        //Test 4 toStringPostOnly
        String toStringPost = post.toStringPostOnly();
        if(toStringPost.contains("00001 2024-11-08T23:17:09.213696Z Alice This is a test post")){
        testsPassed++;
        } else {
            System.out.println("Test 4 faield");
        }
        
            
        //Test 5
        String filenme = post.getFilename();
        if(filenme.contains("00001")){
        testsPassed++;
        } else{
            System.out.println("Test 5 failed");
        }


    } catch(AssertionError e) {
        status = 1;
        System.out.println(e.getMessage());
    }
 
   
   System.out.println("Test passed: " + testsPassed + " of " + TOTAL_TESTS); 
   System.out.println(status); 

}
}
