package com.ash.srpg.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Character extends Sprite {

    public Character(Sprite sprite) {
        super(sprite);
    }

    public void draw(SpriteBatch batch){
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    private void update(float deltaTime) {
    }
}
