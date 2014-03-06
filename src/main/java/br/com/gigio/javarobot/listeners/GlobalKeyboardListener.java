package br.com.gigio.javarobot.listeners;

import java.io.File;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import br.com.gigio.javarobot.domain.Key;
import br.com.gigio.javarobot.handler.ScriptFileHandler;

public class GlobalKeyboardListener extends GenericListener implements NativeKeyListener{
	
	public GlobalKeyboardListener(File file) {
		super(file);
	}


	public void nativeKeyPressed(NativeKeyEvent keyboardEvent) {
		ScriptFileHandler.writeTo(super.getFile(), new Key(keyboardEvent.getKeyCode()));
	}

	public void nativeKeyReleased(NativeKeyEvent keyboardEvent) {
		//System.out.println(keyboardEvent.getKeyCode());
		
	}

	public void nativeKeyTyped(NativeKeyEvent keyboardEvent) {
		//System.out.println(keyboardEvent.getKeyCode());
		
	}

}