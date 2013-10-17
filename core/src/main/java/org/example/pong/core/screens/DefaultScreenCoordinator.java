package org.example.pong.core.screens;

import org.example.pong.core.BaseScreen;
import org.example.pong.core.ScreenCoordinator;

public class DefaultScreenCoordinator implements ScreenCoordinator {

    private final BaseScreen firstScreen;

    public DefaultScreenCoordinator(final BaseScreen firstScreen) {
        super();
        this.firstScreen = firstScreen;
    }

    @Override
    public BaseScreen getFirstScreen() {
        return this.firstScreen;
    }
}
