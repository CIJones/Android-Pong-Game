/**@author Christopher Jones
 * @since 26/04/16
 * Student Number: i7467340
 * Assignment 2
 * Creating a cooperative arcade video game. A Tennis based game that features two-dimentional graphics.
 * The aim of the game is to work with the other player to get as many rallys as possible while the ball is
 * increasing in speed. The players control the paddles on each side, moving them vertically across the left and right
 * side of the screen. **/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel {
	private static final int GAMEWIDTH = 800;
	private static final int GAMEHEIGHT = 600;
	Ball ball = new Ball(this);
	Player1 firstplayer = new Player1(this);
	Player2 secondplayer = new Player2(this);
	int speed1 = 1;														// This integer is used to keep the speed of the game. Initialise it as 1 and will increase every time the ball collides with each racquet.
	
	/**
	 *	The getRally1() method will return the value of speed1 by -1
	 *	@return speed1 - 1
	 */
	
	public int getRally1() {											//This method returns the value of speed1 by -1.
		return speed1 - 1;
	}
	
	/**
	 *	The game() method contains the KeyListener that's used to enable the first and second players to press and release
	 *	keys whenever they want.
	 *	keyTyped is not used in this method because the feature wasn't required to allow the users to use keys to control
	 *	the paddle effectively.
	 *	setFocusable(true) indicates whether the component can gain focus or not.
	 */
	
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {							// Implementing a KeyListener to give the users keyboard input when playing the Pong game
			}															// Create the listener, including setFocusable(true) which allows the Keyboard Input to recieve focus.

			@Override
			public void keyReleased(KeyEvent e) {
				firstplayer.keyReleased(e);
				secondplayer.keyReleased(e);							// Gives each player the ability to press and release keys
			}

			@Override
			public void keyPressed(KeyEvent e) {
				firstplayer.keyPressed(e);
				secondplayer.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	/**
	 *	The move() method will allow the ball and paddles to move using the keyboard inputs given by the users.
	 *	Linking the classes to give the objects the ability to move in the JFrame freely.
	 */
	
	private void move() {
		ball.move();
		firstplayer.move();												// The move method contains properties that allow the ball and players to move.
		secondplayer.move();
	}
	
	/**
	 *	The paint(Graphics) method will display
	 * 	each of the objects in the game effectively, repainting them as the objects change position.
	 * 	Applying antialiasing on will make the borders of the objects appear smoother.
	 * 	super.paint(graphics) causes the screen to appear more clean.
	 */
	
	public void paint(Graphics graphics) {
		super.paint(graphics);									
		Graphics2D graph2D = (Graphics2D) graphics;
		graph2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);						//Causes the borders to become smoother.
		ball.paint(graph2D);											// Using the paint function to display the ball and players
		firstplayer.paint(graph2D);								
		secondplayer.paint(graph2D);
		
		graph2D.fillRect(380,0,20,600);									// Producing the rectangle in the middle of the game, acting to separate the two player's sides.
		
		graph2D.setColor(Color.BLACK);
		graph2D.setFont(new Font("ariel", Font.BOLD, 50));				//Setting the rally score with a black ariel font
		graph2D.drawString(String.valueOf(getRally1()), 50, 50);
		}
	
	/**
	 *	The endgame() method will be active once the paddle interacts with the left and right side of the panel.
	 *	A JOptionPane will appear once the interaction has taken place, giving the user their rally score and a JButton
	 *	to terminate the program.
	 *	The program has to terminate once it gets to this point.
	 */
	
	public void endGame1() {
		JOptionPane.showMessageDialog(this, "Your Rally Is: " + getRally1(), "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);												// Displays a JOptionPane when the ball collides with the left and right sides of the frame.
	}																	// Shows a message of the score both players got and pressing the "OK" button terminates the program.
	
	/**
	 * @param args
	 *	The main method contains all the frames and also telling the processor that the thread should sleep
	 *	every 7 milliseconds.
	 *	The main method also contains the JFrame used in this program that has been set to size 800 pixels by 600 pixels.
	 *	The JFrame is visible and the program terminates when the user closes the window.
	 *	@throws InterruptedException
	 *	Throwing an exception due to Thread.sleep(7) being an unhandled exception type
	 */
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Pong");								// Created the window "Pong" that's 800 pixels by 600 pixels
		Game game = new Game();									
		frame.add(game);
		frame.setSize(GAMEWIDTH, GAMEHEIGHT);							//Setting the JFrame size
		frame.setVisible(true);											//JFrame set as visible to make the window show up
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//Including the line "EXIT_ON_CLOSE" will terminate the program when closing the window.
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(7);											// Telling the processor that the thread should sleep every 7 milliseconds.
		}
	}
}
