package test;

import static org.junit.Assert.*;

import model.PlayerModel;

import org.junit.Test;

public class TestPlayer {
	private PlayerModel testPlayer1 = new PlayerModel("Player 1");
	private PlayerModel testPlayer2 = new PlayerModel("Player 2");

	@Test
	public void testPlayerGetName() {
		assertEquals(testPlayer1.getName(), "Player 1");
		assertEquals(testPlayer2.getName(), "Player 2");
	}
	
	@Test
	public void testPlayerScore() {
		assertEquals(testPlayer1.getScore(), 0);
		assertEquals(testPlayer2.getScore(), 0);
		testPlayer1.increaseScore();
		testPlayer1.increaseScore();
		assertEquals(testPlayer1.getScore(), 2);
		assertEquals(testPlayer2.getScore(), 0);
		testPlayer2.increaseScore();
		assertEquals(testPlayer1.getScore(), 2);
		assertEquals(testPlayer2.getScore(), 1);
		testPlayer1.resetScore();
		assertEquals(testPlayer1.getScore(), 0);
		assertEquals(testPlayer2.getScore(), 1);
		testPlayer2.resetScore();
		assertEquals(testPlayer1.getScore(), 0);
		assertEquals(testPlayer2.getScore(), 0);
	}

}
