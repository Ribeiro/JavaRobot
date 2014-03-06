package br.com.gigio.javarobot.handler;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import br.com.gigio.javarobot.domain.RobotStep;
import br.com.gigio.javarobot.domain.RobotStepBuilder;
import br.com.gigio.javarobot.exception.ScriptFileHandlerException;

public final class ScriptFileHandler {
	private ScriptFileHandler() {
	}

	public static List<RobotStep> readFrom(File file, Robot robot) {
		List<RobotStep> steps = new ArrayList<RobotStep>();
		try {
			List<String> lines = FileUtils
					.readLines(file, Charset.defaultCharset());
			for (String line : lines) {
				steps.add(RobotStepBuilder.buildFrom(line, robot));
			}
		} catch (Exception ex) {
			throw new ScriptFileHandlerException(ex);
		}
		
		return steps;
	}
	
	public static void writeTo(File file, RobotStep step) {
		try {
			FileUtils.writeStringToFile(file, step.toString()+"\n", true);
			System.out.println(step.toString());
		} catch (IOException e) {
			throw new ScriptFileHandlerException(e);
		}
	}
}
