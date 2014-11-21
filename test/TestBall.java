package test;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Point;

import model.BallModel;

import org.junit.Test;

public class TestBall {
	private BallModel testBall = new BallModel();
	private final Dimension FieldSize = new Dimension(500, 500);

	@Test
	public void testBallPosition() {
		Point startPoint = new Point(250,250);
		Point ballPoint = testBall.getBallPos();
		assertEquals(ballPoint, startPoint);
	}
	@Test
	public void testBallXSpeed() {
		assertEquals(testBall.getXSpeed(), 0.2, 0.01);
		testBall.setXSpeed(0.5);
		assertEquals(testBall.getXSpeed(), 0.5, 0.01);
		testBall.setXSpeed(-0.5);
		assertEquals(testBall.getXSpeed(), -0.5, 0.01);
	}
	
	@Test
	public void testBallYSpeed() {
		assertEquals(testBall.getYSpeed(), 0.0, 0.01);
		testBall.setYSpeed(0.5);
		assertEquals(testBall.getYSpeed(), 0.5, 0.01);
		testBall.setYSpeed(-0.5);
		assertEquals(testBall.getYSpeed(), -0.5, 0.01);
	}
	
	@Test
	public void testBallIncreaseSpeed() {
		double speed = testBall.getSpeed();
		testBall.increaseSpeed(0.2);
		assertEquals(testBall.getSpeed(), speed+0.2, 0.01);
		testBall.increaseSpeed(0.2);
		assertEquals(testBall.getSpeed(), speed+0.4, 0.01);
		testBall.increaseSpeed(-0.4);
		assertEquals(testBall.getSpeed(), speed, 0.01);
	}
	
	@Test
	public void testBallResetBall() {
		testBall.increaseSpeed(0.2);
		testBall.resetBall(FieldSize);
		assertEquals(testBall.getSpeed(), 0.2, 0.01); // Back to start speed
		Point startPoint = new Point(250,250);
		Point ballPoint = testBall.getBallPos();
		assertEquals(ballPoint, startPoint); // Back to start position
	}
	
	@Test
	public void testBallMove() {
		testBall.resetBall(FieldSize);
		Point expectedPoint1 = new Point(251,251);
		testBall.setXSpeed(0.1);
		testBall.setYSpeed(0.1);
		testBall.moveBall(10);
		Point ballPoint1 = testBall.getBallPos();
		assertEquals(expectedPoint1, ballPoint1);
		
		Point expectedPoint2 = new Point(250,250);
		testBall.setXSpeed(-0.1);
		testBall.setYSpeed(-0.1);
		testBall.moveBall(10);
		Point ballPoint2 = testBall.getBallPos();
		assertEquals(expectedPoint2, ballPoint2);
	}
	
	@Test
	public void testBallLeftBarBounce() {
		// Straight bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(-0.2);
		testBall.leftBarBounce(0.0);
		assertEquals(0.2, testBall.getXSpeed(), 0.1);
		
		// 20 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(-0.2);
		testBall.leftBarBounce(0.3);
		// dX = Math.cos(20) * -0.2 *-1 = 0.187939...
		assertEquals(0.187939, testBall.getXSpeed(), 0.005);
		// dY = Math.sin(Angle) * Speed *-1;
		assertEquals(0.068404, testBall.getYSpeed(), 0.005);
		
		// 40 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(-0.2);
		testBall.leftBarBounce(0.5);
		assertEquals(0.153209, testBall.getXSpeed(), 0.005);
		assertEquals(0.128558, testBall.getYSpeed(), 0.005);
		
		// 60 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(-0.2);
		testBall.leftBarBounce(0.7);
		assertEquals(0.1, testBall.getXSpeed(), 0.005);
		assertEquals(0.173205, testBall.getYSpeed(), 0.005);
		
		// 80 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(-0.2);
		testBall.leftBarBounce(0.9);
		assertEquals(0.034729, testBall.getXSpeed(), 0.005);
		assertEquals(0.196962, testBall.getYSpeed(), 0.005);
		
		// 280 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(-0.2);
		testBall.leftBarBounce(-0.9);
		assertEquals(0.034729, testBall.getXSpeed(), 0.005);
		assertEquals(-0.196962, testBall.getYSpeed(), 0.005);
		
		// 300 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(-0.2);
		testBall.leftBarBounce(-0.7);
		assertEquals(0.1, testBall.getXSpeed(), 0.005);
		assertEquals(-0.173205, testBall.getYSpeed(), 0.005);
		
		// 320 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(-0.2);
		testBall.leftBarBounce(-0.5);
		assertEquals(0.153209, testBall.getXSpeed(), 0.005);
		assertEquals(-0.128558, testBall.getYSpeed(), 0.005);
		
		// 340 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(-0.2);
		testBall.leftBarBounce(-0.3);
		assertEquals(0.187939, testBall.getXSpeed(), 0.005);
		assertEquals(-0.068404, testBall.getYSpeed(), 0.005);
	}
	
	@Test
	public void testBallRightBarBounce() {
		// Straight bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(0.2);
		testBall.rightBarBounce(0.0, FieldSize);
		assertEquals(-0.2, testBall.getXSpeed(), 0.001);
		
		// 160 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(0.2);
		testBall.rightBarBounce(0.3, FieldSize);
		// dX = Math.cos(20) * 0.2 = 0.187939...
		assertEquals(-0.187939, testBall.getXSpeed(), 0.005);
		// dY = Math.sin(Angle) * Speed;
		assertEquals(0.068404, testBall.getYSpeed(), 0.005);
		
		// 140 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(0.2);
		testBall.rightBarBounce(0.5, FieldSize);
		assertEquals(-0.153209, testBall.getXSpeed(), 0.005);
		assertEquals(0.128558, testBall.getYSpeed(), 0.005);
		
		// 120 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(0.2);
		testBall.rightBarBounce(0.7, FieldSize);
		assertEquals(-0.1, testBall.getXSpeed(), 0.005);
		assertEquals(0.173205, testBall.getYSpeed(), 0.005);
		
		// 100 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(0.2);
		testBall.rightBarBounce(0.9, FieldSize);
		assertEquals(-0.034729, testBall.getXSpeed(), 0.005);
		assertEquals(0.196962, testBall.getYSpeed(), 0.005);
		
		// 260 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(0.2);
		testBall.rightBarBounce(-0.9, FieldSize);
		assertEquals(-0.034729, testBall.getXSpeed(), 0.005);
		assertEquals(-0.196962, testBall.getYSpeed(), 0.005);
		
		// 240 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(0.2);
		testBall.rightBarBounce(-0.7, FieldSize);
		assertEquals(-0.1, testBall.getXSpeed(), 0.005);
		assertEquals(-0.173205, testBall.getYSpeed(), 0.005);
		
		// 220 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(0.2);
		testBall.rightBarBounce(-0.5, FieldSize);
		assertEquals(-0.153209, testBall.getXSpeed(), 0.005);
		assertEquals(-0.128558, testBall.getYSpeed(), 0.005);
		
		// 200 degree bounce
		testBall.resetBall(FieldSize);
		testBall.setXSpeed(0.2);
		testBall.rightBarBounce(-0.3, FieldSize);
		assertEquals(-0.187939, testBall.getXSpeed(), 0.005);
		assertEquals(-0.068404, testBall.getYSpeed(), 0.005);
	}
}
