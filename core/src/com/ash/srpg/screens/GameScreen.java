
package com.ash.srpg.screens;

import com.ash.srpg.MagicalAcademy;
import com.ash.srpg.comabt.MoveTile;
import com.ash.srpg.comabt.CombatInputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

//    private SpriteBatch batch;
    private Vector2[][] grid;

//    private MoveTile[] moveTiles;

    public GameScreen(MagicalAcademy game) {
        this.game = game;
    }

    public void show() {
        map = new TmxMapLoader().load("tiles/test01.tmx");
        //TODO set map tile height based on inout file

        renderer = new IsometricTiledMapRenderer(map);

        cam = new OrthographicCamera();

        grid = new Vector2[(int) map.getProperties().get("width")][(int) map.getProperties().get("height")];


        stage = new Stage();
        stage.getViewport().setCamera(cam);

//        batch = new SpriteBatch();

        processor = new CombatInputHandler(this);

    }

    public void render(float delta) {
        // set bg to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act(delta);

        // update camera
        cam.update();


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
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Vector2(i * 32 - dx, j * 16 - dy);

                dx -= 32;
            }
            dx = 0;
            dy += 16;
        }
        showMove(2, 5, 5);

    }

    public void showMove2(int moveDistance, int startRow, int startCol){
        int total = (((moveDistance * 2 + 1) * (moveDistance * 2 + 1)) / 2);
        System.out.println("Total: " + total);
        Button[] buttons = new Button[total];
        MoveTile tile = new MoveTile();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = tile.getButton();
        }

        int diameter = moveDistance * 2;

        int count = 0;
        // make vertical line
        for (int i = 0; i < diameter + 1; i++) {
            if (i == diameter / 2){
                buttons[count] = null;
            }
            else {
                try {
                    System.out.println(count);
                    if(buttons[count] != null)
                    buttons[count].setPosition(grid[(startRow - moveDistance) + i][startCol].x, grid[(startRow - moveDistance) + i][startCol].y);
                    count++;
                } catch (ArrayIndexOutOfBoundsException e) {
                    buttons[count] = null;
                    count++;
                }
            }
        }

        System.out.println("Count is at " + count + " after first loop");

        // make horizontal line
        for (int i = 0; i < diameter + 1; i++) {
            if (i == diameter / 2){
                buttons[count] = null;
            }
            else{
                try {
                    System.out.println(count);
                    if(buttons[count] != null)
                    buttons[count].setPosition(grid[startRow][(startCol - moveDistance) + i].x, grid[startRow][(startCol - moveDistance) + i].y);
                    count++;
                } catch (ArrayIndexOutOfBoundsException e) {
                    buttons[count] = null;
                    count++;
                }
            }
        }

        System.out.println("Count is at " + count + " after second loop");


        // fill corners
        for (int i = 0; i < moveDistance; i++) {
            for (int j = moveDistance - 1; j > 0; j--) {

                if(i == 0 || j == 0 || (i + j) > moveDistance){
                    buttons[count] = null;
                } else {
                    try {
                        System.out.println(count);
                        if(buttons[count] != null)
                        buttons[count].setPosition(grid[startRow + j][startCol + i].x, grid[startRow + j][startCol + i].y);
                        count++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        buttons[count] = null;
                        count++;
                    }
                }

            }
        }

        System.out.println("Count is at " + count + " after thrid loop");


        for (int i = 0; i < moveDistance; i++) {
            for (int j = moveDistance - 1; j > 0; j--) {

                if(i == 0 || j == 0 || (i + j) > moveDistance){
                    buttons[count] = null;
                } else {
                    try {
                        System.out.println(count);
                        if(buttons[count] != null)
                        buttons[count].setPosition(grid[startRow - j][startCol + i].x, grid[startRow - j][startCol + i].y);
                        count++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        buttons[count] = null;
                        count++;
                    }
                }

            }
        }

        System.out.println("Count is at " + count + " after forth loop");


        for (int i = 0; i < moveDistance; i++) {
            for (int j = moveDistance - 1; j > 0; j--) {

                if(i == 0 || j == 0 || (i + j) > moveDistance){
                    buttons[count] = null;
                } else {
                    try {
                        System.out.println(count);
                        if(buttons[count] != null)
                        buttons[count].setPosition(grid[startRow - j][startCol - i].x, grid[startRow - j][startCol - i].y);
                        count++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        buttons[count] = null;
                        count++;
                    }
                }

            }
        }

        System.out.println("Count is at " + count + " after fifth loop");


        for (int i = 0; i < moveDistance; i++) {
            for (int j = moveDistance - 1; j > 0; j--) {

                if(i == 0 || j == 0 || (i + j) > moveDistance){
                    buttons[count] = null;
                } else {
                    try {
                        System.out.println(count);
                        if(buttons[count] != null)
                        buttons[count].setPosition(grid[startRow + j][startCol - i].x, grid[startRow + j][startCol - i].y);
                        count++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        buttons[count] = null;
                        count++;
                    }
                }

            }
        }

        System.out.println("Count is at " + count + " after sixth loop");

        for (Button b : buttons){
            if (b != null) stage.addActor(b);
        }

    }


    public void showMove(int moveDistance, int startRow, int startCol){
        int total = (((moveDistance * 2 + 1) * (moveDistance * 2 + 1)) / 2);
        System.out.println(total);

        int diameter = moveDistance * 2;

        // make vertical line
        for (int i = 0; i < diameter + 1; i++) {
            Button button = new MoveTile().getButton();
            if (i == diameter / 2){
                button = null;
            }
            else{
                try {
                    button.setPosition(grid[(startRow - moveDistance) + i][startCol].x, grid[(startRow - moveDistance) + i][startCol].y);
                } catch (ArrayIndexOutOfBoundsException e) {
                    button = null;
                }
            }
            if (button != null) stage.addActor(button);
        }

        // make horizontal line
        for (int i = 0; i < diameter + 1; i++) {
            Button button = new MoveTile().getButton();
            if (i == diameter / 2){
                button = null;
            }
            else{
                try {
                    button.setPosition(grid[startRow][(startCol - moveDistance) + i].x, grid[startRow][(startCol - moveDistance) + i].y);
                } catch (ArrayIndexOutOfBoundsException e) {
                    button = null;
                }
            }
            if (button != null) stage.addActor(button);
        }

        // fill corners
        for (int i = 0; i < moveDistance; i++) {
            for (int j = moveDistance - 1; j > 0; j--) {
                Button button = new MoveTile().getButton();
                Button button2 = new MoveTile().getButton();
                Button button3 = new MoveTile().getButton();
                Button button4 = new MoveTile().getButton();

                if(i == 0 || j == 0 || (i + j) > moveDistance){
                    button = null;
                    button2 = null;
                    button3 = null;
                    button4 = null;
                } else {
                    System.out.println("i: " + i + " j: " + j);
                    try {
                        button.setPosition(grid[startRow + j][startCol + i].x, grid[startRow + j][startCol + i].y);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        button = null;
                    }
                    try {
                        button2.setPosition(grid[startRow - j][startCol + i].x, grid[startRow - j][startCol + i].y);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        button2 = null;
                    }
                    try {
                        button3.setPosition(grid[startRow + j][startCol - i].x, grid[startRow + j][startCol - i].y);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        button3 = null;
                    }
                    try {
                        button4.setPosition(grid[startRow - j][startCol - i].x, grid[startRow - j][startCol - i].y);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        button4 = null;
                    }

                }
                if (button != null) stage.addActor(button);
                if (button2 != null) stage.addActor(button2);
                if (button3 != null) stage.addActor(button3);
                if (button4 != null) stage.addActor(button4);
            }

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

