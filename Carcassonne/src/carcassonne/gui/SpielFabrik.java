/**
 * 
 */
package carcassonne.gui;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import com.jme3.texture.Texture;

import carcassonne.model.Karte;
import carcassonne.model.Spiel;

/**
 * @author Landarzar
 * 
 */
public class SpielFabrik
{
	// private SpielFabrik singleton = null;
	//
	// public SpielFabrik getInstance()
	// {
	// if(singleton == null)
	// singleton = new SpielFabrik();
	// return singleton;
	// }

	private SpielFabrik()
	{

	}

	public static Spiel createNormalGame()
	{
		LinkedList<Texture> textures = new LinkedList<Texture>();

		textures.add(GUIKarte.KlosterStreet);
		textures.add(GUIKarte.KlosterStreet);
		textures.add(GUIKarte.Kloster);
		textures.add(GUIKarte.Kloster);
		textures.add(GUIKarte.Kloster);
		textures.add(GUIKarte.Kloster);
		textures.add(GUIKarte.City4Wappen);
		textures.add(GUIKarte.City1Street2Gerade);
		textures.add(GUIKarte.City1Street2Gerade);
		textures.add(GUIKarte.City1Street2Gerade);
		textures.add(GUIKarte.City1Street2Gerade);
		textures.add(GUIKarte.City1Wiese);
		textures.add(GUIKarte.City1Wiese);
		textures.add(GUIKarte.City1Wiese);
		textures.add(GUIKarte.City1Wiese);
		textures.add(GUIKarte.City1Wiese);
		textures.add(GUIKarte.City2WappenConn);
		textures.add(GUIKarte.City2WappenConn);
		textures.add(GUIKarte.City2Conn);
		textures.add(GUIKarte.City2SplitWiese);
		textures.add(GUIKarte.City2SplitWiese);
		textures.add(GUIKarte.City2SplitWiese);
		textures.add(GUIKarte.City2SplitWiese2);
		textures.add(GUIKarte.City2SplitWiese2);
		textures.add(GUIKarte.City2SplitWiese2);
		textures.add(GUIKarte.City1Street2Right);
		textures.add(GUIKarte.City1Street2Right);
		textures.add(GUIKarte.City1Street2Right);
		textures.add(GUIKarte.City1Street2);
		textures.add(GUIKarte.City1Street2);
		textures.add(GUIKarte.City1Street2);
		textures.add(GUIKarte.City1Street3);
		textures.add(GUIKarte.City1Street3);
		textures.add(GUIKarte.City1Street3);
		textures.add(GUIKarte.City2WappenWiese);
		textures.add(GUIKarte.City2WappenWiese);
		textures.add(GUIKarte.City2Wiese);
		textures.add(GUIKarte.City2Wiese);
		textures.add(GUIKarte.City2Wiese);
		textures.add(GUIKarte.City2WappenStreet2);
		textures.add(GUIKarte.City2WappenStreet2);
		textures.add(GUIKarte.City2Street2);
		textures.add(GUIKarte.City2Street2);
		textures.add(GUIKarte.City2Street2);
		textures.add(GUIKarte.City3WappenStreet);
		textures.add(GUIKarte.City3Street);
		textures.add(GUIKarte.City3Street);
		textures.add(GUIKarte.City3Street);
		textures.add(GUIKarte.City3WappenWiese);
		textures.add(GUIKarte.City3WappenWiese);
		textures.add(GUIKarte.City3Wiese);
		textures.add(GUIKarte.Street2);
		textures.add(GUIKarte.Street2);
		textures.add(GUIKarte.Street2);
		textures.add(GUIKarte.Street2);
		textures.add(GUIKarte.Street2);
		textures.add(GUIKarte.Street2);
		textures.add(GUIKarte.Street2);
		textures.add(GUIKarte.Street2);
		textures.add(GUIKarte.Street2Left);
		textures.add(GUIKarte.Street2Left);
		textures.add(GUIKarte.Street2Left);
		textures.add(GUIKarte.Street2Left);
		textures.add(GUIKarte.Street2Left);
		textures.add(GUIKarte.Street2Left);
		textures.add(GUIKarte.Street2Left);
		textures.add(GUIKarte.Street2Left);
		textures.add(GUIKarte.Street2Left);
		textures.add(GUIKarte.Street3);
		textures.add(GUIKarte.Street3);
		textures.add(GUIKarte.Street3);
		textures.add(GUIKarte.Street3);
		textures.add(GUIKarte.Street4);

		Stack<GUIKarte> karten = new Stack<GUIKarte>();

		for (Texture tex : textures)
		{
			GUIKarte card = new GUIKarte(tex);
			karten.push(card);
		}

		final Random rand = new Random(System.currentTimeMillis());

		Collections.sort(karten, new Comparator<GUIKarte>()
		{

			@Override
			public int compare(GUIKarte o1, GUIKarte o2)
			{
				return (rand.nextInt(3) - 1);
			}
		});

		return new Spiel(new Stack<Karte>());
	}

}
