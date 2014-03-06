package br.com.gigio.javarobot.domain;

import java.awt.Robot;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.gigio.javarobot.exception.RobotBuilderException;

public final class RobotStepBuilder {
	private static final ObjectMapper mapper = new ObjectMapper();

	private RobotStepBuilder() {
	}

	public static RobotStep buildFrom(String line, Robot robot) {
		RobotStep step = null;
		try {
			if (line.contains("Axis")) {
				step =  mapper.readValue(line, Coordinate.class);
			} else if (line.contains("code")) {
				step = mapper.readValue(line, Key.class);
			}
			step.with(robot);
		} catch (Exception e) {
			throw new RobotBuilderException(e);
		}
		return step;
	}
}
