package com.ash.srpg;

import com.ash.srpg.screens.SplashScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MagicalAcademy extends Game {

	public static final String VERSION = "0.01 Pre-Alpha";
	public static final String LOG = "Magical Academy";

	SpriteBatch batch;

//	Texture img;
	
	@Override
	public void create () {
		setScreen(new SplashScreen(this));
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		super.render();
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
}
