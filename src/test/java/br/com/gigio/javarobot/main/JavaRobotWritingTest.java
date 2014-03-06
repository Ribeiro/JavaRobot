package br.com.gigio.javarobot.main;

import java.io.File;
import java.io.IOException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import br.com.gigio.javarobot.listeners.GlobalKeyboardListener;
import br.com.gigio.javarobot.listeners.GlobalMouseListener;

public class JavaRobotWritingTest {
	
	private static final String BASE_DIR = "scripts/";
	
	
	public static void main(String[] args) throws IOException {
		
		File robotScriptFile = new File(BASE_DIR.concat("script_notepad.txt"));
		
		try {
			GlobalScreen.registerNativeHook();
			
			GlobalKeyboardListener keyboardListener = new GlobalKeyboardListener(robotScriptFile);
			GlobalScreen.getInstance().addNativeKeyListener(keyboardListener);
			
			GlobalMouseListener mouseListener= new GlobalMouseListener(robotScriptFile);
			GlobalScreen.getInstance().addNativeMouseListener(mouseListener);
			
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
			System.exit(1);
		}
		
		while(true){
			
		}
		
		
	}

}
