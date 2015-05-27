
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
public class a1q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kw = new City();
        Robot walter = new Robot(kw, 3, 0, Direction.EAST);
        Thing ball = new Thing(kw, 3, 1, Direction.NORTH);
        Wall wall1 = new Wall(kw, 3, 2, Direction.WEST);
        Wall wall2 = new Wall(kw, 3, 2, Direction.NORTH);
        Wall wall3 = new Wall(kw, 2, 3, Direction.WEST);
        Wall wall4 = new Wall(kw, 1, 3, Direction.WEST);
        Wall wall5 = new Wall(kw, 1, 3, Direction.NORTH);
        Wall wall6 = new Wall(kw, 1, 3, Direction.EAST);
      
        Wall wall8 = new Wall(kw, 2, 4, Direction.NORTH);
        Wall wall9 = new Wall(kw, 2, 4, Direction.EAST);
        Wall wall10 = new Wall(kw, 3, 4, Direction.EAST);
        walter.move();
        walter.pickThing();
        walter.turnLeft();
        walter.move();
        walter.turnLeft();
        walter.turnLeft();
        walter.turnLeft();
        walter.move();
        walter.turnLeft();
        walter.move();
        walter.move();
        walter.turnLeft();
        walter.turnLeft();
        walter.turnLeft();
        walter.move();
        walter.move();
        walter.turnLeft();
        walter.turnLeft();
        walter.turnLeft();
        walter.move();
        walter.turnLeft();
        walter.move();
        walter.turnLeft();
        walter.turnLeft();
        walter.turnLeft();
        walter.move();
        walter.move();
        walter.turnLeft();
        
    }
}
