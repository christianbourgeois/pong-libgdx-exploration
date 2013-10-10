package org.example.pong.core.module;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.FPSLogger;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import org.example.pong.core.BaseScreen;
import org.example.pong.core.PongInputProcessor;
import org.example.pong.core.PongScreen;
import org.example.pong.core.SimplePong;
import org.example.pong.screens.MainScreen;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = SimplePong.class, library = true)
public class PongModule {

    @Provides
    public SimplePong providePong(@Named("main") BaseScreen firstScreen) {
        return new SimplePong(firstScreen);
    }

    @Provides @Named("main")
    public BaseScreen provideMainScreen() {
        return new MainScreen();
    }

    @Provides
    public PongScreen providePongScreen(Bus bus) {
        return new PongScreen(bus);
    }

    @Provides @Singleton
    public Bus provideBus() {
        return new Bus(ThreadEnforcer.ANY);
    }

    @Provides
    public InputProcessor provideInputProcessor(Bus bus) {
        return new PongInputProcessor(bus);
    }

    @Provides
    public FPSLogger providePFSLogger() {
        return new FPSLogger();
    }
}
