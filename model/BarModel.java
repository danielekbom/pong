package model;

public class BarModel {

	private int Width = 50;
	private int XPosition;
	
	public BarModel(int xPosition){
		this.XPosition = xPosition;
	}
	
	public void moveDown(){
		XPosition += 5;
	}
	
	public void moveUp(){
		XPosition -= 5;
	}
	
	public void setWidth(int width){
		this.Width = width;
	}
	
	public int getWidth(){
		return Width;
	}
	
	public void setXPosition(int xPosition){
		this.XPosition = xPosition;
	}
	
	public int getXPosition(){
		return XPosition;
	}
	
}
