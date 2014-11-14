package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Set;

import view.PongView;
import model.Input.Dir;

public class MyPongModel implements PongModel{

	private String LeftPlayer;
	private String RightPlayer;
	private final Dimension FieldSize = new Dimension(500, 500);
	private String Message;
	private BarModel LeftBar = new BarModel(50);
	private BarModel RightBar = new BarModel(50);
	private BallModel Ball = new BallModel();
	
	public MyPongModel(String LeftPlayer, String RightPlayer){
		this.LeftPlayer = LeftPlayer;
		this.RightPlayer = RightPlayer;
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
	}
	
	public void handleCollisions(){
		if(
			(Ball.getBallPos().x < 5) &&
			(Ball.getBallPos().y > LeftBar.getYPosition() - LeftBar.getWidth() / 2) && 
			(Ball.getBallPos().y < LeftBar.getYPosition() + LeftBar.getWidth() / 2)){
				Ball.setXSpeed(-1 * Ball.getXSpeed());
				Ball.setYSpeed((Ball.getBallPos().y - LeftBar.getYPosition()) / 30);
		}
		if(
			(Ball.getBallPos().x > FieldSize.width - 5) &&
			(Ball.getBallPos().y > RightBar.getYPosition() - RightBar.getWidth() / 2) && 
			(Ball.getBallPos().y < RightBar.getYPosition() + RightBar.getWidth() / 2)){
				Ball.setXSpeed(-1 * Ball.getXSpeed());
				Ball.setYSpeed((Ball.getBallPos().y - RightBar.getYPosition()) / 30);
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
		return "328942384";
	}

	@Override
	public Dimension getFieldSize() {
		return this.FieldSize;
	}
}
