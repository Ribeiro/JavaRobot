package br.com.gigio.javarobot.domain;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.List;

import br.com.gigio.javarobot.handler.ScriptFileHandler;


public class JavaRobot {
	
	private Robot robot;
	private List<RobotStep> robotSteps;
	
	public JavaRobot(File scriptFile){
		try {
			this.robot = new Robot();
			this.robot.setAutoDelay(40);
			this.robot.setAutoWaitForIdle(true);
			this.robotSteps = ScriptFileHandler.readFrom(scriptFile, robot);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void execute() {
		for (RobotStep step : robotSteps) {
			step.execute();
		}
	}

}