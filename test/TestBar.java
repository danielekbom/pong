package test;

import static org.junit.Assert.*;

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
	}
}
