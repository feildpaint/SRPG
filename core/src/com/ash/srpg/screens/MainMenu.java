
package com.ash.srpg.screens;

import com.ash.srpg.MagicalAcademy;
import com.ash.srpg.characters.CharacterType;
import com.ash.srpg.characters.Race;
import com.ash.srpg.characters.Unit;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MainMenu implements Screen {
    private MagicalAcademy game;
    private Stage stage;
    private BitmapFont font;
    private TextureAtlas atlas;
    private Skin skin;
    private SpriteBatch batch;

    private TextButton[] button = new TextButton[4];

    private Sprite titleMenuSprite;



    public MainMenu(MagicalAcademy game) {
        this.game = game;
    }

    public void render(float delta) {
        Gdx.gl.glClearColor((float) 185 / 255, (float) 145 / 255, (float) 69 / 255, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act(delta);

        batch.begin();
        titleMenuSprite.draw(batch);
        batch.end();

        batch.begin();
        stage.draw();
        batch.end();
    }


    public void show() {
        // set sprites
        Texture titleMenu = new Texture("title/titleName.png");
        titleMenu.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        titleMenuSprite = new Sprite(titleMenu);
        titleMenuSprite.setX(Gdx.graphics.getWidth() / 2 - titleMenuSprite.getWidth() / 2);
        titleMenuSprite.setY(Gdx.graphics.getHeight() - (titleMenuSprite.getHeight() + 25));

        batch = new SpriteBatch();
        skin = new Skin();
        atlas = new TextureAtlas("button/button01.pack");
        skin.addRegions(atlas);
        font = new BitmapFont(Gdx.files.internal("font/font01.fnt"), false);
    }



    public void resize(int width, int height) {
        if(stage == null) {
            stage = new Stage();
        }

        stage.clear();
        Gdx.input.setInputProcessor(stage);

        // set button
        TextButtonStyle style = new TextButtonStyle();
        style.up = skin.getDrawable("buttonReleased");
        style.down = skin.getDrawable("buttonPressed");
        style.checked = skin.getDrawable("buttonChecked");
        style.font = font;


        button[0] = new TextButton("Play", style);
        button[1] = new TextButton("Extras", style);
        button[2] = new TextButton("Options", style);
        button[3] = new TextButton("Exit", style);

        for (int i = 0; i < button.length; i++) {

            button[i].setWidth(150);
            button[i].setHeight(50);
            button[i].setX(Gdx.graphics.getWidth() - (button[i].getWidth() + 50));
            button[i].setY(Gdx.graphics.getHeight() - (Gdx.graphics.getHeight() / 3) - 25 - (75 * i));

        }


            // button 1: play
            button[0].addListener(new InputListener() {
                private boolean isChecked;

                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    if (isChecked) game.setScreen(new GameScreen(game));
                }

                public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                    button[0].setChecked(true);
                    isChecked = button[0].isChecked();
                }

                public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                    button[0].setChecked(false);
                    isChecked = button[0].isChecked();
                }

            });

        //FIXME add extras
        // button 2: extras
        button[1].addListener(new InputListener() {
            private boolean isChecked;

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (isChecked) {
                    Unit unit = new Unit();
                    CharacterType character = new CharacterType(Race.HUMAN);
                    CharacterType character2 = new CharacterType(Race.ELF);
                    CharacterType character3 = new CharacterType(Race.HALFLING);
                    CharacterType character4 = new CharacterType(Race.DRAGONKIN);
                    System.out.println(unit.toString());
                    System.out.println(character.toString());
                    System.out.println(character2.toString());
                    System.out.println(character3.toString());
                    System.out.println(character4.toString());
                }
            }

            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button[1].setChecked(true);
                isChecked = button[1].isChecked();
            }

            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                button[1].setChecked(false);
                isChecked = button[1].isChecked();
            }

        });

        //FIXME add options
        // button 3: options
        button[2].addListener(new InputListener() {
            private boolean isChecked;

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (isChecked){

                }
            }

            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button[2].setChecked(true);
                isChecked = button[2].isChecked();
            }

            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                button[2].setChecked(false);
                isChecked = button[2].isChecked();
            }

        });


        // button 4: exit
        button[3].addListener(new InputListener() {
            private boolean isChecked;

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (isChecked) Gdx.app.exit();
            }

            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button[3].setChecked(true);
                isChecked = button[3].isChecked();
            }

            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                button[3].setChecked(false);
                isChecked = button[3].isChecked();
            }

        });


        // add actors to stage
        for (TextButton aButton : button) {
            stage.addActor(aButton);
        }


    }

    public void pause() {
    }

    public void resume() {
    }

    public void hide() {
    }

    public void dispose() {
        batch.dispose();
        skin.dispose();
        atlas.dispose();
        font.dispose();
        stage.dispose();
    }
}
