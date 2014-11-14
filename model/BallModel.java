package model;

import java.awt.Point;

public class BallModel {

	private Point BallPos = new Point(100,100);
	private double XSpeed = 0.15;
	private double YSpeed = 0;
	
	private double Speed = 0.2;
	private double dX = 0.2;
	private double dY = 0.0;
	private double Angle = 0;
	
	public BallModel(){
		System.out.println(Angle);
	}
	
	public void leftBarBounce(double distance) {
		if(distance > 0.1){
			Angle = Math.toRadians(140);
			dX = -1*(Math.cos(Angle) * Speed);
		}else if(distance < -0.1){
			Angle = Math.toRadians(220);
			dX = -1*(Math.cos(Angle) * Speed);
		}else{
			Angle = 0;
			dX = (Math.cos(Angle) * Speed);
		}
		dY = Math.sin(Angle) * Speed;
	}

	public void rightBarBounce(double distance) {
		System.out.println(distance);
		if(distance > 0.1){
			Angle = Math.toRadians(140);
			dX = (Math.cos(Angle) * Speed);
		}else if(distance < -0.1){
			Angle = Math.toRadians(220);
			dX = (Math.cos(Angle) * Speed);
		}else{
			Angle = 0;
			dX = -1*(Math.cos(Angle) * Speed);
		}
		dY = Math.sin(Angle) * Speed;
	}
	
	public Point getBallPos(){
		return BallPos;
	}
	
	public void moveBall(long delta_t){
		BallPos.x += dX * delta_t;
		moveBallY(delta_t);
	}
	
	private void moveBallY(long delta_t){
		BallPos.y += dY * delta_t;
	}
	
	public void setXSpeed(double speed){
		dX = speed;
	}
	
	public double getXSpeed(){
		return dX;
	}
	
	public void setYSpeed(double speed){
		dY = speed;
	}
	
	public double getYSpeed(){
		return dY;
	}
	
	public void setYPos(int y){
		BallPos.y = y;
	}
	
}
 