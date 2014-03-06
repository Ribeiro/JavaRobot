package br.com.gigio.javarobot.main;

import java.io.File;

import br.com.gigio.javarobot.domain.JavaRobot;

public class JavaRobotExecutionTest {
	private static final String BASE_DIR = "scripts/";
	
	public static void main(String[] args) {
		File robotScriptFile = new File(BASE_DIR.concat("script_notepad.txt"));
		JavaRobot javaRobot = new JavaRobot(robotScriptFile);
		javaRobot.execute();
	}
}
