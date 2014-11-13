package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Set;

import view.PongView;
import model.Input.Dir;

public class MyPongModel implements PongModel{

	private String LeftPlayer;
	private String RightPlayer;
	private final Dimension FieldSize = new Dimension(200, 200);
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
			if(input.dir == Dir.DOWN && input.key == BarKey.LEFT) LeftBar.moveDown();
			if(input.dir == Dir.UP && input.key == BarKey.LEFT) LeftBar.moveUp();
			if(input.dir == Dir.DOWN && input.key == BarKey.RIGHT) RightBar.moveDown();
			if(input.dir == Dir.UP && input.key == BarKey.RIGHT) RightBar.moveUp();
		}
		
		Ball.moveBall();
	}

	@Override
	public int getBarPos(BarKey k) {
		if(k == BarKey.LEFT){
			return LeftBar.getXPosition();
		}
		return RightBar.getXPosition();
	}

	@Override
	public int getBarHeight(BarKey k) {
		return 50;
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
