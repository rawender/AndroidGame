package ru.geekbrains.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.geekbrains.StarGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		float aspect = 10f/16F;
		config.width = 500;
		config.height = (int) (config.width / aspect);
		config.resizable = false;
		new LwjglApplication(new StarGame(), config);
	}
}
