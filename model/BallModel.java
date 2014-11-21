package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

/**
 * This class represents a ball in the game.
 * A ball consists of a BallPosition, a StartSpeed, dX, dY and an Angle.
 * dX is the horizontal speed, dY the vertical speed, and their value depends on Angle.
 * The sum of dX and dY is equal to Speed.
 * @author Daniel and Oscar
 *
 */
public class BallModel {

	private Point BallPos = new Point(250,250);
	private final double StartSpeed = 0.2;
	private double Speed = StartSpeed;
	private double dX = Speed;
	private double dY = 0.0;
	private double Angle = 0;
	
	/**
	 * Standard constructor of a ball.
	 */
	public BallModel(){

	}
	
	/**
	 * Method to run when the ball hits the left Bar.
	 * The Angle, dX and dY are changed depending on the value of "distance" to make the ball
	 * bounce of the bar and go in another direction.
	 * @param distance The distance in percent from the Bar's center where the ball bounced.
	 */
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
		BallPos.x = 5;
	}

	public void rightBarBounce(double distance, Dimension fieldSize) {
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
		BallPos.x = fieldSize.width - 5;
	}
	
	public Point getBallPos(){
		return BallPos;
	}
	
	public void moveBall(long delta_t){
		if(delta_t  < 1000){
			BallPos.x += dX * delta_t;
			BallPos.y += dY * delta_t;
		}
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
	
	public void setXPos(int x){
		BallPos.x = x;
	}

	public void resetBall(Dimension fieldSize) {
		BallPos.x = fieldSize.width / 2;
		BallPos.y = fieldSize.height / 2;
		Speed = StartSpeed;
		Angle = 0;
		Boolean rand = new Random().nextBoolean();
		if(rand) dX = Speed; else dX = -1 * Speed;
		dY = 0;
	}
	
	public void increaseSpeed(double increaseWith) {
		Speed += increaseWith;
	}
	
	public double getSpeed(){
		return Speed;
	}
	
}
 