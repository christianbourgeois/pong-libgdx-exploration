package org.example.pong.core;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class BaseScreen extends Group {

    private final BaseApplication application;

    /** table that covers the whole screen by default */
    private final Table table = new Table();

    /** the default padding of the mainTable */
    private float defaultPadding;

    /** the duration of the screen transition for the screenOut method */
    private float duration;

    public BaseScreen(BaseApplication application) {
        super();
        this.application = application;
        this.duration = application.getDefaultDuration();
        this.defaultPadding = Math.round(Math.max(this.application.getHeight(), this.application.getWidth()) * .02f);
        this.table.defaults().pad(this.defaultPadding);
        this.table.size(this.application.getWidth(), this.application.getHeight());
        this.addActor(this.table);
    }

    public abstract void onBackPress();

    public BaseScreen show() {
        return this;
    }

    public void hide() {}

    protected void screenOut() {
        float xPos = -this.application.getWidth();
        MoveToAction action = Actions.moveTo(xPos, 0f, this.duration);
        addAction(action);
    }

    public float getTransitionDuration() {
        return this.duration;
    }

    protected Table getTable() {
        return this.table;
    }

    protected BaseApplication getApplication() {
        return this.application;
    }

    protected Skin getSkin() {
        return this.application.getSkin();
    }
}
