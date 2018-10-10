package ru.vyacheslav.andrdgb.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.vyacheslav.andrdgb.base.ActionListener;
import ru.vyacheslav.andrdgb.sprites.Background;
import ru.vyacheslav.andrdgb.base.Base2DScreen;
import ru.vyacheslav.andrdgb.math.Rect;
import ru.vyacheslav.andrdgb.sprites.ButtonExit;
import ru.vyacheslav.andrdgb.sprites.ButtonPlay;
import ru.vyacheslav.andrdgb.sprites.Logo;
import ru.vyacheslav.andrdgb.sprites.Star;


public class MenuScreen extends Base2DScreen implements ActionListener {

    private static final int STAR_COUNT = 200;

    Background background;
    Texture bg;
    TextureAtlas atlas;

    Logo logo;
    ButtonExit buttonExit;
    ButtonPlay buttonPlay;

    Star[] star;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("bg.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        logo = new Logo(atlas);
        buttonExit = new ButtonExit(atlas, this);
        buttonPlay = new ButtonPlay(atlas, this);
        star = new Star[STAR_COUNT];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(atlas);
        }
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    public void update(float delta) {
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
    }

    public void draw() {
        Gdx.gl.glClearColor(1, 0.4f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        logo.draw(batch);
        buttonExit.draw(batch);
        buttonPlay.draw(batch);
        batch.end();
    }


    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
//        logo.resize(worldBounds);
        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        buttonExit.touchDown(touch, pointer);
        buttonPlay.touchDown(touch, pointer);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        buttonExit.touchUp(touch, pointer);
        buttonPlay.touchUp(touch, pointer);
        return super.touchUp(touch, pointer);
    }

    @Override
    public void actionPerformed(Object src) {
        if (src == buttonExit) {
            Gdx.app.exit();
        } else if (src == buttonPlay) {
            game.setScreen(new GameScreen(game));
        }
    }
}