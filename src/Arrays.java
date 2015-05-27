
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       //declarer an array with 10 spots
       int[] nums = new int[10];
       
       //initial the array to 0
       //goes from 0 to the length of the array
       for(int i =0; i < nums.length; i++)
       {
           nums[i] = 0;
       }
       
        for(int i =0; i < nums.length; i++)
        {
        System.out.println("Please enter a value for number" + (i + 1));
        nums [i] = input.nextInt();
        }
        
        
        //add all the numbers in the array
        int total = 0;
        for(int i =0; i <nums.length; i++)
        {
            total = total + nums[i];
        }
        
        System.out.println("The sum of the numbers is " + total);
        
        int average = total/nums.length;
        System.out.println("The average of the numbers is " + average);
        
        //find the biggest number
        int biggest = nums[0];
        for(int i = 0; i <nums.length; i++)
        {
            if(nums[i] > biggest)
            {
                //biggest number is now the current number
             biggest = nums[i];
            }    
        }
        System.out.println("The maximum number is " + biggest);
        
//        nums [1] = 15;
//        nums [2] = nums [0] * nums[1];
    }
}
