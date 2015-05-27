
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class InputOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        String name; // store someones name
        System.out.print("Please enter your name: ");
        
        name = input.nextLine(); // reads in the name
            //say hello to user
            System.out.println("Hello " + name);
            System.out.println(); // blank line //sout is a short cut
            
            System.out.println("Please enter a number");
            double aNumber = input.nextDouble(); // int for whole number  
            // replace int with double for int for decimal numbers
            double answer = aNumber + 100;
            System.out.println(aNumber + " + 100 = " + answer);
            
            // ROUNDING UP DECIMALS
                   // num = Math.ceil(num);
            
            
            
    }
}
