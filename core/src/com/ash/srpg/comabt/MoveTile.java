package com.ash.srpg.comabt;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import javafx.scene.Camera;

import java.io.File;

public class MoveTile {

    private Button button;
    private TextureAtlas atlas;
    private Skin skin;
    private Pixmap released;

    private OrthographicCamera camera;

    public MoveTile(final OrthographicCamera camera) {
        this.camera = camera;
        skin = new Skin();
        atlas = new TextureAtlas("tiles/moveTile.pack");
        skin.addRegions(atlas);

        ButtonStyle style = new ButtonStyle();
        style.up = skin.getDrawable("moveTileReleased");
        style.down = skin.getDrawable("moveTilePressed");
//        style.checked = skin.getDrawable("moveTileTouched");

        released = new Pixmap(new FileHandle("tiles/mTile1.png"));

        button = new Button(style);

        button.toFront();

        //FIXME world coordinates to check button location

        button.addListener(new InputListener() {

            private boolean isChecked;

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                int pixel = released.getPixel((int) x, (int) y);
                if ((pixel & 0x000000ff) != 0) return true;
                return false;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                if(isChecked && button == Input.Buttons.LEFT) System.out.println("Move tile left pressed...");
//                if(isChecked && button == Input.Buttons.RIGHT) System.out.println("Move tile right pressed...");
                if (button == Input.Buttons.LEFT) System.out.println("Move tile left pressed at " + camera.project(new Vector3(x, y, 0)));
                if (button == Input.Buttons.RIGHT) System.out.println("Move tile right pressed...");
            }

//            @Override
//            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
//                int pixel = released.getPixel((int)x, (int)y);
//                if ((pixel & 0x000000ff) != 0) {
//                    button.setChecked(true);
//                    isChecked = button.isChecked();
//                }
//
//            }
//
//            @Override
//            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
//                int pixel = released.getPixel((int)x, (int)y);
//                if (!((pixel & 0x000000ff) != 0)) {
//                    button.setChecked(false);
//                    isChecked = button.isChecked();
//                }
//            }

        });

    }

    public Button getButton() {
        return button;
    }
}
