package ru.vyacheslav.andrdgb.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.vyacheslav.andrdgb.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private SpriteBatch batch;
    private Texture spaceship;
    private Texture bg;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 dir;
    private Vector2 norDir;
    private int speed = 2;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        float invertedY = Gdx.graphics.getHeight() - screenY;
        System.out.println("touchDown screenX = " + screenX + " screenY = " + invertedY);
        dir.x = screenX;
        dir.y = invertedY;
        norDir = dir.cpy().nor();
//        v.scl(norDir);
        v.set(norDir.x * speed, norDir.y * speed);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        spaceship = new Texture("ship.png");
        bg = new Texture("bg.jpg");
        pos = new Vector2(0f, 0f);
        v = new Vector2(2f, 2f);
        dir = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(bg, 0, 0);
        batch.draw(spaceship, pos.x, pos.y);
        batch.end();
        pos.add(v);
    }

    @Override
    public void dispose() {
        batch.dispose();
        bg.dispose();
        spaceship.dispose();
        super.dispose();
    }
}
