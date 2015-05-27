/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author muirw5809
 */

// make sure you rename this class if you are doing a copy/paste
public class Jumping extends JComponent implements KeyListener{

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    //controls
    boolean right = false, left = false, jump = false, inAir = false;
    
    // character variables
    Rectangle player = new Rectangle (100,500,50,50);
    Rectangle block = new Rectangle (300,-100,100,50);
    Rectangle block2 = new Rectangle (500,500,100,50);
    //gravity
    int camy = 0;
    int camx = 0;
    int gravity = 2;
    int dy = 0;
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        g.setColor(Color.red);
        g.fillRect(player.x - camx, player.y - camy, player.width, player.height);
        
        
        g.setColor(Color.BLACK);
        g.fillRect(block.x - camx,block.y - camy,block.width,block.height);
        g.fillRect(block2.x - camx,block2.y - camy,block2.width,block2.height);
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
            
            //apply gravity
            dy = dy + gravity;
            if (right)
            {
                player.x += 5;
            }
            if (left)
            {
                player.x -= 5;
            }
            if(jump & !inAir)
            {
                dy =  -70;
                inAir = true;
            }
            
            
            player.y += dy;
            if (player.y > 500)
            {
                player.y =500;
                dy = 0;
                inAir = false;
            }
            
            if(player.intersects(block))
            {
               handleCollision(player,block); 
            }else if (player.intersects(block2))
            {
                handleCollision(player,block2);
            }
            
            //do camera corrections
            if(player.x < WIDTH/2)
            {
                camx = 0;
            }else
            {
                camx = player.x - WIDTH/2;
            }    
            
            if(player.y > HEIGHT/2)
            {
                camy = 0;
            }else
            {
                camy = player.y - HEIGHT/2;
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
        Jumping game = new Jumping();
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
        
        if(key == KeyEvent.VK_RIGHT)
        {
            right = true;
        }
        if(key == KeyEvent.VK_LEFT)
        {
            left = true;
        }
        if(key == KeyEvent.VK_SPACE)
        {
            jump = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
        if(key == KeyEvent.VK_LEFT)
        {
            left = false;
        }
        if(key == KeyEvent.VK_SPACE)
        {
            jump = false;
        }
    }
    public void handleCollision (Rectangle player, Rectangle block)
    {
        //make little overlap rectangle
        Rectangle overlap = player.intersection(block);
    
        //handle collision
        //if height is bigger
        if(overlap.height > overlap.width)
        {
            if(player.x < block.x)
            {
                player.x -= overlap.width;
            }else if(player.x + player.width > block.x + block.width)
            {
                player.x += overlap.width;
            }
        }else 
        {
            //stop y movement
            dy= 0;
            if(player.y < block.y)
            {
                player.y -= overlap.height;
                inAir = false;
            }else if(player.y + player.height > block.y + block.height)
            {
                player.y += overlap.height;
            }
        }
    }
}