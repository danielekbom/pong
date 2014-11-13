package model;

public class BarModel {

	private int Width = 50;
	private int YPosition;
	
	public BarModel(int yPosition){
		this.YPosition = yPosition;
	}
	
	public void moveDown(){
		YPosition += 5;
	}
	
	public void moveUp(){
		YPosition -= 5;
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
	
}
