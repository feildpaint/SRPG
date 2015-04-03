package com.ash.srpg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ash.srpg.MagicalAcademy;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 600;
		config.title = "Magical Academy v" + MagicalAcademy.VERSION;
		config.resizable = false;
		new LwjglApplication(new MagicalAcademy(), config);
	}
}
