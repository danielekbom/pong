package model;

import java.awt.Point;

public class BallModel {

	private Point BallPos = new Point(100,100);
	private int XSpeed = 1;
	private double YSpeed = 0;
	private double MoveYCounter = 0;
	private final int MoveYInterval = 50;
	
	public BallModel(){
		
	}
	
	public Point getBallPos(){
		return BallPos;
	}
	
	public void moveBall(){
		BallPos.x += XSpeed;
		moveBallY();
	}
	
	private void moveBallY(){
		MoveYCounter += Math.abs(YSpeed);
		if(MoveYCounter > MoveYInterval){
			if(YSpeed < 0) { BallPos.y -= 1; } else { BallPos.y += 1; }
			MoveYCounter = 0;
		}
	}
	
	public void setXSpeed(int speed){
		XSpeed = speed;
	}
	
	public int getXSpeed(){
		return XSpeed;
	}
	
	public void setYSpeed(double speed){
		YSpeed = speed;
	}
	
	public double getYSpeed(){
		return YSpeed;
	}
	
	public void setYPos(int y){
		BallPos.y = y;
	}
	
}
 