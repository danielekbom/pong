package model;

public class BarModel {

	private int Width = 50;
	private int YPosition;
	
	public BarModel(int yPosition){
		this.YPosition = yPosition;
	}
	
	public void moveDown(long delta_t){
		YPosition += 0.2 * delta_t;
	}
	
	public void moveUp(long delta_t){
		YPosition -= 0.2 * delta_t;
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
