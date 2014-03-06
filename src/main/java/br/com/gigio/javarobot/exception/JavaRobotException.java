package br.com.gigio.javarobot.exception;

public class JavaRobotException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8218562699356327287L;

	public JavaRobotException(String message, Throwable cause) {
		super(message, cause);
	}

	public JavaRobotException(Throwable cause) {
		super(cause);
	}

}
