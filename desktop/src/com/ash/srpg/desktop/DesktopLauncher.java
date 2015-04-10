package com.ash.srpg.desktop;

import com.ash.srpg.MagicalAcademy;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public DesktopLauncher() {
    }

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1280;
        config.height = 720;
        config.title = "Magical Academy v0.01 Pre-Alpha";
        config.resizable = false;
        new LwjglApplication(new MagicalAcademy(), config);
    }
}