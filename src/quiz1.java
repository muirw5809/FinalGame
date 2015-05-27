
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         City kw = new City();
        RobotSE karel = new RobotSE (kw, 0, 1, Direction.SOUTH);
        
        Thing thing1 = new Thing (kw, 1, 1);
        Thing thing2 = new Thing (kw, 1, 1);
        Thing thing3 = new Thing (kw, 1, 1);
        
        Thing thing4 = new Thing (kw, 2, 1);
        Thing thing5 = new Thing (kw, 2, 1);
        
        Thing thing6 = new Thing (kw, 3, 1);
        Thing thing7 = new Thing (kw, 3, 1);
        Thing thing8 = new Thing (kw, 3, 1);
        Thing thing9 = new Thing (kw, 3, 1);
        Thing thing10 = new Thing (kw, 3, 1);
        
        Thing thing11 = new Thing (kw, 4, 1);
        Thing thing12 = new Thing (kw, 4, 1);
        Thing thing13 = new Thing (kw, 4, 1);
        Thing thing14 = new Thing (kw, 4, 1);
        
       while(karel.getStreet()!=5){
           karel.move();
           karel.turnLeft();
           while(karel.canPickThing()){
               karel.pickAllThings();
           }
           while(karel.countThingsInBackpack() >0)
       {
           karel.putThing();
           karel.move();
       } 
           karel.turnAround();
           while(karel.getAvenue() !=1){
               karel.move();
           }
           karel.turnLeft();
       }
    }
}
