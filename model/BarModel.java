package model;

import java.awt.Dimension;

/**
 * This class represents a Bar.
 * A Bar consists of a starting width, a starting y position, a width,
 * an y position and a Player. Player is an instance of PlayerModel which
 * represents the player that is linked to the Bar. 
 * @author Daniel and Oscar
 *
 */
public class BarModel {

	private final int StartingWidth = 150;
	private final int StartingY = 250;
	private int Width = StartingWidth;
	private int YPosition = StartingY;
	private PlayerModel Player;
	
	/**
	 * Constructor for a Bar.
	 * @param player The player to link to the Bar.
	 */
	public BarModel(PlayerModel player){
		this.Player = player;
	}
	
	/**
	 * This method moves the Bar's position down, i.e. increases the y position.
	 * The Bar does not move if it is at the bottom of the game field.
	 * @param delta_t The time since the previous time the game's compute method was called.
	 * @param FieldSize The size of the game field.
	 */
	public void moveDown(long delta_t, Dimension FieldSize){
		if(YPosition < FieldSize.height && delta_t > 0 && FieldSize != null){
			YPosition += 0.2 * delta_t;
		}
	}
	
	/**
	 * This method moves the Bar's position up, i.e. decreases the y position.
	 * The Bar does not move if it is at the top of the game field.
	 * @param delta_t The time since the previous time the game's compute method was called.
	 */
	public void moveUp(long delta_t){
		if(YPosition > 0 && delta_t > 0){
			YPosition -= 0.2 * delta_t;
		}
	}
	
	/**
	 * Setter for the Bar's width.
	 * The width only updates if the new value is greater than 0.
	 * @param width The new width to set to the Bar's width.
	 * @return True if the width was successfully updated.
	 */
	public boolean setWidth(int width){
		
		if (width > 0) {
			this.Width = width;
			return true;
		}
		return false;
	}
	
	/**
	 * Getter for the Bar's width.
	 * @return The Bar's width.
	 */
	public int getWidth(){
		return Width;
	}
	
	/**
	 * Setter for the Bar's y position.
	 * @param yPosition The new y position to update to.
	 */
	public void setYPosition(int yPosition){
		if( yPosition >= 0) {
			this.YPosition = yPosition;
		}
	}
	
	/**
	 * Getter for the Bar's y position.
	 * @return The Bar's y position.
	 */
	public int getYPosition(){
		return YPosition;
	}
	
	/**
	 * Getter for the player that is linked to the Bar
	 * @return The player that is linked to the Bar.
	 */
	public PlayerModel getPlayer(){
		return Player;
	}

	/**
	 * Method that decreases the width of the bar.
	 * The width is only updated if the current width greater than 50 + decreaseWith, else it is set to 50.
	 * @param decreaseWith The value to decrease the width with.
	 */
	public void decreaseWidth(int decreaseWith) {
		if (this.Width > 50 + decreaseWith) {
			Width -= decreaseWith;
		} else {
			Width = 50;
		}
	}

	/**
	 * Resets the Bar to the starting width and position.
	 */
	public void resetBar() {
		Width = StartingWidth;
		resetY();
	}
	
	/**
	 * Resets the Bar to the starting y position.
	 */
	public void resetY(){
		YPosition = StartingY;
	}
	
}
