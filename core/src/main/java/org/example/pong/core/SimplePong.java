package org.example.pong.core;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import javax.inject.Inject;

public class SimplePong extends BaseApplication {

    private final BaseScreen firstScreen;

    @Inject
    public SimplePong(final BaseScreen firstScreen) {
        super();
        this.firstScreen = firstScreen;
    }
	
    @Override
    protected String atlasPath() {
        return "data/tex.atlas";
    }

    @Override
    protected void styleSkin(Skin skin, TextureAtlas atlas) {
        new Styles().styleSkin(skin, atlas);
    }

    @Override
    protected String skinPath() {
        return null;
    }

    @Override
    protected BaseScreen getFirstScreen() {
        //return new MainScreen(this);
        return this.firstScreen;
    }
}