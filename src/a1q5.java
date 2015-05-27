
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
public class a1q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
// setup
    City field = new City();
    Robot worker = new Robot(field,0,0,Direction.EAST);
  
    //row 1
    new Thing(field,0,1);
    new Thing(field,0,2);
    new Thing(field,0,3);
    new Thing(field,0,4);
    //row 2
    new Thing(field,1,1);
    new Thing(field,1,2);
    new Thing(field,1,3);
    new Thing(field,1,4);
    //row 3
    new Thing(field,2,1);
    new Thing(field,2,2);
    new Thing(field,2,3);
    new Thing(field,2,4);
    //row 4
    new Thing(field,3,1);
    new Thing(field,3,2);
    new Thing(field,3,3);
    new Thing(field,3,4);
    //row 5
    new Thing(field,4,1);
    new Thing(field,4,2);
    new Thing(field,4,3);
    new Thing(field,4,4);
 int x = 1 ;  
    
    //movement
 while(x<=3)
 {
  x++;
  worker.move();
  while(worker.canPickThing()==true)
  {
    worker.pickThing();
    worker.move();
  }
  worker.turnLeft();
  worker.turnLeft();
  worker.turnLeft();
  worker.move();
  worker.turnLeft();
  worker.turnLeft();
  worker.turnLeft();
  worker.move();
  while(worker.canPickThing()==true)
  {
    worker.pickThing();
    worker.move();
  } 
  worker.turnLeft();
  worker.move();
  worker.turnLeft();
  
 }

    }
}