package br.com.gigio.javarobot.domain;

import java.io.Serializable;

public class Key extends GenericStep implements Serializable, RobotStep{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4207340328501203776L;
	private Integer code;
	
	public Key() {
	}
	
	public Key(Integer code){
		 this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "{\"code\":" + code + "}";
	}

	public void execute() {
		getRobot().keyPress(code);
		getRobot().delay(500);
	}

}