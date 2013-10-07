package org.example.pong.core;

import com.badlogic.gdx.InputAdapter;
import com.squareup.otto.Bus;

import org.example.pong.core.events.TouchEvent;

import javax.inject.Inject;

public class PongInputProcessor extends InputAdapter {

    private Bus bus;

    @Inject
    public PongInputProcessor(Bus bus) {
        super();
        this.bus = bus;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this.bus.post(new TouchEvent(screenX, screenY, pointer, button));
        return true;
    }
}