package org.example.pong.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

public class SimplePong extends Game {
	
	public static final int DEFAULT_WIDTH = 480;
	public static final int DEFAULT_HEIGHT = 320;

    private FPSLogger fpsLogger;

    @Override
    public void create() {
        this.fpsLogger = new FPSLogger();
        Gdx.input.setInputProcessor(new PongInputProcessor());

        this.setScreen(new PongScreen(this));
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
