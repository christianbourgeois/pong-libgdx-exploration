package org.example.pong.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Styles {

    public void styleSkin(Skin skin, TextureAtlas atlas) {
        BitmapFont[] fonts = this.createTTFFonts("data/prototype.ttf", new int[] {15, 30});

        skin.add("default", fonts[0]);

        skin.add("default", labelStyle(fonts[0]));
        skin.add("font-15", labelStyle(fonts[0]));
        skin.add("font-30", labelStyle(fonts[1]));

        TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();
        tbs.font = fonts[0];
        skin.add("default", tbs);
    }

    private BitmapFont[] createTTFFonts(String path, int[] sizes) {
        FreeTypeFontGenerator generator = null;
        BitmapFont[] bitmapFonts = new BitmapFont[sizes.length];
        try {
            generator = new FreeTypeFontGenerator(Gdx.files.internal(path));
            for(int i = 0; i < sizes.length; i++) {
                bitmapFonts[i] = generator.generateFont(sizes[i]);
            }
            return bitmapFonts;
        } finally {
            if (generator != null) {
                generator.dispose();
            }
        }
    }

    private Label.LabelStyle labelStyle(BitmapFont bitmapFont) {
        Label.LabelStyle lbs = new Label.LabelStyle();
        lbs.font = bitmapFont;
        return lbs;
    }
}
