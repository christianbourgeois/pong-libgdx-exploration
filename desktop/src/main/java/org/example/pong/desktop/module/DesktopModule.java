package org.example.pong.desktop.module;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import org.example.pong.core.SimplePong;
import org.example.pong.core.module.PongModule;
import org.example.pong.desktop.DesktopLauncher;

import dagger.Module;
import dagger.Provides;

@Module(includes = PongModule.class, injects = DesktopLauncher.class, library = true)
public class DesktopModule {

    private static final String APPLICATION_NAME = "Pong";

    @Provides
    public DesktopLauncher provideLauncher(SimplePong pong, LwjglApplicationConfiguration configuration) {
        return new DesktopLauncher(pong, configuration);
    }

    @Provides
    public LwjglApplicationConfiguration provideConfiguration() {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = APPLICATION_NAME;
        config.useGL20 = true;
        {
            /** set resolution here */
            int i = 0;
            boolean isLandscape = true;

            int[][] res = new int[8][];
            res[0] = new int[] { 320, 240 };
            res[1] = new int[] { 480, 320 };
            res[2] = new int[] { 720, 480 };
            res[3] = new int[] { 800, 480 };
            res[4] = new int[] { 854, 480 };
            res[5] = new int[] { 1024, 600 };
            res[6] = new int[] { 1280, 768 };
            res[7] = new int[] { 1280, 800 };

            config.width = res[i][isLandscape ? 0 : 1];
            config.height = res[i][isLandscape ? 1 : 0];
        }
        return config;
    }
}
