
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class Variables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kw = new City();
        Robot karel = new Robot(kw, 1, 1, Direction.EAST);
        
        int countLoops = 0;
        while(countLoops < 20) {
            Thing thing = new Thing(kw, 1, 3);
            countLoops = countLoops + 1;
            // or countLoops++;
        }
        //while the robot can Not pcik thing up
        // ! = Not
        while(!karel.canPickThing())
        {
            karel.move();
        }
        //as long as there is something to pick up
        // pick it up
        int countThings = 0;
     while(karel.canPickThing())
     {
         karel.pickThing();
        countThings++;
     }
     // output the value of countThings
     System.out.println(countThings);
    }
    private String countThings;
    {
    System.out.println("karel picked up " + countThings + " things");
    
}
}