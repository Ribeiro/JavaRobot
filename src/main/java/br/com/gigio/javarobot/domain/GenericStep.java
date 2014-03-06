package br.com.gigio.javarobot.domain;

import java.awt.Robot;

public abstract class GenericStep implements RobotStep {

	private Robot robot;

	public void with(Robot robot) {
		this.robot = robot;
	}

	public Robot getRobot() {
		return robot;
	}
}