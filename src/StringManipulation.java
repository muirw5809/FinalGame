
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class StringManipulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word =in.nextLine();
        String unchanged = word;
        // to sound like Elmer fudd
        //we change l and r to w's
        word = word.replaceAll("r", "w");
        word = word.replaceAll("R", "W");
        // First letter word.replaceFirst(word, word) All letters word.replaceAll(word, word)
        word = word.replaceAll("l", "w");
        word = word.replaceAll("L", "W");
        
        String robberWord = "";
        for(int i = 0; i <unchanged.length(); i++)
        {
            if(unchanged.charAt(i) == 'a'){
                robberWord = robberWord + 'a';
            }else if(unchanged.charAt(i) == 'e'){
                robberWord = robberWord + 'e';
            }else if(unchanged.charAt(i) == 'i'){
                robberWord = robberWord + 'i';
            }else if(unchanged.charAt(i) == 'o'){
                robberWord = robberWord + 'o';
            }else if(unchanged.charAt(i) == 'u'){
                robberWord = robberWord + 'u';
            }else if(unchanged.charAt(i) == 'y'){
                robberWord = robberWord + 'y';
            }else //handle nonevowels
            {
                char letter = unchanged.charAt(i);
                robberWord = robberWord + letter + "o" + letter;
            }
        }
        
        // Lamont's Language
        // break off anything before the L, and place
        // it at the beginning of the word
        //if the word has no l
        //add La to the beginning
        String lamont = "";
        
        //start withs l, dont touch it
        if(unchanged.startsWith("l"))
        {
            lamont =unchanged;
        }else if(!unchanged.contains("l"))
        {
            lamont = "la" + unchanged;
        }
        else
        {
            // find an l
            int place = unchanged.indexOf("l");
            String after = unchanged.substring(place);
            String before =unchanged.substring(0, place);
            lamont = after + before;
        }
    
        
        System.out.println("Elmer says " +word);
        System.out.println("Bandits say " + robberWord);
    }
}
