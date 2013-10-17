package org.example.pong.desktop;

import org.example.pong.core.SimplePong;
import org.example.pong.desktop.module.DesktopModule;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class DesktopLauncher {
	
    private final SimplePong pong;

    private final LwjglApplicationConfiguration configuration;

	public static void main(String[] args) {
        ObjectGraph objectGraph = ObjectGraph.create(new DesktopModule());
        final DesktopLauncher launcher = objectGraph.get(DesktopLauncher.class);
        launcher.launch();
	}

    @Inject
    public DesktopLauncher(SimplePong pong, LwjglApplicationConfiguration configuration) {
        super();
        this.pong = pong;
        this.configuration = configuration;
    }

    private void launch() {
        new LwjglApplication(this.pong, this.configuration);
    }
}
