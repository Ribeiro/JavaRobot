package br.com.gigio.javarobot.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.List;

import br.com.gigio.javarobot.domain.RobotStep;
import br.com.gigio.javarobot.handler.ScriptFileHandler;

public class JavaRobotReadingTest {
	private static final String BASE_DIR = "scripts/";
	
	public static void main(String[] args) throws IOException, AWTException {
		
		File robotScriptFile = new File(BASE_DIR.concat("script_writing.txt"));
		Robot robot = new Robot();
		List<RobotStep> steps = ScriptFileHandler.readFrom(robotScriptFile, robot);
		
		for (RobotStep robotStep : steps) {
			System.out.println(robotStep);
		}
	}
}
