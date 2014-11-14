package model;

public class PlayerModel {
	
	private String Name;
	private int Score = 0;
	
	public PlayerModel(String name){
		this.Name = name;
	}
	
	public String getName(){
		return Name;
	}
	
	public int getScore(){
		return Score;
	}
	
	public void increaseScore(){
		Score++;
	}
	
}
