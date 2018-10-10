package ru.vyacheslav.andrdgb.pool;

import com.badlogic.gdx.audio.Sound;

import ru.vyacheslav.andrdgb.base.SpritesPool;
import ru.vyacheslav.andrdgb.sprites.Enemy;
import ru.vyacheslav.andrdgb.math.Rect;
import ru.vyacheslav.andrdgb.sprites.MainShip;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private Sound shootSound;
    private MainShip mainShip;
    private ExplosionPool explosionPool;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Sound shootSound, MainShip mainShip) {
        this.bulletPool = bulletPool;
        this.shootSound = shootSound;
        this.mainShip = mainShip;
        this.explosionPool = explosionPool;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, explosionPool, shootSound, mainShip);
    }
}