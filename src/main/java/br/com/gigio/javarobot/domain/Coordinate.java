package br.com.gigio.javarobot.domain;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.Serializable;

public class Coordinate extends GenericStep implements Serializable, RobotStep{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2629206338970135392L;
	private Integer xAxis;
	private Integer yAxis;
	
	public Coordinate() {
	}
	
	public Coordinate(Integer xAxis, Integer yAxis) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
	
	public Integer getxAxis() {
		return xAxis;
	}
	
	public Integer getyAxis() {
		return yAxis;
	}

	@Override
	public String toString() {
		return "{\"xAxis\":" + xAxis + ", \"yAxis\":" + yAxis + "}";
	}

	public void execute() {
		Robot robot = getRobot();
		robot.mouseMove(xAxis, yAxis);
		robot.delay(200);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(200);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(200);
	}

}