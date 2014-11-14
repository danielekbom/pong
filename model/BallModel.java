package model;

import java.awt.Point;

public class BallModel {

	private Point BallPos = new Point(100,100);
	private double XSpeed = 0.15;
	private double YSpeed = 0;
	
	private double Speed = 0.20;
	private double dX = 0.15;
	private double dY = 0.00;
	private double Angle = 0;//Math.atan(Math.toRadians(dY) / Math.toRadians(dX));
	
	public BallModel(){
		System.out.println(Angle);
	}
	
	public void leftBarBounce(double distance) {
		//Angle -= Math.PI;
		//Angle = Math.PI*2 - Angle; // 98
		//dY = Math.sin(Angle) * Speed;
		
		if(distance > 0.1){
			Angle = Math.toRadians(160);
		}else if(distance < -0.1){
			Angle = Math.toRadians(220);
		}else{
			Angle = 0;
		}
		dY = Math.sin(Angle) * Speed;
		dX = (Math.cos(Angle) * Speed);
	}

	public void rightBarBounce(double distance) {
		//Angle += Math.PI;
		//Angle = Angle%(Math.PI*2);
		//Angle = Math.PI*2 - Angle; // 98
		System.out.println(distance);
		if(distance > 0.1){
			Angle = Math.toRadians(140);
		}else if(distance < -0.1){
			Angle = Math.toRadians(220);
		}else{
			Angle = 0;
		}
		dY = Math.sin(Angle) * Speed;
		dX = (Math.cos(Angle) * Speed);
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
 