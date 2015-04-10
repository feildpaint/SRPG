package com.ash.srpg.handlers;

import com.ash.srpg.screens.GameScreen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CombatInputHandler implements InputProcessor{

    private GameScreen screen;
    private OrthographicCamera camera;

    public boolean keyPressedUp;
    public boolean keyPressedLeft;
    public boolean keyPressedDown;
    public boolean keyPressedRight;

    public CombatInputHandler(GameScreen screen) {
        this.screen = screen;
    }

    public void move(){
        camera = screen.getCamera();
        if (keyPressedUp)
            camera.translate(0, -8);
        if (keyPressedDown)
            camera.translate(0, 8);
        if (keyPressedLeft)
            camera.translate(8, 0);
        if (keyPressedRight)
            camera.translate(-8, 0);
        screen.setCamera(camera);

    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Keys.UP:
                keyPressedUp = true;
                break;
            case Keys.DOWN:
                keyPressedDown = true;
                break;
            case Keys.LEFT:
                keyPressedLeft = true;
                break;
            case Keys.RIGHT:
                keyPressedRight = true;
                break;
            default:
                break;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Keys.UP:
                keyPressedUp = false;
                break;
            case Keys.DOWN:
                keyPressedDown = false;
                break;
            case Keys.LEFT:
                keyPressedLeft = false;
                break;
            case Keys.RIGHT:
                keyPressedRight = false;
                break;
            default:
                break;
        }

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
}
