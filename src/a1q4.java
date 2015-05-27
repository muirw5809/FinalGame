
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class a1q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         City kw = new City();
         Robot walter = new Robot(kw, 0, 0, Direction.SOUTH);
         walter.setLabel("W");
         Robot jeff = new Robot(kw, 0, 1, Direction.SOUTH);
         jeff.setLabel("J");
         Wall wall1 = new Wall(kw, 0, 1, Direction.WEST);
         Wall wall2 = new Wall(kw, 1, 1, Direction.WEST);
         Wall wall3 = new Wall(kw, 1, 1, Direction.SOUTH);
         walter.move();
         jeff.move();
         walter.move();
         jeff.turnLeft();
         jeff.move();
         walter.turnLeft();
         jeff.turnLeft();
         jeff.turnLeft();
         jeff.turnLeft();
         jeff.move();  
         jeff.turnLeft();
         jeff.turnLeft();
         jeff.turnLeft();
         walter.move();
         jeff.move();
         
         
    }
}
