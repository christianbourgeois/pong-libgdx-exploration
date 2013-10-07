package org.example.pong.core.com.example.pong.core.events;

public class TouchEvent {

    private final int screenX;

    private final int screenY;

    private final int pointer;

    private final int button;

    public TouchEvent(int screenX, int screenY, int pointer, int button) {
        super();
        this.screenX = screenX;
        this.screenY = screenY;
        this.pointer = pointer;
        this.button = button;
    }

    public int getScreenX() {
        return this.screenX;
    }

    public int getScreenY() {
        return this.screenY;
    }

    public int getPointer() {
        return this.pointer;
    }

    public int getButton() {
        return this.button;
    }
}
