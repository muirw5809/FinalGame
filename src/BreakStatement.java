
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class BreakStatement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        City kw = new City();
        RobotSE karel = new RobotSE (kw, 1, 1, Direction.EAST);
        
        Thing thing0 = new Thing (kw, 1, 1);
        Thing thing1 = new Thing (kw, 1, 2);
        Thing thing2 = new Thing (kw, 1, 3);
        Thing thing3 = new Thing (kw, 1, 4);
        Thing thing4 = new Thing (kw, 1, 5);
        Wall wall = new Wall (kw,1,5, Direction.EAST);
        
        while(true){
            karel.pickThing();
            if(karel.frontIsClear()){
                karel.move();
            }else{
                break; //end loop
            }
        }
    }
}
