
package com.ash.srpg.screens;

import com.ash.srpg.MagicalAcademy;
import com.ash.srpg.comabt.MoveTile;
import com.ash.srpg.handlers.CombatInputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;


public class GameScreen implements Screen {

    private MagicalAcademy game;

    private TiledMap map;
    private IsometricTiledMapRenderer renderer;
    private OrthographicCamera cam;
    private Stage stage;

    private CombatInputHandler processor;
    private InputMultiplexer multi = new InputMultiplexer();

    private SpriteBatch batch;
    private Vector2[] grid;

    private MoveTile[] moveTiles;

    public GameScreen(MagicalAcademy game) {
        this.game = game;
    }

    public void show() {
        map = new TmxMapLoader().load("tiles/test01.tmx");

        renderer = new IsometricTiledMapRenderer(map);

        cam = new OrthographicCamera();

        grid = new Vector2[100];


        stage = new Stage();
        stage.getViewport().setCamera(cam);

        batch = new SpriteBatch();


        processor = new CombatInputHandler(this);

    }

    public void render(float delta) {
        // set bg to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act(delta);

        // move camera
//        System.out.println(cam.position.x + " " + cam.position.y);

        // update camera
        cam.update();
//        System.out.println(cam.viewportHeight + " " + cam.viewportHeight);
//        System.out.println(cam.position);


        renderer.setView(cam);
        renderer.render();

        renderer.getBatch().setProjectionMatrix(cam.projection);
        renderer.getBatch().begin();
        stage.draw();
        renderer.getBatch().end();


        processor.move();
    }

    public void resize(int width, int height) {
        // set camera location and viewport
        cam.viewportWidth = width / 2;
        cam.viewportHeight = height / 2;
        cam.translate(320, 16);
        cam.update();

        stage.clear();

        multi.addProcessor(stage);
        multi.addProcessor(processor);
        Gdx.input.setInputProcessor(multi);



        // draw blue things
        int dy = 0;
        int dx = 0;
        for (int i = 0; i < grid.length; i++) {

            if (i%10 == 0 && i > 0) {
                dy += (160 + 16);
                dx += (320 - 32);
            }

            grid[i] = new Vector2(i * 32 - dx,i * 16 - dy);

        }

        calculateMove(1, 72);

    }

    public void calculateMove(int moveDistance, int startID){
        int total = (((moveDistance * 2 + 1) * (moveDistance * 2 + 1)) / 2);
        System.out.println(total);
        moveTiles = new MoveTile[total];

        for (int i = 0; i < moveTiles.length; i++) {
            moveTiles[i] = new MoveTile();
            Button button = moveTiles[i].getButton();
            if (total == 4) {
                if (i == 0) {
                    if ((startID  - 9)%10 == 0) button = null;
                    else button.setPosition(grid[startID + 1].x, grid[startID + 1].y);
                }
                if (i == 1) {
                    if(startID%10 == 0) button = null;
                    else button.setPosition(grid[startID - 1].x, grid[startID - 1].y);
                }
                if (i == 2) {
                    if (startID > 89) button = null;
                    else button.setPosition(grid[startID + 10].x, grid[startID + 10].y);
                }
                if (i == 3) {
                    if (startID < 10) button = null;
                    else button.setPosition(grid[startID - 10].x, grid[startID - 10].y);
                }
            }
            if (button != null) stage.addActor(button);
        }

    }


    public void pause() {
    }

    public void resume() {
    }

    public void hide() {
    }

    public void dispose() {
        map.dispose();
        stage.dispose();
        renderer.dispose();

    }

    public OrthographicCamera getCamera() {
        return cam;
    }

    public void setCamera(OrthographicCamera camera) {
        this.cam = camera;
    }
}

