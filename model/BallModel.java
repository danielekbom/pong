package model;

import java.awt.Point;

public class BallModel {

	private Point BallPos = new Point(100,100);
	private double XSpeed = 0.15;
	private double YSpeed = 0;
	
	public BallModel(){
		
	}
	
	public Point getBallPos(){
		return BallPos;
	}
	
	public void moveBall(long delta_t){
		BallPos.x += XSpeed * delta_t;
		moveBallY(delta_t);
	}
	
	private void moveBallY(long delta_t){
		BallPos.y += YSpeed * delta_t;
	}
	
	public void setXSpeed(double speed){
		XSpeed = speed;
	}
	
	public double getXSpeed(){
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
 