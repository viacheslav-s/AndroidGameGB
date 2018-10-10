package ru.vyacheslav.andrdgb;

import com.badlogic.gdx.Game;

import ru.vyacheslav.andrdgb.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}

}
