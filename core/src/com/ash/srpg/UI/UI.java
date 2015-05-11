package com.ash.srpg.UI;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;

public class UI implements Screen {

    private InputMultiplexer im;

    @Override
    public void show() {
        im = new InputMultiplexer();
        im.addProcessor(new UIInputHandler());

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
