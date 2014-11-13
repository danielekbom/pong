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
	private int LeftBarPos = 50;
	private int RightBarPos = 50;
	
	public MyPongModel(String LeftPlayer, String RightPlayer){
		this.LeftPlayer = LeftPlayer;
		this.RightPlayer = RightPlayer;
	}

	@Override
	public void compute(Set<Input> inputs, long delta_t) {
		for(Input input : inputs){
			if(input.dir == Dir.DOWN){
				setBarPos(input.key);
			}
		}
	}

	@Override
	public int getBarPos(BarKey k) {
		if(k == BarKey.LEFT){
			return LeftBarPos;
		}
		return -1;
	}
	
	public void setBarPos(BarKey k) {
		if(k == BarKey.LEFT){
			LeftBarPos += 5;
		}
	}

	@Override
	public int getBarHeight(BarKey k) {
		return 50;
	}

	@Override
	public Point getBallPos() {
		return new Point(100, 100);
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
