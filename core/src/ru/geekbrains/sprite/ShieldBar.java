package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class ShieldBar extends Sprite {

    private Rect worldBounds;

    public ShieldBar(TextureRegion region, Rect worldBounds) {
        super(region);
        this.worldBounds = worldBounds;
    }
    void setSize(int count) {
        this.halfHeight = (float) 0.5;
        this.halfWidth = (float) 7.0 * ((10f - (float) count)/10f);
        setTop(worldBounds.getTop() - 3f);
    }
}
