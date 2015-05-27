/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author muirw5809
 */

// make sure you rename this class if you are doing a copy/paste
public class Pong extends JComponent implements KeyListener{

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    //paddle variables
    int p1Width =15;
    int p1Height = 120;
    int p1x =40;
    int p1y = HEIGHT/2 - p1Height/2;
    
    int p2Width = 15;
    int p2Height = 120;
    int p2x = WIDTH - 40 - p2Width;
    int p2y = HEIGHT/2 - p2Height/2;
    
    
    int paddleSpeed = 15;
    
    //ball variables
    int ballWidth = 20;
    int ballHeight = 20;
    int ballx = WIDTH/2 - ballWidth/2;
    int bally = HEIGHT/2 - ballHeight/2;
    int balldx = 1;//x direction of ball
    int balldy = 1;//y direction of ball
    int ballSpeed = 7;
    
    //scores
    
    int p1Score = 0;
    int p2Score = 0;
    
    //control variables
    boolean p1Up = false;
    boolean p1Down = false;
    boolean p2Up = false;
    boolean p2Down = false;
    
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.setColor(Color.white);
        //draw ball
        g.fillRect(ballx, bally, ballWidth, ballHeight);
        
        g.fillRect(p1x, p1y, p1Width, p1Height);
        g.fillRect(p2x, p2y, p2Width, p2Height);
        
        
        g.drawString("Player 1: " + p1Score, 70, 100);
        g.drawString("Player 2: " + p2Score, 650, 100);
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
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            //move the ball
            ballx += balldx*ballSpeed;
            bally += balldy*ballSpeed;
            //bottom of the ball hits bottom of screen
            if(bally +ballHeight > HEIGHT)
            {
               balldy = -1;
            }
            
            if(ballx + ballWidth > WIDTH)
            {
                p1Score++;
                 ballx = WIDTH/2 - ballWidth/2;
                 bally = HEIGHT/2 - ballHeight/2;
            }
            
            if(bally<0)
            {
               balldy=1;
            }
            
            if(ballx <0)
            {
                p2Score++;
               ballx = WIDTH/2 - ballWidth/2;
               bally = HEIGHT/2 - ballHeight/2;
            }
            
            //move paddle 1
            if(p1Up)
            {
                p1y -= paddleSpeed;
            }else if(p1Down)
            {
                p1y += paddleSpeed;
            }
            if(p2Up)
            {
                p2y -= paddleSpeed;
            }else if(p2Down)
            {
                p2y += paddleSpeed;
            }
            
            //ball htiing paddle 1
            //NOT not hitting
            if(!(ballx + ballWidth  < p1x ||
                ballx > p1x + p1Width    ||
                bally > p1y + p1Height   ||
                bally + ballHeight < p1y))
            {
                balldx = 1;
            }
            if(!(ballx + ballWidth  < p2x ||
                ballx > p2x + p2Width    ||
                bally > p2y + p2Height   ||
                bally + ballHeight < p2y))
            {
                balldx = -1;
            }
            if(p1y<0)
            {
                p1y = 1;
            }
            if(p2y<0)
            {
                p2y = 1;
            }
            if(p1y +p1Height > HEIGHT)
            {
               p1y = 480;
            }
            if(p2y +p2Height > HEIGHT)
            {
               p2y = 480;
            }
            
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
        Pong game = new Pong();
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
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_W)
        {
            p1Up = true;
        }
        if(key == KeyEvent.VK_S)
        {
            p1Down = true;
        }
        if(key == KeyEvent.VK_UP)
        {
            p2Up = true;
        }
        if(key == KeyEvent.VK_DOWN)
        {
            p2Down = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_W)
        {
            p1Up = false;
        }
        if(key == KeyEvent.VK_S)
        {
            p1Down = false;
        }
        
        if(key == KeyEvent.VK_UP)
        {
            p2Up = false;
        }
        if(key == KeyEvent.VK_DOWN)
        {
            p2Down = false;
        }
    }
}