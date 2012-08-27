/**
 * 
 */
package carcassonne;

import carcassonne.gui.GUIManager;

import com.jme3.system.AppSettings;

/**
 * @author Landarzar
 * 
 */
public class Main
{

	public static void main(String[] args)
	{
		AppSettings settings = new AppSettings(true);
		settings.setHeight(800);
		settings.setWidth(1024);

		GUIManager gui = new GUIManager(settings);
		gui.setShowSettings(false);
		gui.start();
	}

}
