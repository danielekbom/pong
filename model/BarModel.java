package model;

import java.awt.Dimension;

public class BarModel {

	private final int StartingWidth = 150;
	private final int StartingY = 250;
	private int Width = StartingWidth;
	private int YPosition = StartingY;
	private PlayerModel Player;
	
	public BarModel(PlayerModel player){
		this.Player = player;
	}
	
	public void moveDown(long delta_t, Dimension FieldSize){
		if(YPosition < FieldSize.height){
			YPosition += 0.2 * delta_t;
		}
	}
	
	public void moveUp(long delta_t){
		if(YPosition > 0){
			YPosition -= 0.2 * delta_t;
		}
	}
	
	public void setWidth(int width){
		this.Width = width;
	}
	
	public int getWidth(){
		return Width;
	}
	
	public void setYPosition(int yPosition){
		this.YPosition = yPosition;
	}
	
	public int getYPosition(){
		return YPosition;
	}
	
	public PlayerModel getPlayer(){
		return Player;
	}

	public void decreaseWidth(int decreaseWith) {
		Width -= decreaseWith;
	}

	public void resetBar() {
		Width = StartingWidth;
		resetY();
	}
	
	public void resetY(){
		YPosition = StartingY;
	}
	
}
