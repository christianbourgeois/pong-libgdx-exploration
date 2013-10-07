package org.example.pong.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class PongInputProcessor extends InputAdapter {

    public PongInputProcessor() {
        super();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("TOUCH", "" + screenX);
        return true;
    }


}
