package ru.vyacheslav.andrdgb.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.vyacheslav.andrdgb.base.ActionListener;
import ru.vyacheslav.andrdgb.base.ScaledTouchUpButton;
import ru.vyacheslav.andrdgb.math.Rect;

public class ButtonExit extends ScaledTouchUpButton {

    public ButtonExit(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("btExit"), actionListener, 0.9f);
        setHeightProportion(0.07f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom() + 0.1f);
        setWidth(worldBounds.getHalfWidth());
    }
}