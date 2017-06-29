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


public class Player1 {
	private Game game;
	private static final int Y = 30;						// Keeping the x-coordinates stationary. Restricting user to move in the x-direction
	private static final int WIDTH = 20;		
	private static final int HEIGHT = 110;					// Constraints to make the coding easier.
	int x = 200;											// Setting the position of the player in the middle of the left side.
	int xx = 0;
	
	/**
	 * @param game
	 * This method links the two classes together.
	 * Removing this will cause an unresolved compilation problem.
	 */
	
	public Player1(Game game) {
		this.game = game;
	}

	/**
	 *	The move() method allows the paddle to move in the game effectively
	 *	The formula is providing the movement of the paddle in the y-directions, restricing the ability for the player
	 *	to move in the x-direction.
	 *	If the sum of the integers x and xx are greater than one and is still in the boundaries of the frame, then
	 *	the paddle will move upwards.
	 *	If the sum of the integers x and xx are less and one but still in the boundaries of the frame, then the paddle
	 *	will move downwards.
	 *	The paddle will not move if it is exceeding the boundaries of the frame.
	 */
	
	public void move() {
		if (x + xx > 0 && x + xx < game.getHeight()- HEIGHT)
			x = x + xx;										// This method is like the ball, the "xx" increases in speed and doesn't leave the borders of the frame.
	}
	
	/**
	 * 	@param graph2D
	 *	The paint(Graphics2D) method will display the paddle for the game, also repaints 
	 *	the paddle when movement has occurred.
	 *	The x-coordinates for the paddle is a constant value, this causes the paddle to not be able to move in the
	 *	x-direction.
	 */
	
	
	public void paint(Graphics2D graph2D) {
		graph2D.fillRect(Y, x, WIDTH, HEIGHT);				//Keeping the x-coordinates in a stationary position
	}
	
	/**
	 * 	@param e
	 *	The keyPressed() method makes sure that the user can press the keys to move the paddle in the game.
	 *	The greater the magnitude of the xx component is, the faster the paddle will move when the player presses either
	 *	of the keys provided.
	 *	Showing that if the user presses the key "UP", then the paddle will move upwards in the y-direction, whereas if the user presses the
	 *	key "down", then the paddle will move downwards in the y-direction.
	 */
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)				// By pressing the keys "W" and "S", the keyPressed method will be enabled, causing "xx" to equal 1
			xx = -5;										// Pressing "W" will make the racket go up. Pressing "S" will make the racket go down
		if (e.getKeyCode() == KeyEvent.VK_S)
			xx = 5;
	}
	
	/**
	 * 	@param e
	 *	The keyReleased() method allows the user to release the key to stop the paddle from moving up or down in the game.
	 *	When the user releases the key, the integer xx will return back to 0, this causes the user's paddle to become
	 *	stationary.
	 */
	
	public void keyReleased(KeyEvent e) {					// Method keyReleased will be enabled when the key has released, changing the value to 0.
		xx = 0;												// This causes the racket to stop moving
	}
	
	/**
	 *	The getBounds() method ensures that the paddle cannot leave the frame of the game when playing.
	 *	@return Rectangle
	 */
	
	public Rectangle getBounds() {
		return new Rectangle(Y, x, WIDTH, HEIGHT);
	}
	
	/**
	 *	The getTopY() method is used to give the position of the racket in the y-axis of the upper part of the racket
	 *	@return getTopY
	 */
		
	public int getTopY() {									// This method gives the position of the racket in the y-axis of the upper part of the racket.
		return Y;
	}

}
