package org.example.pong.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.FPSLogger;

import org.example.pong.core.module.PongModule;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class SimplePong extends Game {
	
	public static final int VIRTUAL_WIDTH = 480;
	public static final int VIRTUAL_HEIGHT = 320;

    @Inject
    FPSLogger fpsLogger;

    @Inject
    InputProcessor inputProcessor;

    @Inject
    PongScreen pongScreen;

    @Override
    public void create() {
        ObjectGraph objectGraph = ObjectGraph.create(new PongModule());
        objectGraph.inject(this);

        Gdx.input.setInputProcessor(this.inputProcessor);
        this.setScreen(this.pongScreen);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    public void render() {
        super.render();
        this.fpsLogger.log();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
