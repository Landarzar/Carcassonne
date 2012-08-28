/**
 * 
 */
package carcassonne.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Fabianexe
 * 
 */
public class Spiel
{

	HashMap<Integer, Karte> map;

	private static final int MOD = 1000;
	private Stack<Karte> kartenstapel;

	private LinkedList<SpielObjekt> kloster;

	private static Spiel instance = null;

	public static Spiel getInstance()
	{
		return instance;
	}

	public static void makeInstance(Stack<Karte> kartenstapel)
	{
		instance = new Spiel(kartenstapel);
	}

	private Spiel(Stack<Karte> kartenstapel)
	{
		map = new HashMap<Integer, Karte>();
		this.kartenstapel = kartenstapel;
		this.kloster = new LinkedList<SpielObjekt>();
	}

	public boolean hasPosi(int x, int y)
	{
		return map.containsKey(calcKey(x, y));
	}

	private void insertKarte(int x, int y, Karte karte)
	{

		map.put(calcKey(x, y), karte);
	}

	private static Integer calcKey(int x, int y)
	{
		return (Integer) (MOD * x) + y;
	}

	private static Integer calcKey(int[] pos)
	{
		return (Integer) (MOD * pos[0]) + pos[1];
	}

	protected static int[] decalcKey(int z)
	{
		int[] ret = new int[2];
		ret[0] = (z % MOD) > 500 ? z / MOD + 1 : z / MOD;
		ret[1] = z - ((z % MOD) > 500 ? z / MOD + 1 : z / MOD) * MOD;
		return ret;
	}

	public static Point decalcToPoint(int z)
	{
		return new Point((z % MOD) > 500 ? z / MOD + 1 : z / MOD, z - ((z % MOD) > 500 ? z / MOD + 1 : z / MOD) * MOD);
	}

	public Karte getAktuelleKarte()
	{
		return this.kartenstapel.peek();
	}

	public List<Karte> getKarten()
	{
		return kartenstapel;
	}

	/**
	 * Berechnet für die aktuelle Karte alle möglichen Positionen.
	 * 
	 * @return
	 */
	public HashMap<Integer, Boolean[]> getPositions()
	{
		HashMap<Integer, Boolean[]> ret = new HashMap<Integer, Boolean[]>();
		Karte akt = this.getAktuelleKarte();
		for (Karte ka : this.map.values())
		{
			for (int i = 0; i < 4; i++)
			{

				int[] pos = ka.getKordinaten();
				if (i == 0)
					pos[1] += 1;
				else if (i == 1)
					pos[0] += 1;
				else if (i == 2)
					pos[1] -= 1;
				else
					pos[0] -= 1;

				if (ka.isOpenSide(i))
				{
					if (!ret.containsKey(calcKey(pos)))
					{
						Boolean[] tutut = new Boolean[4];
						for (int p = 0; p < 4; p++)
						{
							tutut[p] = true;
						}
						ret.put(calcKey(pos), tutut);
					}

					// Alle 4 richtigen ausprobieren.
					for (int j = 0; j < 4; j++)
					{
						boolean past = true;
						for (int k = 0; k < 3; k++)
						{
							if (akt.getSide((4 + i - j + 2) % 4)[k].getTyp() != ka.getSide(i)[2 - k].getTyp())
							{
								past = false;
								break;
							}
						}
						if (!past)
						{
							ret.get(calcKey(pos))[j] = false;
						}
					}
				}
			}
		}


		for (Iterator<Integer> itr = ret.keySet().iterator(); itr.hasNext();)
		{
			Integer key = itr.next();

			boolean delit = false;
			for (int p = 0; p < 4; p++)
			{
				delit = (delit || ret.get(key)[p]);
			}
			if (!delit)
			{
				itr.remove();
			}
		}

		return ret;
	}

	/**
	 * Legt die aktuelle karte auf position x,y mit ausrichtung z und entfernt sie vom kartenstapel
	 * 
	 * @param x
	 *            ist die x Kordinate der aktuellen Karte
	 * @param y
	 *            ist die y Karte der aktullen Karte
	 * @param z
	 *            ist die Ausrichtung der aktuellen Karte wobei 0 nicht gedreht ist und x ist x mal nach rechts gedreht.
	 * @return true wenn einf�gen erfolgreich ansonsten False
	 **/
	public boolean put(int x, int y, int z)
	{
		if (map.containsKey(calcKey(x, y)))
			return false;

		Karte aktKarte = this.kartenstapel.pop();
		aktKarte.setRichtung(z);
		this.insertKarte(x, y, aktKarte);
		aktKarte.setKordinaten(x, y);
		Karte[] nachbarn = new Karte[4];
		if (aktKarte.getMiddle() instanceof Kloster)
		{
			this.kloster.add(aktKarte.getMiddle());
		}

		if (!map.containsKey(calcKey(x, y + 1)))
			nachbarn[0] = null;
		else
		{
			nachbarn[0] = map.get(calcKey(x, y + 1));
			nachbarn[0].closeSide(2);
		}
		if (!map.containsKey(calcKey(x + 1, y)))
			nachbarn[1] = null;
		else
		{
			nachbarn[1] = map.get(calcKey(x + 1, y));
			nachbarn[1].closeSide(3);
		}
		if (!map.containsKey(calcKey(x, y - 1)))
			nachbarn[2] = null;
		else
		{
			nachbarn[2] = map.get(calcKey(x, y - 1));
			nachbarn[2].closeSide(0);
		}
		if (!map.containsKey(calcKey(x - 1, y)))
			nachbarn[3] = null;
		else
		{
			nachbarn[3] = map.get(calcKey(x - 1, y));
			nachbarn[3].closeSide(1);
		}

		aktKarte.merge(nachbarn);

		for (SpielObjekt klos : this.kloster)
		{
			if (klos.isComplete())
			{
				klos.Scoring(false);
			}
		}
		aktKarte.scoreAllComplet();
		return true;
	}

	public void endeGame()
	{
		for (Karte ka : this.map.values())
		{
			ka.scoreAll();
		}
	}
}
