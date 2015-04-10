
package com.ash.srpg.screens;

import com.ash.srpg.MagicalAcademy;
import com.ash.srpg.characters.Character;
import com.ash.srpg.handlers.CombatInputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;

public class GameScreen implements Screen {

    private MagicalAcademy game;

    private TiledMap map;
    private IsometricTiledMapRenderer renderer;
    private OrthographicCamera cam;

    private CombatInputHandler processer;

    private Character[] players;

    public GameScreen(MagicalAcademy game) {
        this.game = game;
    }

    public void show() {
        TmxMapLoader.Parameters param = new TmxMapLoader.Parameters();
        param.convertObjectToTileSpace = true;
        map = new TmxMapLoader().load("tiles/test01.tmx", param);

        renderer = new IsometricTiledMapRenderer(map);

        cam = new OrthographicCamera();

        players = new Character[10];

        processer = new CombatInputHandler(this);
        Gdx.input.setInputProcessor(processer);
//        player = new Character(new Sprite(new Texture("characters/player.png")));

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        processer.move();

        cam.update();
        renderer.setView(cam);
        renderer.render();

        renderer.getBatch().begin();
        for (Character player : players)
            player.draw(renderer.getBatch());
        renderer.getBatch().end();
    }

    public void resize(int width, int height) {
        cam.viewportWidth = width / 2;
        cam.viewportHeight = height / 2;
        cam.translate(320, 0);
        cam.update();

        for (int i = 0; i < players.length; i++) {
            players[i] = new Character(new Sprite(new Texture("characters/player.png")));


            players[i].setX(i * 32);
            players[i].setY(i * 16);
        }

    }

    public void pause() {
    }

    public void resume() {
    }

    public void hide() {
    }

    public void dispose() {
    }

    public OrthographicCamera getCamera() {
        return cam;
    }

    public void setCamera(OrthographicCamera camera) {
        this.cam = camera;
    }
}

