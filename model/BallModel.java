package model;

import java.awt.Point;

public class BallModel {

	private Point BallPos = new Point(100,100);
	private Direction BallDir = Direction.LEFT;
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
		moveBallX();
		moveBallY();
	}
	
	private void moveBallX(){
		if(BallDir == Direction.LEFT){
			BallPos.x -= XSpeed;
		}else if(BallDir == Direction.RIGHT){
			BallPos.x += XSpeed;
		}
	}
	
	private void moveBallY(){
		MoveYCounter += Math.abs(YSpeed);
		if(MoveYCounter > MoveYInterval){
			if(YSpeed < 0) { BallPos.y -= 1; } else { BallPos.y += 1; }
			MoveYCounter = 0;
		}
	}
	
	public void setDir(Direction dir){
		BallDir = dir;
	}
	
	public void setXSpeed(int speed){
		XSpeed = speed;
	}
	
	public void setYSpeed(double speed){
		YSpeed = speed;
	}
	
}
 