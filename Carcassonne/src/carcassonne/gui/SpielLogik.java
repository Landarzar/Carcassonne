package carcassonne.gui;

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

	public void showTriangles()
	{
		List<Karte> karten = screen.getSpiel().getKarten();
		Spiel spiel = screen.getSpiel();

		for (Karte k : karten)
		{
			GUIKarte karte = (GUIKarte) k;
			if (spiel.hasPosi(karte.getX()+1, karte.getY()))
			{
				Geometry geo = karte.getGeometry();
				Vector3f vec = geo.getWorldTranslation();
				GUIKartenAnklicker gka = new GUIKartenAnklicker	(karte, 0, vec.x + 0.4f, vec.y + 0.4f, 8f, vec.x + 0.4f, 0f, 8f, 2f, 2f, 8f);
				
				Geometry geo2 = new Geometry("fsdf", gka);
				
				screen.getManager().getRootNode().attachChild(geo2);
			}
		}

	}

	private SpielScreen screen;
}
