package com.ash.srpg;

import com.ash.srpg.screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MagicalAcademy extends Game {
    public static final String VERSION = "0.01 Pre-Alpha";
    public static final String LOG = "Magical Academy";
    SpriteBatch batch;

    public MagicalAcademy() {
    }

    public void create() {
        setScreen(new SplashScreen(this));
    }

    public void render() {
        super.render();
    }
}
