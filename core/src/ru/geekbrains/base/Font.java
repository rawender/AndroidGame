package ru.geekbrains.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class Font extends BitmapFont {

    public Font(String fontFile, String region) {
        super(Gdx.files.internal(fontFile), Gdx.files.internal(region), false, false);
        getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public void setSize(float size) {
        getData().setScale(size / getCapHeight());
    }

    public GlyphLayout draw(Batch batch, CharSequence str, float x, float y, int hAlign) {
        return super.draw(batch, str, x, y, 0f, hAlign, false);
    }
}
