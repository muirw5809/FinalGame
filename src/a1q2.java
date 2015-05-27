
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
public class a1q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kw = new City();
        Robot walter = new Robot(kw, 1, 2, Direction.SOUTH);
        Thing ball = new Thing (kw, 2, 2, Direction.EAST);
        Wall wall1 = new Wall(kw, 1, 2, Direction.SOUTH);
         Wall wall2 = new Wall(kw, 1, 2, Direction.EAST);
          Wall wall3 = new Wall(kw, 1, 2, Direction.NORTH);
          Wall wall4 = new Wall(kw, 1, 1, Direction.NORTH);
          Wall wall5 = new Wall(kw, 1, 1, Direction.WEST);
          Wall wall6 = new Wall(kw, 2, 1, Direction.WEST);
          Wall wall7 = new Wall(kw, 2, 1, Direction.SOUTH);
          walter.turnLeft();
          walter.turnLeft();
          walter.turnLeft();
          walter.move();
          walter.turnLeft();
          walter.move();
          walter.turnLeft();
          walter.move();
          walter.pickThing();
          walter.turnLeft();
          walter.turnLeft();
          walter.move();
          walter.turnLeft();
          walter.turnLeft();
          walter.turnLeft();
          walter.move();
          walter.turnLeft();
          walter.turnLeft();
          walter.turnLeft();
          walter.move();
          walter.putThing();
    }
}
