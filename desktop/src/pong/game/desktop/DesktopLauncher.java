package pong.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pong.game.Pong;

/**
 * Desktop Launcher class
 * 
 * @author Alex Pearce
 *
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Pong(), config);
		config.width = 1024;
		config.height = 768;
		config.foregroundFPS = 58;
		config.vSyncEnabled = true;
		config.title = "Pong";
		
	}
}
