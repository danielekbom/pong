package model;

import java.awt.Point;

public class BallModel {

	private Point BallPos = new Point(100,100);
	
	private double Speed = 0.2;
	private double dX = Speed;
	private double dY = 0.0;
	private double Angle = 0;
	
	public BallModel(){

	}
	
	public void leftBarBounce(double distance) {
		if(distance > 0.8) Angle = Math.toRadians(80);
		else if(distance > 0.6) Angle = Math.toRadians(60);
		else if(distance > 0.4) Angle = Math.toRadians(40);
		else if(distance > 0.2) Angle = Math.toRadians(20);
		else if(distance < -0.8) Angle = Math.toRadians(280);
		else if(distance < -0.6) Angle = Math.toRadians(300);
		else if(distance < -0.4) Angle = Math.toRadians(320);
		else if(distance < -0.2) Angle = Math.toRadians(340);
		else Angle = 0;
		dX = Math.cos(Angle) * Speed;
		dY = Math.sin(Angle) * Speed;
	}

	public void rightBarBounce(double distance) {
		if(distance > 0.8) Angle = Math.toRadians(100);
		else if(distance > 0.6) Angle = Math.toRadians(120);
		else if(distance > 0.4) Angle = Math.toRadians(140);
		else if(distance > 0.2) Angle = Math.toRadians(160);
		else if(distance < -0.8) Angle = Math.toRadians(260);
		else if(distance < -0.6) Angle = Math.toRadians(240);
		else if(distance < -0.4) Angle = Math.toRadians(220);
		else if(distance < -0.2) Angle = Math.toRadians(200);
		else Angle = 0;
		
		if(Angle == 0) dX = (-1 * Speed);
		else dX = (Math.cos(Angle) * Speed);
		
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
 