package com.ash.srpg;

import com.ash.srpg.characters.CharacterType;
import com.ash.srpg.screens.MainMenu;
import com.badlogic.gdx.Game;

import java.util.ArrayList;

public class MagicalAcademy extends Game {
    public static final String VERSION = "0.01 Pre-Alpha";
    public static final String LOG = "Magical Academy";

    public CharacterType mainCharacter;

    public ArrayList<CharacterType> characters;


    public MagicalAcademy() {
    }

    public void create() {
//        setScreen(new SplashScreen(this));
        setScreen(new MainMenu(this));
    }

    public void render() {
        super.render();
    }
}
