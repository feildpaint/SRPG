package com.ash.srpg.comabt;

import com.ash.srpg.screens.GameScreen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class CombatInputHandler implements InputProcessor{

    private GameScreen screen;
    private OrthographicCamera camera;

    public boolean keyPressedUp;
    public boolean keyPressedLeft;
    public boolean keyPressedDown;
    public boolean keyPressedRight;
    public boolean keyPressedZ;
    public boolean keyPressedX;

    public CombatInputHandler(GameScreen screen) {
        this.screen = screen;
    }

    public void move(){

        // move camera
        camera = screen.getCamera();
        if (keyPressedUp)
            camera.translate(0, -6);
        else if (keyPressedDown)
            camera.translate(0, 6);
        if (keyPressedLeft)
            camera.translate(6, 0);
        else if (keyPressedRight)
            camera.translate(-6, 0);

        if (keyPressedZ)
            camera.zoom -= 0.1f;
        else if (keyPressedX)
            camera.zoom += 0.1f;


        // move bounds
        if (camera.position.y > (camera.viewportHeight / 2) + 16)
            camera.position.y = (camera.viewportHeight / 2) + 16;
        if (camera.position.y < -(camera.viewportHeight / 2) + 16)
            camera.position.y = -(camera.viewportHeight / 2) + 16;
        if (camera.position.x > camera.viewportWidth)
            camera.position.x = camera.viewportWidth;
        if (camera.position.x < 0)
            camera.position.x = 0;

        if (camera.zoom < 0.7f)
            camera.zoom = 0.7f;
        else if (camera.zoom > 2f)
            camera.zoom = 2f;

        screen.setCamera(camera);

    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Keys.UP:
                keyPressedUp = true;
                break;
            case Keys.W:
                keyPressedUp = true;
                break;
            case Keys.DOWN:
                keyPressedDown = true;
                break;
            case Keys.S:
                keyPressedDown = true;
                break;
            case Keys.LEFT:
                keyPressedLeft = true;
                break;
            case Keys.A:
                keyPressedLeft = true;
                break;
            case Keys.RIGHT:
                keyPressedRight = true;
                break;
            case Keys.D:
                keyPressedRight = true;
                break;
            case Keys.Z:
                keyPressedZ = true;
                break;
            case Keys.X:
                keyPressedX = true;
                break;

            case Keys.SPACE:
                camera.position.set(320, 16, 0);
                break;
            case Keys.C:
                camera.zoom = 1;
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
            case Keys.W:
                keyPressedUp = false;
                break;
            case Keys.DOWN:
                keyPressedDown = false;
                break;
            case Keys.S:
                keyPressedDown = false;
                break;
            case Keys.LEFT:
                keyPressedLeft = false;
                break;
            case Keys.A:
                keyPressedLeft = false;
                break;
            case Keys.RIGHT:
                keyPressedRight = false;
                break;
            case Keys.D:
                keyPressedRight = false;
                break;
            case Keys.Z:
                keyPressedZ = false;
                break;
            case Keys.X:
                keyPressedX = false;
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
