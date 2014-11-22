package model;

/**
 * Class that represents a player.
 * A player consists of a Name and a Score.
 * @author Daniel and Oscar
 *
 */
public class PlayerModel {
	
	private String Name;
	private int Score = 0;
	
	/**
	 * Constructor for a player.
	 * @param name The player's name.
	 */
	public PlayerModel(String name){
		this.Name = name;
	}
	
	/**
	 * Getter for the player's name.
	 * @return The player's name.
	 */
	public String getName(){
		return Name;
	}
	
	/**
	 * Getter for the player's score.
	 * @return The player's score.
	 */
	public int getScore(){
		return Score;
	}
	
	/**
	 * Method that increases the player's score by one.
	 */
	public void increaseScore(){
		Score++;	
	}
	
	/**
	 * Method that resets the player's score to 0.
	 */
	public void resetScore(){
		Score = 0;
	}
	
}
