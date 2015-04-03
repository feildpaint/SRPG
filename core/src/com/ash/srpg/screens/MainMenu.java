package com.ash.srpg.screens;

import com.ash.srpg.MagicalAcademy;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class MainMenu implements Screen {

    private MagicalAcademy game;
    private Stage stage;
    private BitmapFont font;
    private TextureAtlas atlas;
    private Skin skin;
    private SpriteBatch batch;
    private TextButton button;


    public MainMenu(MagicalAcademy game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin();
        atlas = new TextureAtlas("button/button.pack");
        skin.addRegions(atlas);
        font = new BitmapFont(Gdx.files.internal("font/whiteFont.fnt"), false);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);


        stage.act(delta);

        batch.begin();
        stage.draw();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        if (stage == null)
            stage = new Stage();
        stage.clear();

        Gdx.input.setInputProcessor(stage);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = skin.getDrawable("buttonR");
        style.down = skin.getDrawable("buttonP");
        style.font = font;

        button = new TextButton("Press me!", style);
        button.setWidth(150);
        button.setHeight(50);
        button.setX(Gdx.graphics.getWidth()  - (button.getWidth() + 50 ));
        button.setY(Gdx.graphics.getHeight() / 2 - button.getHeight() / 2);

        button.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));

            }
        });

        stage.addActor(button);

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
        batch.dispose();
        skin.dispose();
        atlas.dispose();
        font.dispose();
        stage.dispose();

    }
}
