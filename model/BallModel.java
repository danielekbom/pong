package model;

import java.awt.Point;

public class BallModel {

	private Point BallPos = new Point(100,100);
	private Direction BallDir = Direction.RIGHT;
	private int Speed = 1;
	
	public BallModel(){
		
	}
	
	public Point getBallPos(){
		return BallPos;
	}
	
	public void moveBall(){
		if(BallDir == Direction.LEFT){
			BallPos.x -= Speed;
		}else if(BallDir == Direction.RIGHT){
			BallPos.x += Speed;
		}
	}
	
	public void setDir(Direction dir){
		BallDir = dir;
	}
	
}
