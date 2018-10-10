package ru.vyacheslav.andrdgb.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.vyacheslav.andrdgb.base.Sprite;
import ru.vyacheslav.andrdgb.math.Rect;


public class Background extends Sprite {
    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}