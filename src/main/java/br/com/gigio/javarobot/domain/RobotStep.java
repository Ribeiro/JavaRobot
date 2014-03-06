package br.com.gigio.javarobot.domain;

import java.awt.Robot;

public interface RobotStep {
	void execute();
	void with(Robot robot);
}
