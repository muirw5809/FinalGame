
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
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
public class RobotTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello world");
        City kw = new City();
        Robot karel = new Robot(kw, 1, 2, Direction.EAST);
        Robot jeff = new Robot (kw, 1, 4, Direction.WEST);
        Thing trash = new Thing(kw, 3, 4);
       
        //walls 
        Wall wall1 = new Wall(kw, 1, 2, Direction.NORTH);
        Wall wall2 = new Wall(kw, 1, 3, Direction.NORTH);
        Wall wall3 = new Wall(kw, 1, 4, Direction.NORTH);
        // label robots
        karel.setLabel("K");
        jeff.setLabel("J");
        // make the robot move
        karel.move();      jeff.move();
        karel.move();      jeff.move();
        karel.move();      jeff.move();
        karel.move();      jeff.move();
        karel.turnLeft();  jeff.turnLeft();
        karel.turnLeft();  
        karel.turnLeft(); 
        karel.move();      jeff.move();
        karel.move();      jeff.move();
        jeff.turnLeft();   karel.turnLeft();
        jeff.move();       karel.turnLeft();
        jeff.move();       karel.turnLeft();
        jeff.move();
        jeff.move();       karel.move();
        jeff.pickThing();
        jeff.turnLeft();
        jeff.move();
        jeff.putThing();
        jeff.move();
        jeff.move();
        
        
    }
}
