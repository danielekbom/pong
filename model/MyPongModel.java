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
	
	public MyPongModel(String LeftPlayer, String RightPlayer){
		this.LeftPlayer = LeftPlayer;
		this.RightPlayer = RightPlayer;
	}

	@Override
	public void compute(Set<Input> input, long delta_t) {
		for(Input inputt : input){
			if(inputt.dir == Dir.DOWN){
				setMessage(null);
			}
		}
	}

	@Override
	public int getBarPos(BarKey k) {

		return 0;
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
