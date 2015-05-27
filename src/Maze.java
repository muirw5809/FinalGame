
import becker.robots.Direction;
import becker.robots.MazeCity;
import becker.robots.Robot;
import becker.robots.RobotSE;
import becker.robots.Thing;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muirw5809
 */
public class Maze {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    MazeCity maze = new MazeCity(100,100);
    RobotSE karel = new RobotSE (maze, 0, 0, Direction.EAST);
    new Thing(maze, 0, 9);
    //while kaerl cannot pick something up
    while(!karel.canPickThing())
    {
   
        // check left wall
        karel.turnLeft();
        if(karel.frontIsClear())
        {
            karel.move();
        }else
{
    karel.turnLeft();
    karel.turnLeft();
    karel.turnLeft();
    if(karel.frontIsClear())
    {
        karel.move();
    }else
    {
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
    }
    }
    
}
    }
}
    
