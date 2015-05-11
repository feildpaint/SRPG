package com.ash.srpg.map;

import com.ash.srpg.screens.MapScreen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MapButton {

    private int id;
    private int x;
    private int y;
    private String title;

    private TextButton button;

    public MapButton(int id, int x, int y, String title) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.title = title;
        setButton();
    }

    private void setButton() {
        Skin skin = new Skin();
        skin.addRegions(MapScreen.atlas);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = skin.getDrawable("buttonReleased");
        style.down = skin.getDrawable("buttonPressed");
        style.checked = skin.getDrawable("buttonChecked");
        style.font = MapScreen.titleFont;
        button = new TextButton(id + "", style);
        button.setWidth(64);
        button.setHeight(64);
    }

    public String toString(){
        String str = "";
        str += "ID: " + id + "  X: "+ x + "  Y: " + y + "  " + title;
        return str;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getTitle() {
        return title;
    }

    public TextButton getButton() {
        return button;
    }
}
