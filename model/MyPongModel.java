package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Set;

import view.PongView;
import model.Input.Dir;

public class MyPongModel implements PongModel{

	private PlayerModel LeftPlayer;
	private PlayerModel RightPlayer;
	private final Dimension FieldSize = new Dimension(500, 500);
	private String Message;
	private BarModel LeftBar;
	private BarModel RightBar;
	private BallModel Ball = new BallModel();
	
	public MyPongModel(String leftPlayer, String rightPlayer){
		LeftPlayer = new PlayerModel(leftPlayer);
		RightPlayer = new PlayerModel(rightPlayer);
		LeftBar = new BarModel(LeftPlayer, 50);
		RightBar = new BarModel(RightPlayer, 50);
	}

	@Override
	public void compute(Set<Input> inputs, long delta_t) {
		for(Input input : inputs){
			if(input.dir == Dir.DOWN && input.key == BarKey.LEFT) LeftBar.moveDown(delta_t);
			if(input.dir == Dir.UP && input.key == BarKey.LEFT) LeftBar.moveUp(delta_t);
			if(input.dir == Dir.DOWN && input.key == BarKey.RIGHT) RightBar.moveDown(delta_t);
			if(input.dir == Dir.UP && input.key == BarKey.RIGHT) RightBar.moveUp(delta_t);
		}
		handleCollisions();
		Ball.moveBall(delta_t);
		if(Ball.getBallPos().x == 10 && Ball.getXSpeed() > 0) LeftBar.getPlayer().increaseScore();
		if(Ball.getBallPos().x == FieldSize.width - 10 && Ball.getXSpeed() < 0) RightBar.getPlayer().increaseScore();
	}
	
	public void handleCollisions(){
		if(
			(Ball.getBallPos().x < 5) &&
			(Ball.getBallPos().y > LeftBar.getYPosition() - LeftBar.getWidth() / 2) && 
			(Ball.getBallPos().y < LeftBar.getYPosition() + LeftBar.getWidth() / 2)){
				Ball.leftBarBounce((double)(Ball.getBallPos().y - LeftBar.getYPosition()) / (LeftBar.getWidth() / 2));
				
		}
		if(
			(Ball.getBallPos().x > FieldSize.width - 5) &&
			(Ball.getBallPos().y > RightBar.getYPosition() - RightBar.getWidth() / 2) && 
			(Ball.getBallPos().y < RightBar.getYPosition() + RightBar.getWidth() / 2)){
				Ball.rightBarBounce((double)(Ball.getBallPos().y - RightBar.getYPosition()) / (RightBar.getWidth() / 2));
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
		return "Hej";
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
