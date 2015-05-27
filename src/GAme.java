/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author muirw5809
 */

// make sure you rename this class if you are doing a copy/paste
public class GAme extends JComponent implements KeyListener{
    
    

    // Height and Width of our game
    static final int WIDTH = 1275;
    static final int HEIGHT = 940;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    int score = 0;
    int lives = 100;
    
    int[] nailX = new int[10];
    int[] nailY = new int[10];
    
    int[] balloonX = new int[10];
    int[] balloonY = new int[10];
    
    
    int x = 400;
    int y = 770;
    int speed = 15;
    
    BufferedImage BloonsBackground = ImageHelper.loadImage ("pics//BloonsBackground.jpg");
    BufferedImage RoboMonkey = ImageHelper.loadImage("pics//RoboMonkey.jpg");
    
    boolean right = false;
    boolean left = false;
    boolean space = false;
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE
        g.drawImage(BloonsBackground, -265, 0, this);
       
        g.setColor(Color.WHITE);
        g.fillRect(00, 875, 1275, 75);
        
        g.drawString("SCORE: " + score, 70, 50);
        g.drawString("LIVES: " + lives, 70, 100);
        
        
        
        g.drawImage(RoboMonkey, x, y, null);
        g.setColor(Color.red);
        for(int i = 0; i < nailX.length; i++)
        {
            g.fillArc(x, nailY[i] + y, 95, 30, 0, 180);
        }
        
        g.setColor(Color.blue);
        for(int i = 0; i < balloonX.length; i++)
        {
         
            g.fillOval(balloonX[i] - 35 , balloonY[i] - 48, 70, 96);
            g.fillRect(balloonX[i] -3 ,balloonY[i] + 48, 6, 45);
        }
        
        
        // GAME DRAWING ENDS HERE
    }
    
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void run()
    {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        BalloonPosition();
        
        
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE
            
            ScoresLives(); 
            MonkeyMovement();
            BalloonReset();
            
            
            
            

            // GAME LOGIC ENDS HERE 
            
            // update the drawing (calls paintComponent)
            repaint();
            
            
            
            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if(deltaTime > desiredTime)
            {
                //took too much time, don't wait
            }else
            {
                try
                {
                    Thread.sleep(desiredTime - deltaTime);
                }catch(Exception e){};
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");
       
        // creates an instance of my game
        GAme game = new GAme();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        // adds the game to the window
        frame.add(game);
         
        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        frame.addKeyListener(game);
        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
       if(keyCode == KeyEvent.VK_RIGHT)
       {
           right = true;
       }else if(keyCode == KeyEvent.VK_LEFT)
       {
           left = true;
       }
       if(keyCode == KeyEvent.VK_SPACE)
       {
           space = true;
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    int keyCode = e.getKeyCode();
       if(keyCode == KeyEvent.VK_RIGHT)
       {
           right = false;
       }else if(keyCode == KeyEvent.VK_LEFT)
       {
           left = false;
       }
       if(keyCode == KeyEvent.VK_SPACE)
       {
           space = false;
       }
    }
    

    
    //method to subtract a live everytime the balloon hits the wall
    //and when lives hits 0 reset back to 100 and score becomes 100
    public void ScoresLives()
    { 
    for(int i = 0; i < balloonX.length; i++)
      if(balloonY[i] ==y +112 && balloonX[i] <1275)
            {
                lives--;
                
            }
         if(lives == 0)
         {
             lives= 0+100;
             score =0;
         }
    }
    
    //allows moneky to move left and right
    //keeps monkey from travelling off the screen
    public void MonkeyMovement()
    {    
        if(right)
            {
                
                x = x + speed;
            }
            if(left)
            {
                
                x = x - speed; 
            }
            
              if(x<0)//moving off left hand side
            {
                x = 0;
            }
            if( x + 95 >WIDTH)
            {
                x = WIDTH -95;
            }
            if(y <0)
            {
                y = 0;
            }
            if(y + 50 >HEIGHT)
            {
                y = HEIGHT - 50;
            }
    }
    
    //allows balloons to fall at differnt heights
    //and also makes them fall at random x positions
    public void BalloonPosition ()
    {
        
        int y = 10;
       
        for(int i = 0; i < balloonX.length; i++)
        {
             
            
            int x = (int)(Math.random()*1275) + 10;
            balloonX[i] = x;
            balloonY[i] = y;
            y += 100;
            if(y > 700)
            {
                y = 10;
            }
            
        }
    
    }
    
    //causes balloons to reset as soon as they hit the wall
    public void BalloonReset ()
    {
        for(int i = 0; i < balloonY.length; i++)
            {
                balloonY[i] += 2;
                
                if(balloonY[i] > 900)
                {
                    int x = (int)(Math.random()*1275) + 10;
                    balloonX[i] = x;
                    balloonY[i] = -80;
                   
                    
                }
            }
    }
    
    public void Shooting ()
    {
        if(space)
        {
            nailY[0] -=10;
        }
    }

    
        
        
        
        
    
}