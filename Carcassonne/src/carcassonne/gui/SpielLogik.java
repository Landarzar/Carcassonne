package carcassonne.gui;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;

import carcassonne.model.Karte;
import carcassonne.model.Spiel;

public class SpielLogik
{
	public SpielLogik(SpielScreen screen)
	{
		this.screen = screen;

		anklicker = new LinkedList<GUIKartenAnklicker>();
	}
	
	LinkedList<GUIKartenAnklicker> anklicker;

	public static HashMap<Integer, Boolean[]> map;

	public void showTriangles()
	{
		Spiel spiel = screen.getSpiel();

		HashMap<Integer, Boolean[]> map =  spiel.getPositions();
		
		for (Integer key : map.keySet())
		{
			Boolean[] bools = map.get(key);
			
			if(bools[0] || bools[1] || bools[2] || bools[3])
			{
				GUIKartenAnklicker placeholder = new GUIKartenAnklicker(Spiel.decalcToPoint((int)key), screen.getManager());
				screen.getManager().getRootNode().updateGeometricState();
				screen.getManager().getRootNode().attachChild(placeholder.getGeo());
				screen.getManager().getRootNode().updateGeometricState();
			}
		}
	}

	private SpielScreen screen;
}
