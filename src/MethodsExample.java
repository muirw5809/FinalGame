
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class MethodsExample {

    //calculating the distance (x1,y1) and (x2,y2)
    static double calcDistance(int x1, int y1, int x2, int y2)
    {
        double distance = Math.sqrt((x2-x1)*(x2-x1)+ (y2-y1)*(y2-y1));
        return distance;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Get the (x,y) for point 1
        System.out.println("Please input an x coordinate for point 1");
        int x1 = input.nextInt();
        System.out.println("Please input a y coordinate for point 1");
        int y1 =input.nextInt();
        
        //Get the (x,y) for point 2
        System.out.println("Please input an x coordinate for point 2");
        int x2 = input.nextInt();
        System.out.println("Please input a y coordinate for point 2");
        int y2 =input.nextInt();
        
        double distance = calcDistance(x1,y1,x2,y2);
        System.out.println("The distance between your two points is " + distance);
    }
}
