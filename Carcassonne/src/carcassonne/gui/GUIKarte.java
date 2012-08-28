package carcassonne.gui;

import java.util.Random;

import carcassonne.model.Karte;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;

/**
 * 
 * @author Landarzar
 */
public class GUIKarte extends Karte
{

	private Box shape;
	private Geometry geometry;
	private Material material;
	private Texture texture;

	public Geometry getGeometry()
	{
		return geometry;
	}

	public Material getMaterial()
	{
		return material;
	}

	public Box getShape()
	{
		return shape;
	}

	public Texture getTexture()
	{
		return texture;
	}

	public GUIKarte(Texture texture)
	{
		this.texture = texture;
		this.init = false;
	}

	private boolean init = false;

	public void init(AssetManager assetManager, Node node, float x, float y)
	{
		shape = new Box(new Vector3f(x, y, 8f), 0.3f, 0.3f, 0.01f);
		geometry = new Geometry(texture.getName(), shape);
		material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		material.setTexture("ColorMap", texture);
		material.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
		geometry.setMaterial(material);
		init = true;

		node.attachChild(geometry);
	}

	public void simpleUpdate(float tpf)
	{
		// TODO: add update code
	}

	public void simpleRender(RenderManager rm)
	{
		// TODO: add render code
	}
	
    static void Init(AssetManager assetManager)
    {
        City1Street2 = assetManager.loadTexture("assets/Textures/Cards/City1Street2.png");

        City1Street2Gerade = assetManager.loadTexture("assets/Textures/Cards/City1Street2Gerade.png");

        City1Street2Right = assetManager.loadTexture("assets/Textures/Cards/City1Street2Right.png");

        City1Street3 = assetManager.loadTexture("assets/Textures/Cards/City1Street3.png");

        City1Wiese = assetManager.loadTexture("assets/Textures/Cards/City1Wiese.png");

        City2Conn = assetManager.loadTexture("assets/Textures/Cards/City2Conn.png");

        City2SplitWiese = assetManager.loadTexture("assets/Textures/Cards/City2SplitWiese.png");

        City2SplitWiese2 = assetManager.loadTexture("assets/Textures/Cards/City2SplitWiese2.png");

        City2Street2 = assetManager.loadTexture("assets/Textures/Cards/City2Street2.png");

        City2WappenConn = assetManager.loadTexture("assets/Textures/Cards/City2WappenConn.png");

        City2WappenStreet2 = assetManager.loadTexture("assets/Textures/Cards/City2WappenStreet2.png");

        City2WappenWiese = assetManager.loadTexture("assets/Textures/Cards/City2WappenWiese.png");

        City2Wiese = assetManager.loadTexture("assets/Textures/Cards/City2Wiese.png");

        City3Street = assetManager.loadTexture("assets/Textures/Cards/City3Street.png");

        City3WappenStreet = assetManager.loadTexture("assets/Textures/Cards/City3WappenStreet.png");

        City3Wiese = assetManager.loadTexture("assets/Textures/Cards/City3Wiese.png");

        City3WappenWiese = assetManager.loadTexture("assets/Textures/Cards/City3WappenWiese.png");

        City4Wappen = assetManager.loadTexture("assets/Textures/Cards/City4Wappen.png");

        Kloster = assetManager.loadTexture("assets/Textures/Cards/Kloster.png");

        KlosterStreet = assetManager.loadTexture("assets/Textures/Cards/KlosterStreet.png");

        Street2 = assetManager.loadTexture("assets/Textures/Cards/Street2.png");

        Street2Left = assetManager.loadTexture("assets/Textures/Cards/Street2Left.png");

        Street3 = assetManager.loadTexture("assets/Textures/Cards/Street3.png");

        Street4 = assetManager.loadTexture("assets/Textures/Cards/Street4.png");
    }
    public static Texture City1Street2;
    public static Texture City1Street2Gerade;
    public static Texture City1Street2Right;
    public static Texture City1Street3;
    public static Texture City1Wiese;
    public static Texture City2Conn;
    public static Texture City2SplitWiese;
    public static Texture City2SplitWiese2;
    public static Texture City2Street2;
    public static Texture City2WappenConn;
    public static Texture City2WappenStreet2;
    public static Texture City2WappenWiese;
    public static Texture City2Wiese;
    public static Texture City3Street;
    public static Texture City3WappenStreet;
    public static Texture City3Wiese;
    public static Texture City3WappenWiese;
    public static Texture City4Wappen;
    public static Texture Kloster;
    public static Texture KlosterStreet;
    public static Texture Street2;
    public static Texture Street2Left;
    public static Texture Street3;
    public static Texture Street4;

    public static Texture getRandomTexture()
    {
        Random rand = new Random(System.currentTimeMillis());

        int nr = rand.nextInt(24);

        switch (nr) {
            case 0:
                return City1Street2;
            case 1:
                return City1Street2Gerade;
            case 2:
                return City1Street2Right;
            case 3:
                return City1Street3;
            case 4:
                return City1Wiese;
            case 5:
                return City2Conn;
            case 6:
                return City2SplitWiese;
            case 7:
                return City2SplitWiese2;
            case 8:
                return City2Street2;
            case 9:
                return City2WappenConn;
            case 10:
                return City2WappenStreet2;
            case 11:
                return City2WappenWiese;
            case 12:
                return City2Wiese;
            case 13:
                return City3Street;
            case 14:
                return City3WappenStreet;
            case 15:
                return City3Wiese;
            case 16:
                return City3WappenWiese;
            case 17:
                return City4Wappen;
            case 18:
                return Kloster;
            case 19:
                return KlosterStreet;
            case 20:
                return Street2;
            case 21:
                return Street2Left;
            case 22:
                return Street3;
            case 23:
                return Street4;
        }
        
        return null;
    }
}
