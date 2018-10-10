package ru.vyacheslav.andrdgb.pool;

import ru.vyacheslav.andrdgb.base.SpritesPool;
import ru.vyacheslav.andrdgb.sprites.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

    @Override
    protected void log() {
        System.out.println("Bullet active/free: " + activeObjects.size() + "/" + freeObjects.size());
    }
}