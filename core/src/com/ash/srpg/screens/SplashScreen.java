package com.ash.srpg.screens;


import aurelienribon.tweenengine.*;
import com.ash.srpg.MagicalAcademy;
import com.ash.srpg.tweenAccessors.SpriteTween;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SplashScreen implements Screen{

    private Texture splashTexture;
    private Sprite splashSprite;
    private SpriteBatch batch;
    private MagicalAcademy game;
    private TweenManager manager;

    public SplashScreen(MagicalAcademy game){
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        manager.update(delta);
        batch.begin();
        splashSprite.draw(batch);
        batch.end();
    }


    @Override
    public void show() {
        splashTexture = new Texture("title/splash.png");
        splashTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        splashSprite = new Sprite(splashTexture);
        splashSprite.setColor(1, 1, 1, 0);
        splashSprite.setX(Gdx.graphics.getWidth() / 2 - (splashSprite.getWidth() / 2));
        splashSprite.setY(Gdx.graphics.getHeight() / 2 - (splashSprite.getHeight() / 2));

        batch = new SpriteBatch();
        
        Tween.registerAccessor(Sprite.class, new SpriteTween());
        
        manager = new TweenManager();
        
        TweenCallback cb = new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                tweenCompleted();
                game.setScreen(new MainMenu(game));
            }
        };

        Tween.to(splashSprite, SpriteTween.ALPHA, 1f)   //FADE TIME
                .target(1)
                .ease(TweenEquations.easeInQuad)
                .repeatYoyo(1, 2.5f)
                .setCallback(cb)
                .setCallbackTriggers(TweenCallback.COMPLETE)
                .start(manager);
    }

    private void tweenCompleted() {
        Gdx.app.log(MagicalAcademy.LOG, "Tween Complete");
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
