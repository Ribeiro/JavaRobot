package br.com.gigio.javarobot.listeners;

import java.io.File;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import br.com.gigio.javarobot.domain.Coordinate;
import br.com.gigio.javarobot.handler.ScriptFileHandler;

public class GlobalMouseListener extends GenericListener implements NativeMouseListener{
	
	
	public GlobalMouseListener(File file){
		super(file);	
	}

	public void nativeMouseClicked(NativeMouseEvent mouseEvent) {
		ScriptFileHandler.writeTo(super.getFile(), new Coordinate(mouseEvent.getX(), mouseEvent.getY()));
	}

	public void nativeMousePressed(NativeMouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

	public void nativeMouseReleased(NativeMouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}


}
