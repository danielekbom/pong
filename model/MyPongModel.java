package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Set;

import view.PongView;
import model.Input.Dir;

public class MyPongModel implements PongModel{

	private final double SpeedIncreaseStep = 0.05;
	private final double MaxSpeed = 0.5;
	private PlayerModel LeftPlayer;
	private PlayerModel RightPlayer;
	private final Dimension FieldSize = new Dimension(500, 500);
	private String Message;
	private BarModel LeftBar;
	private BarModel RightBar;
	private BallModel Ball = new BallModel();
	private boolean GameWon = false;
	
	public MyPongModel(String leftPlayer, String rightPlayer){
		LeftPlayer = new PlayerModel(leftPlayer);
		RightPlayer = new PlayerModel(rightPlayer);
		Message = LeftPlayer.getName() + " vs. " + RightPlayer.getName();
		LeftBar = new BarModel(LeftPlayer);
		RightBar = new BarModel(RightPlayer);
	}

	@Override
	public void compute(Set<Input> inputs, long delta_t) {
		if(!GameWon){
			for(Input input : inputs){
				if(input.dir == Dir.DOWN && input.key == BarKey.LEFT) LeftBar.moveDown(delta_t, FieldSize);
				if(input.dir == Dir.UP && input.key == BarKey.LEFT) LeftBar.moveUp(delta_t);
				if(input.dir == Dir.DOWN && input.key == BarKey.RIGHT) RightBar.moveDown(delta_t, FieldSize);
				if(input.dir == Dir.UP && input.key == BarKey.RIGHT) RightBar.moveUp(delta_t);
			}
			Ball.moveBall(delta_t);
			handleCollisions();
			checkForGoal();
			checkForWinner();
		}else{
			ifGameWon();
		}
	}
	
	private void ifGameWon() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Message = LeftPlayer.getName() + " vs. " + RightPlayer.getName();
		LeftBar.getPlayer().resetScore();
		RightBar.getPlayer().resetScore();
		Ball.resetBall(FieldSize);
		GameWon = false;
	}

	private void checkForWinner() {
		if(LeftBar.getPlayer().getScore() == 10){
			winnerFound(LeftBar.getPlayer());
		}else if(RightBar.getPlayer().getScore() == 10){
			winnerFound(RightBar.getPlayer());
		}
	}

	private void winnerFound(PlayerModel player) {
		Message = "The winner is: " + player.getName();
		LeftBar.resetBar();
		RightBar.resetBar();
		GameWon = true;
	}

	public void handleCollisions(){
		if(
			(Ball.getBallPos().x < 5) &&
			(Ball.getBallPos().y > LeftBar.getYPosition() - LeftBar.getWidth() / 2) && 
			(Ball.getBallPos().y < LeftBar.getYPosition() + LeftBar.getWidth() / 2)){
				if(Ball.getSpeed() < MaxSpeed) Ball.increaseSpeed(SpeedIncreaseStep);
				Ball.leftBarBounce((double)(Ball.getBallPos().y - LeftBar.getYPosition()) / (LeftBar.getWidth() / 2));
		}
		if(
			(Ball.getBallPos().x > FieldSize.width - 5) &&
			(Ball.getBallPos().y > RightBar.getYPosition() - RightBar.getWidth() / 2) && 
			(Ball.getBallPos().y < RightBar.getYPosition() + RightBar.getWidth() / 2)){
			if(Ball.getSpeed() < MaxSpeed) Ball.increaseSpeed(SpeedIncreaseStep);
				Ball.rightBarBounce((double)(Ball.getBallPos().y - RightBar.getYPosition()) / (RightBar.getWidth() / 2), FieldSize);
		}
		if(Ball.getBallPos().y < 5){
			Ball.setYPos(5);
			Ball.setYSpeed(-1 * Ball.getYSpeed());
		}
		if(Ball.getBallPos().y > (FieldSize.height - 5)){
			Ball.setYPos(FieldSize.height - 5);
			Ball.setYSpeed(-1 * Ball.getYSpeed());
		}
	}
	
	private void checkForGoal(){
		if(Ball.getBallPos().x < - 20 && Ball.getBallPos().x > - 30){
			RightBar.getPlayer().increaseScore();
			RightBar.decreaseWidth(10);
			LeftBar.resetY();
			RightBar.resetY();
			Ball.resetBall(FieldSize);
		}else if (Ball.getBallPos().x > FieldSize.width + 20 && Ball.getBallPos().x < FieldSize.width + 30){
			LeftBar.getPlayer().increaseScore();
			LeftBar.decreaseWidth(10);
			LeftBar.resetY();
			RightBar.resetY();
			Ball.resetBall(FieldSize);
		}
	}

	@Override
	public int getBarPos(BarKey k) {
		if(k == BarKey.LEFT){
			return LeftBar.getYPosition();
		}
		return RightBar.getYPosition();
	}

	@Override
	public int getBarHeight(BarKey k) {
		if(k == BarKey.LEFT){
			return LeftBar.getWidth();
		}
		return RightBar.getWidth();
	}

	@Override
	public Point getBallPos() {
		return Ball.getBallPos();
	}

	@Override
	public String getMessage() {
		return Message;
	}
	
	public void setMessage(String message) {
		this.Message = message;
	}

	@Override
	public String getScore(BarKey k) {
		if(k == BarKey.LEFT){
			return String.valueOf(LeftBar.getPlayer().getScore());
		}
		return String.valueOf(RightBar.getPlayer().getScore());
	}

	@Override
	public Dimension getFieldSize() {
		return this.FieldSize;
	}
}
