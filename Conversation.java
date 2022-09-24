import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

class Conversation {
  public static void main(String[] arguments) {
    System.out.println("How many rounds?"); //ask user for number of rounds

    Scanner input = new Scanner(System.in);  //creating scanner object
    int num_rounds = input.nextInt();

    String[] responses = {"Uhhuh...", "Tell me more!", "No way!", "Really?"};
    Random rand = new Random();

    String fix_loop = input.nextLine(); //calling this so it won't return an empty skip for first iteration within loop

    ArrayList transcript = new ArrayList<String>(); //creating array object to store transcript
    transcript.add("Hi there! What's on your mind?"); //adding first prompt to transcript

  for (int i = 0; i < (num_rounds) ; i++) {

    if (i==0){System.out.println("Hi there! What's on your mind?");}

    String user_response = input.nextLine(); //persons response
    transcript.add(user_response);

    if (i == num_rounds-1){continue;} //I want to skip the last reply for the last round

    String[] words1 = user_response.split(" "); //splitting input into list
    ArrayList words = new ArrayList<String>(); //creating array object of persons input

    for (int j=0; j < words1.length; j++){
      words.add(j, words1[j]); //saving list as array for better methods
    }

    //checking if persons input has any words to mirror
    for (int h=0; h < words1.length; h++){
      if (words1[h].equals("I") || words1[h].equals("i")){
        words.remove(h);
        words.add(h, "you");
        }
      if (words1[h].equals("me")){
        words.remove(h);
        words.add(h, "you");
        }
      if (words1[h].equals("I'm")){
        words.remove(h);
        words.add(h, "you're");
        }
  
      if (words1[h].equals("am")){
        words.remove(h);
        words.add(h, "are");
        }
      
      if (words1[h].equals("you") || words1[h].equals("You")){
        words.remove(h);
        words.add(h, "I");
        }
      
      if (words1[h].equals("my") || words1[h].equals("My") ){
        words.remove(h);
        words.add(h, "your"); 
        }

      if (words1[h].equals("your") || words1[h].equals("Your")){
        words.remove(h);
        words.add(h, "my");
        }
    }
    if (words.contains("you") || words.contains("are")|| words.contains("I")|| words.contains("your") || words.contains("my")){
      String the_reply = words.toString();
      the_reply = the_reply.concat("?");
      the_reply = the_reply.replace("[", "");
      the_reply = the_reply.replace("]", "");
      the_reply = the_reply.replace(",", ""); //removing brackets and comma from string list into string format
      
      //making the first letter uppercase
      String first_letter = the_reply.substring(0, 1);
      the_reply = the_reply.replaceFirst(first_letter, first_letter.toUpperCase());

      //printing to the console
      System.out.println(the_reply);
      transcript.add(the_reply);
    }
    else {String reply = responses[rand.nextInt(4)]; //if no words to mirror print a saved response
      System.out.println(reply);
      transcript.add(reply);
    }


}

System.out.println("Great! Seeyah!");
transcript.add("Great! Seeyah!"); //adding last reply to the transcript


// re structure trancript to print
System.out.print("\n" + "TRANSCRIPT:" + "\n");
for (int z = 0; z < (transcript.size()); z++){
  System.out.println(transcript.get(z));
}
System.out.println("\n");
  input.close();
}
}