/**@author Christopher Jones
 * @since 26/04/16
 * Student Number: i7467340
 * Assignment 2
 * Creating a cooperative arcade video game. A Tennis based game that features two-dimentional graphics.
 * The aim of the game is to work with the other player to get as many rallys as possible while the ball is
 * increasing in speed. The players control the paddles on each side, moving them vertically across the left and right
 * side of the screen.
 *  **/

import java.awt.*;

public class Ball {
	private static final int DIAMETER = 50;
	
	int x = 0;
	int y = 0;
	int xx = 1;
	int yy = 1;
	private Game game;
	
	/**
	 * @param game
	 * This method links the two classes together.
	 * Removing this will cause an unresolved compilation problem.
	 */
	
	public Ball(Game game){
		this.game = game;
	}
	
	/**
	 *	Move() method is used to get the ball moving, the ball will stay stationary without this method.
	 * If the ball collides with the borders of the frame, then the direction and position of the ball will change, reflecting
	 * away from the side of the JFrame.
	 * If the ball ends up colliding with the left and right sides of the JFrame, causes the endGame() method to launch, producing
	 * a JOptionPane, giving the user their rally score and terminating the program once the user has clicked the "OK" button.
	 * If the ball collides with one of the paddles in the game, the direction and position of the ball will change, the
	 * rally score increasing by one and the ball increasing in speed.
	 * x=x+xx; and y=y+yy; are the two formulas used to get the ball moving around in the JFrame.
	 */
	
	void move() {
		if (x + xx < 0)
			game.endGame1();
		if (x + xx > game.getWidth() - DIAMETER)			// We verify that the ball doesn't leave the borders of the frame.
			game.endGame1();								// When the ball collides with the borders, it then changes direction on the x and y axis.
		if (y + yy < 0)				
			yy = game.speed1;
		if (y + yy > game.getHeight() - DIAMETER)			// If the ball collides with the left and right sides of the frame, causes the endGame() method to launch, launching a JOptionPane.showMessageDialog
			yy = -game.speed1;
		if (collision1()){
			xx = game.speed1;								// As the ball collides with each racquet, the speed of the ball increases as well as changing direction and position.
			game.speed1++;
			}
		if (collision2()){
			xx = -game.speed1;
			game.speed1++;
		}												// The two properties (xx and yy) represent speed which the ball is moving
		x = x + xx;
		y = y + yy;											// Using properties ("x" and "y"), we create a method called move().
	}														// The ball moves by modifying the position of the ball, painting a new position every pixel.
	
	/**
	 *	The collision1() method is used once the ball has collided with the paddle of the first player, 
	 *	causing the ball to reflect back towards the second player.
	 *	The ball will change direction and position when the collision occurs.
	 */
	
	private boolean collision1() {
		return game.firstplayer.getBounds().intersects(getBounds());
	}									// When the collision takes place, the ball will change direction and positions.
	
	/**
	 *	The collision2() method is used once the ball has collided with the paddle of the first player, 
	 *	causing the ball to reflect back towards the second player.
	 *	The ball will change direction and position when the collision occurs.
	 */
	
	private boolean collision2() {
		return game.secondplayer.getBounds().intersects(getBounds());
	}
	
	/**
	 * @param graph2D
	 *	Paint(Graphics2D) used paint the ball so it appears when it is moving and when it’s stationary.
	 *	Neither of the x and y coordinates are constant, this is to make sure that the ball is moving in both axis.
	 *	DIAMETER = int 50
	 */
	
	public void paint (Graphics2D graph2D){
		graph2D.fillOval(x, y, DIAMETER, DIAMETER);				// Displaying the ball
	}
	
	/**
	 *	getBounds() method is used to stop the ball from leaving the frame
	 *	 of the game and bounce rebound from the borders.
	 *	@return rectangle(x,y,DIAMETER, DIAMETER);
	 */
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
	
}