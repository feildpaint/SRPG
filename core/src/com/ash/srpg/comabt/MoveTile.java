package com.ash.srpg.comabt;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MoveTile {

    private Button button;
    private TextureAtlas atlas;
    private Skin skin;

    public MoveTile() {
        skin = new Skin();
        atlas = new TextureAtlas("tiles/moveTile.pack");
        skin.addRegions(atlas);

        ButtonStyle style = new ButtonStyle();
        style.up = skin.getDrawable("moveTileReleased");
        style.down = skin.getDrawable("moveTilePressed");
        style.checked = skin.getDrawable("moveTileTouched");

        button = new Button(style);

        button.addListener(new ClickListener(){

            private boolean isChecked;

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if(isChecked && button == Input.Buttons.LEFT) System.out.println("Move tile left pressed...");
                if(isChecked && button == Input.Buttons.RIGHT) System.out.println("Move tile right pressed...");
            }

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button.setChecked(true);
                isChecked = button.isChecked();
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                button.setChecked(false);
                isChecked = button.isChecked();
            }


        });
    }

    public Button getButton() {
        return button;
    }
}
