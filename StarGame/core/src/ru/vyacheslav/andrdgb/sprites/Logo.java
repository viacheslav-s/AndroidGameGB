package ru.vyacheslav.andrdgb.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.vyacheslav.andrdgb.base.Sprite;

public class Logo extends Sprite {
    public Logo(TextureAtlas atlas) {
        super(atlas.findRegion("logo"));
        setHeightProportion(0.22f);
        setBottom(0.1f);
    }
}
