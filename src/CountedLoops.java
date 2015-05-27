
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author muirw5809
 */
public class CountedLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kw = new City();
        Robot karel = new Robot(kw, 1, 1, Direction.EAST);

//        int count = 4;
//        while(count > 0)
//        {
//            karel.move();
//            karel.move();
//            karel.turnLeft();
//            karel.turnLeft();
//            karel.turnLeft();
//            count--;
//    }

        for (int street = 0; street < 4; street++) {
            for (int ave = 0; ave < 4; ave++) {
                karel.move();
            }
            //if the street number is odd
            if (street % 2 == 1) {
                karel.turnLeft();
                karel.move();
                karel.turnLeft();
            } else {
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();
                karel.move();
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();
            }
        }
    }
}