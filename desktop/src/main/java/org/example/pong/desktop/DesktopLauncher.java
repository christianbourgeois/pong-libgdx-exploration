package org.example.pong.desktop;

import org.example.pong.core.SimplePong;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopLauncher {
	
	private static final String APPLICATION_NAME = "Pong";

	public static void main(String[] args) {
        boolean useOpenGLES2 = true;
		new LwjglApplication(new SimplePong(), APPLICATION_NAME, SimplePong.VIRTUAL_WIDTH, SimplePong.VIRTUAL_HEIGHT, useOpenGLES2);
	}
}
