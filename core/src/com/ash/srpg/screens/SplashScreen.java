package com.ash.srpg.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;
import com.ash.srpg.MagicalAcademy;
import com.ash.srpg.tweenAccessors.SpriteTween;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SplashScreen implements Screen {
    private Texture splashTexture;
    private Sprite splashSprite;
    private SpriteBatch batch;
    private MagicalAcademy game;
    private TweenManager manager;

    public SplashScreen(MagicalAcademy game) {
        this.game = game;
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        manager.update(delta);
        batch.begin();
        splashSprite.draw(batch);
        batch.end();
    }

    public void show() {
        splashTexture = new Texture("title/splash.png");
        splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        splashSprite = new Sprite(splashTexture);
        splashSprite.setColor(1.0F, 1.0F, 1.0F, 0.0F);
        splashSprite.setX((Gdx.graphics.getWidth() / 2) - splashSprite.getWidth() / 2.0F);
        splashSprite.setY((Gdx.graphics.getHeight() / 2) - splashSprite.getHeight() / 2.0F);
        batch = new SpriteBatch();
        Tween.registerAccessor(Sprite.class, new SpriteTween());
        manager = new TweenManager();
        TweenCallback cb = new TweenCallback() {
            public void onEvent(int type, BaseTween<?> source) {
                tweenCompleted();
            }
        };

        Tween.to(splashSprite, SpriteTween.ALPHA, 1)
                .target(1)
                .ease(TweenEquations.easeInQuad)
                .repeatYoyo(1, 2.5F)
                .setCallback(cb)
                .setCallbackTriggers(TweenCallback.COMPLETE)
                .start(manager);
    }

    private void tweenCompleted() {
        Gdx.app.log("Magical Academy", "Tween Complete");
        dispose();
        game.setScreen(new MainMenu(game));
    }

    public void resize(int width, int height) {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void hide() {
    }

    public void dispose() {
        batch.dispose();
        splashTexture.dispose();
    }
}
