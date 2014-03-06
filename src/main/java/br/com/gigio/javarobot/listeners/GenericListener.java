package br.com.gigio.javarobot.listeners;

import java.io.File;

public abstract class GenericListener {

	private File file;
	
	public GenericListener(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
}
