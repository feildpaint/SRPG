package com.ash.srpg.screens;

import com.ash.srpg.MagicalAcademy;
import com.ash.srpg.map.MapButton;
import com.ash.srpg.map.MapType;
import com.badlogic.gdx.*;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import javax.xml.soap.Text;
import java.util.ArrayList;

public class MapScreen implements Screen, InputProcessor {

    public static final int MAPSCREEN_PADDING_X = 20;
    public static final int MAPSCREEN_PADDING_Y = 20;
    public static final float MAPTITLE_PADDING_X = 24;
    public static final float MAPTITLE_PADDING_Y = 640;
    public static final float BACKBUTTON_SIZE_X = 160;
    public static final float BACKBUTTON_SIZE_Y = 64;

    public static final int MAX_SELECTIONS = 5;


    private MagicalAcademy game;

    private Stage stage;
    private SpriteBatch batch;

    public static BitmapFont titleFont;
    public static TextureAtlas atlas = new TextureAtlas("button/button01.pack");
    private InputMultiplexer im;

    private ArrayList<MapButton> mapButtons;
    private MapType currentMap;
    private Sprite mapSprite;
    private TextButton backButton;

    private int currentSelection = 1;

    public MapScreen(MagicalAcademy game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        im = new InputMultiplexer();

        titleFont = new BitmapFont(new FileHandle("font/mapFont1.fnt"), new TextureRegion(new Texture("font/mapFont1.png")));
        titleFont.setColor(0, 0, 0, 1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor((float) 231 / 255, (float) 223 / 255, (float) 136 / 255, 1);
        Gdx.gl20.glClear(GL30.GL_COLOR_BUFFER_BIT);

        batch.begin();
        mapSprite.draw(batch);
//        titleFont.setColor(0, 0, 0, 1);
        titleFont.draw(batch, currentMap.getTitle(), MAPTITLE_PADDING_X, MAPTITLE_PADDING_Y + titleFont.getCapHeight());
        batch.end();

        batch.begin();
        stage.draw();
        batch.end();

    }

    private void setMap(int id) {
        mapSprite = currentMap.getMapSprite();
        mapSprite.setX(MAPSCREEN_PADDING_X);
        mapSprite.setY(MAPSCREEN_PADDING_Y);

        mapButtons = currentMap.getMapButtons();

        stage.clear();

        if (mapButtons.size() >= 0){
            for (final MapButton mapButton : mapButtons){
                TextButton button = mapButton.getButton();
                button.setX(mapButton.getX());
                button.setY(mapButton.getY());

                //TODO fix so that the buttons are working

                button.addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        currentMap = new MapType(mapButton.getId());
                        setMap(mapButton.getId());
                    }
                });

                stage.addActor(button);
            }
        }

        setBackButton();

    }

    private void setBackButton() {
        if (currentMap.isHasBack()){
            Skin skin = new Skin();
            skin.addRegions(atlas);
            TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
            style.up = skin.getDrawable("buttonReleased");
            style.down = skin.getDrawable("buttonPressed");
            style.checked = skin.getDrawable("buttonChecked");
            style.font = titleFont;
            backButton = new TextButton("Back", style);
            backButton.setWidth(BACKBUTTON_SIZE_X);
            backButton.setHeight(BACKBUTTON_SIZE_Y);
            backButton.setX(0);
            backButton.setY(0);

            backButton.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    currentMap = new MapType(currentMap.getBackid());
                    setMap(currentMap.getBackid());
                }
            });

            stage.addActor(backButton);

        }
    }


    @Override
    public void resize(int width, int height) {
        if (stage == null) stage = new Stage();

        stage.clear();

        currentMap = new MapType(1);
        setMap(currentMap.getId());

        im.addProcessor(this);
        im.addProcessor(stage);
        Gdx.input.setInputProcessor(im);



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
        stage.dispose();
        batch.dispose();

        titleFont.dispose();
        atlas.dispose();

    }

    //<editor-fold desc="Input Processor">
    @Override
    public boolean keyDown(int keycode) {
//        switch (keycode){
//            case Input.Keys.LEFT:
//                currentSelection++;
//                checkSelection();
//                setMapSprite(currentSelection);
//                break;
//            case Input.Keys.RIGHT:
//                currentSelection--;
//                checkSelection();
//                setMapSprite(currentSelection);
//                break;
//            default:
//        }
        return false;
    }

    private void checkSelection() {
        if (currentSelection == 0) currentSelection = MAX_SELECTIONS;
        else if (currentSelection > MAX_SELECTIONS) currentSelection = 1;
    }


    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    //</editor-fold>
}
