package org.example.pong.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public abstract class BaseApplication implements ApplicationListener {

    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;

    private InputMultiplexer inputMultiplexer;

    /** the width and height of the screen */
    private float w, h;

    private BaseScreen currentScreen;
    private BaseScreen nextScreen;

    private float defaultDuration;
    private float durAccum = -420f;

    private final Color clearColor;

    public BaseApplication() {
        super();
        this.defaultDuration = 0.333f;
        this.clearColor = new Color(Color.BLACK);
        this.inputMultiplexer = new InputMultiplexer();
    }

    @Override
    public void create() {
        this.w = Gdx.graphics.getWidth();
        this.h = Gdx.graphics.getHeight();

        this.stage = new Stage(this.w, this.h, false);
        this.atlas = new TextureAtlas(this.atlasPath());
        this.skin = new Skin();
        this.skin.addRegions(this.atlas);
        String skinPath = this.skinPath();
        if (skinPath != null) {
            this.skin.load(Gdx.files.internal(skinPath));
        }
        this.styleSkin(skin, atlas);

        Gdx.input.setInputProcessor(this.stage);
        Gdx.input.setCatchBackKey(true);
        this.stage.addListener(new InputListener() {
            public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.BACK) {
                    BaseApplication.this.currentScreen.onBackPress();
                }
                return false;
            }
        });
        this.currentScreen = getFirstScreen().show();
        this.stage.addActor(this.currentScreen);
        Gdx.input.setInputProcessor(this.inputMultiplexer);
        this.inputMultiplexer.addProcessor(this.stage);
    }

    public float getWidth() {
        return this.w;
    }

    public float getHeight() {
        return this.h;
    }

    public Skin getSkin() {
        return this.skin;
    }

    public float getDefaultDuration() {
        return this.defaultDuration;
    }

    protected abstract String atlasPath();

    protected abstract void styleSkin(Skin skin, TextureAtlas atlas);

    protected abstract String skinPath();

    protected abstract BaseScreen getFirstScreen();

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        if (this.durAccum > 0f) {
            this.durAccum -= delta;
            if (this.durAccum <= 0f) {
                this.currentScreen.hide();
                this.currentScreen.remove();
                this.currentScreen = this.nextScreen;
                this.currentScreen.setTouchable(Touchable.enabled);
                this.currentScreen.setPosition(0f, 0f);
                this.nextScreen = null;
            }
        }
        Gdx.gl.glClearColor(this.clearColor.r, this.clearColor.g, this.clearColor.b, this.clearColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.stage.act(delta);
        this.stage.draw();
    }

    public void setClearColor(Color color) {
        this.clearColor.set(color);
    }

    public void switchScreens(BaseScreen screen) {
        this.durAccum = this.currentScreen.getTransitionDuration();
        this.nextScreen = screen;
        this.nextScreen.setTouchable(Touchable.disabled);
        this.nextScreen.show();
        this.stage.addActor(this.nextScreen);
        if (this.currentScreen != null) {
            this.currentScreen.screenOut();
            this.currentScreen.setTouchable(Touchable.disabled);
            this.currentScreen.toFront();
        }
    }

    @Override
    public void resize(int width, int height) {
        this.w = Gdx.graphics.getWidth();
        this.h = Gdx.graphics.getHeight();
        this.stage.setViewport(this.w, this.h, false);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        this.stage.dispose();
        this.skin.dispose();
        this.atlas.dispose();
    }
}
