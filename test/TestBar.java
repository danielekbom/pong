package test;

import static org.junit.Assert.*;

import java.awt.Dimension;

import model.BarModel;
import model.PlayerModel;

import org.junit.Test;

public class TestBar {
	private final int startingWidth = 150;
	private final int StartingY = 250;
	
	private PlayerModel testPlayer1 = new PlayerModel("Player 1");
	private PlayerModel testPlayer2 = new PlayerModel("Player 2");
	
	private BarModel testBar1 = new BarModel(testPlayer1);
	private BarModel testBar2 = new BarModel(testPlayer2);
	
	private final Dimension FieldSize = new Dimension(500, 500);

	@Test
	public void testBarWidth() {
		assertEquals(testBar1.getWidth(), startingWidth);
		assertTrue(testBar1.setWidth(200));
		assertEquals(testBar1.getWidth(), 200);
		assertFalse(testBar1.setWidth(0));
		assertEquals(testBar1.getWidth(), 200);
		assertFalse(testBar1.setWidth(-150));
		assertEquals(testBar1.getWidth(), 200);
		
		testBar1.decreaseWidth(50);
		assertEquals(testBar1.getWidth(), 150);
		testBar1.decreaseWidth(100);
		assertEquals(testBar1.getWidth(), 50);
		
		assertTrue(testBar1.setWidth(200));
		testBar1.decreaseWidth(175);
		assertEquals(testBar1.getWidth(), 50);
	}
	
	@Test
	public void testBarGetPlayer() {
		assertTrue(testBar1.getPlayer() == testPlayer1);
		assertTrue(testBar2.getPlayer() == testPlayer2);
		assertFalse(testBar2.getPlayer() == testPlayer1);
	}
	
	@Test
	public void testBarYPosition () {
		assertEquals(testBar1.getYPosition(), 250);
		testBar1.setYPosition(200);
		assertEquals(testBar1.getYPosition(), 200);
		testBar1.setYPosition(0);
		assertEquals(testBar1.getYPosition(), 0);
		testBar1.setYPosition(-200);
		assertEquals(testBar1.getYPosition(), 0);
	}
	
	@Test
	public void testBarReset() {
		testBar1.resetBar();
		assertEquals(startingWidth, testBar1.getWidth());
		assertEquals(StartingY, testBar1.getYPosition());
	}
	
	@Test
	public void testBarMoveUp () {
		testBar2.resetBar();
		assertEquals(testBar2.getYPosition(), StartingY);
		testBar2.moveUp(10);
		assertEquals(testBar2.getYPosition(), StartingY - 2);
		testBar2.moveUp(100);
		assertEquals(testBar2.getYPosition(), StartingY - 2 -20);
		testBar2.moveUp(-100);
		assertEquals(testBar2.getYPosition(), StartingY - 2 -20);
		testBar2.moveUp(0);
		assertEquals(testBar2.getYPosition(), StartingY - 2 -20);
	}
	
	@Test
	public void testBarMoveDown () {
		testBar1.resetBar();
		assertEquals(testBar1.getYPosition(), StartingY);
		testBar2.moveDown(10, FieldSize);
		assertEquals(testBar2.getYPosition(), StartingY + 2);
		testBar2.moveDown(100, FieldSize);
		assertEquals(testBar2.getYPosition(), StartingY + 2 + 20);
		testBar2.moveDown(0, FieldSize);
		assertEquals(testBar2.getYPosition(), StartingY + 2 + 20);
		testBar2.moveDown(-100, FieldSize);
		assertEquals(testBar2.getYPosition(), StartingY + 2 + 20);
	}
}
