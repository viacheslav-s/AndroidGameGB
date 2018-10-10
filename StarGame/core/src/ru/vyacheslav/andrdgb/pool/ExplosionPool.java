package ru.vyacheslav.andrdgb.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.vyacheslav.andrdgb.base.SpritesPool;
import ru.vyacheslav.andrdgb.sprites.Explosion;

public class ExplosionPool extends SpritesPool<Explosion> {

    private final TextureRegion textureRegion;

    private Sound explosionSound;

    public ExplosionPool(TextureAtlas atlas, Sound explosionSound) {
        this.textureRegion = atlas.findRegion("explosion");
        this.explosionSound = explosionSound;
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(textureRegion, 9, 9, 74, explosionSound);

    }
}