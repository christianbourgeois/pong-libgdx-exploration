package org.example.pong.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;

import org.example.pong.core.BaseApplication;
import org.example.pong.core.BaseScreen;

public class MainScreen extends BaseScreen {

    public MainScreen(final BaseApplication application) {
        super(application);
        this.configure(this.getTable());
    }

    private void configure(final Table table) {
        final TextButton button = new TextButton("Start", this.getSkin());
        button.addListener(this.clickListener(button));
        table.defaults().pad(6f);

        Texture texture = new Texture(Gdx.files.internal("data/grass.jpg"));
        TextureRegion textureRegion = new TextureRegion(texture, 0, 0, 200, 200);
        TiledDrawable tiledDrawable = new TiledDrawable(textureRegion);
        table.setBackground(tiledDrawable);
        table.add(label("PONG", "font-30",  Color.WHITE));
        table.row();
        table.add(button);
    }

    private InputListener clickListener(final TextButton button) {
        return new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                MainScreen.this.getApplication().switchScreens(new GameScreen(MainScreen.this.getApplication()));
                button.setChecked(false);
            }
        };
    }

    @Override
    public void onBackPress() {
        Gdx.app.exit();
    }

    private Label label(String text, String fontName, Color color) {
        Label label = new Label(text, this.getSkin(), fontName);
        label.setAlignment(Align.center, Align.center);
        label.setColor(color);
        return label;
    }
}
