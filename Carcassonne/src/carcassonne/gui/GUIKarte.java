package carcassonne.gui;

import java.util.Random;

import carcassonne.model.Karte;
import carcassonne.model.Kloster;
import carcassonne.model.SpielObjekt;
import carcassonne.model.Stadt;
import carcassonne.model.Straße;
import carcassonne.model.Wiese;

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
		this.getFields();
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

    private void getFields() {
		if (this.texture == City1Street2) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Wiese[] wis2 = new Wiese[1];
			wis2[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[0];
			side2[1] = sr1;
			side2[2] = wis2[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis2[0];
			side3[1] = sr1;
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);	
		}
		else if (this.texture == City1Street2Gerade) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Wiese[] wis2 = new Wiese[1];
			wis2[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = sr1;
			side0[2] = wis2[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis2[0];
			side1[1] = wis2[0];
			side1[2] = wis2[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis2[0];
			side2[1] = sr1;
			side2[2] = wis1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(sr1);	
		}
		else if (this.texture == City1Street2Right) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Wiese[] wis2 = new Wiese[1];
			wis2[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = sr1;
			side1[2] = wis2[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis2[0];
			side2[1] = sr1;
			side2[2] = wis1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[0];
			side3[1] = wis1[0];
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(sr1);
		}
		else if (this.texture == City1Street3) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Wiese[] wis2 = new Wiese[2];
			wis2[0] = new Wiese(this);
			wis2[1] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			Straße sr2 = new Straße(this,false);
			Straße sr3 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = sr1;
			side0[2] = wis2[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis2[0];
			side1[1] = sr2;
			side1[2] = wis2[1];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis2[1];
			side2[1] = sr3;
			side2[2] = wis1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);
			
		}
		else if (this.texture == City1Wiese) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = wis1[0];
			side0[2] = wis1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[0];
			side2[1] = sts1[0];
			side2[2] = sts1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[0];
			side3[1] = wis1[0];
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);
		}
		else if (this.texture == City2Conn) {
			Wiese[] wis1 = new Wiese[2];
			wis1[0] = new Wiese(this);
			wis1[1] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			wis1[1].setStädte(sts1);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = wis1[0];
			side0[2] = wis1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = sts1[0];
			side1[1] = sts1[0];
			side1[2] = sts1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[1];
			side2[1] = wis1[1];
			side2[2] = wis1[1];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(sts1[0]);
		}
		else if (this.texture == City2SplitWiese) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[2];
			sts1[0] = new Stadt(this, 0, wis1, false);
			sts1[1] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[1];
			side2[1] = sts1[1];
			side2[2] = sts1[1];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[0];
			side3[1] = wis1[0];
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);	
		}
		else if (this.texture == City2SplitWiese2) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[2];
			sts1[0] = new Stadt(this, 0, wis1, false);
			sts1[1] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[0];
			side2[1] = wis1[0];
			side2[2] = wis1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[1];
			side3[1] = sts1[1];
			side3[2] = sts1[1];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);
		}
		else if (this.texture == City2Street2) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Wiese[] wis2 = new Wiese[1];
			wis2[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = sts1[0];
			side1[1] = sts1[0];
			side1[2] = sts1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[0];
			side2[1] = sr1;
			side2[2] = wis2[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis2[0];
			side3[1] = sr1;
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(sr1);
		}
		else if (this.texture == City2WappenConn) {
			Wiese[] wis1 = new Wiese[2];
			wis1[0] = new Wiese(this);
			wis1[1] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 1, wis1, false);
			wis1[0].setStädte(sts1);
			wis1[1].setStädte(sts1);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[0];
			side2[1] = sts1[0];
			side2[2] = sts1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[1];
			side3[1] = wis1[1];
			side3[2] = wis1[1];
			this.setSide3(side3);
			this.setMiddle(sts1[0]);
		}
		else if (this.texture == City2WappenStreet2) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Wiese[] wis2 = new Wiese[1];
			wis2[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 1, wis1, false);
			wis1[0].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = sr1;
			side0[2] = wis2[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis2[0];
			side1[1] = sr1;
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[0];
			side2[1] = sts1[0];
			side2[2] = sts1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);
		}
		else if (this.texture == City2WappenWiese) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 1, wis1, false);
			wis1[0].setStädte(sts1);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = wis1[0];
			side0[2] = wis1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[0];
			side2[1] = sts1[0];
			side2[2] = sts1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);
		}
		else if (this.texture == City2Wiese) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = wis1[0];
			side0[2] = wis1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[0];
			side2[1] = sts1[0];
			side2[2] = sts1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);
		}
		else if (this.texture == City3Street) {
			Wiese[] wis1 = new Wiese[2];
			wis1[0] = new Wiese(this);
			wis1[1] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			wis1[1].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = sr1;
			side1[2] = wis1[1];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[0];
			side2[1] = sts1[0];
			side2[2] = sts1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(sts1[0]);
		}
		else if (this.texture == City3WappenStreet) {
			Wiese[] wis1 = new Wiese[2];
			wis1[0] = new Wiese(this);
			wis1[1] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 1, wis1, false);
			wis1[0].setStädte(sts1);
			wis1[1].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = sr1;
			side1[2] = wis1[1];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[0];
			side2[1] = sts1[0];
			side2[2] = sts1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(sts1[0]);
		}
		else if (this.texture == City3WappenWiese) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 1, wis1, false);
			wis1[0].setStädte(sts1);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[0];
			side2[1] = sts1[0];
			side2[2] = sts1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(sts1[0]);
		}
		else if (this.texture == City3Wiese) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 0, wis1, false);
			wis1[0].setStädte(sts1);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = sts1[0];
			side1[1] = sts1[0];
			side1[2] = sts1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[0];
			side2[1] = wis1[0];
			side2[2] = wis1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(sts1[0]);
		}
		else if (this.texture == City4Wappen) {
			Wiese[] wis1 = new Wiese[0];
			Stadt[] sts1 = new Stadt[1];
			sts1[0] = new Stadt(this, 1, wis1, false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = sts1[0];
			side0[1] = sts1[0];
			side0[2] = sts1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = sts1[0];
			side1[1] = sts1[0];
			side1[2] = sts1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = sts1[0];
			side2[1] = sts1[0];
			side2[2] = sts1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = sts1[0];
			side3[1] = sts1[0];
			side3[2] = sts1[0];
			this.setSide3(side3);
			this.setMiddle(sts1[0]);
		}
		else if (this.texture == Kloster) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[0];
			wis1[0].setStädte(sts1);
			Kloster klos = new Kloster(this);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = wis1[0];
			side0[2] = wis1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[0];
			side2[1] = wis1[0];
			side2[2] = wis1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[0];
			side3[1] = wis1[0];
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(klos);
		}
		else if (this.texture == KlosterStreet) {
			Wiese[] wis1 = new Wiese[1];
			wis1[0] = new Wiese(this);
			Stadt[] sts1 = new Stadt[0];
			wis1[0].setStädte(sts1);
			Kloster klos = new Kloster(this);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = wis1[0];
			side0[2] = wis1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = sr1;
			side1[2] = wis1[0];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[0];
			side2[1] = wis1[0];
			side2[2] = wis1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[0];
			side3[1] = wis1[0];
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(klos);
		}
		else if (this.texture == Street2) {
			Wiese[] wis1 = new Wiese[2];
			wis1[0] = new Wiese(this);
			wis1[1] = new Wiese(this);
			Stadt[] sts1 = new Stadt[0];
			wis1[0].setStädte(sts1);
			wis1[1].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = wis1[0];
			side0[2] = wis1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = sr1;
			side1[2] = wis1[1];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[1];
			side2[1] = wis1[1];
			side2[2] = wis1[1];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[1];
			side3[1] = sr1;
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(sr1);
		}
		else if (this.texture == Street2Left) {
			Wiese[] wis1 = new Wiese[2];
			wis1[0] = new Wiese(this);
			wis1[1] = new Wiese(this);
			Stadt[] sts1 = new Stadt[0];
			wis1[0].setStädte(sts1);
			wis1[1].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = wis1[0];
			side0[2] = wis1[0];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[0];
			side1[1] = wis1[0];
			side1[2] = wis1[1];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[0];
			side2[1] = sr1;
			side2[2] = wis1[1];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[1];
			side3[1] = sr1;
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(sr1);
		}
		else if (this.texture == Street3) {
			Wiese[] wis1 = new Wiese[3];
			wis1[0] = new Wiese(this);
			wis1[1] = new Wiese(this);
			wis1[2] = new Wiese(this);
			Stadt[] sts1 = new Stadt[0];
			wis1[0].setStädte(sts1);
			wis1[1].setStädte(sts1);
			wis1[2].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			Straße sr2 = new Straße(this,false);
			Straße sr3 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = sr1;
			side0[2] = wis1[1];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[1];
			side1[1] = sr2;
			side1[2] = wis1[2];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[2];
			side2[1] = sr3;
			side2[2] = wis1[0];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[0];
			side3[1] = wis1[0];
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);
		}
		else if (this.texture == Street4) {
			Wiese[] wis1 = new Wiese[4];
			wis1[0] = new Wiese(this);
			wis1[1] = new Wiese(this);
			wis1[2] = new Wiese(this);
			wis1[3] = new Wiese(this);
			Stadt[] sts1 = new Stadt[0];
			wis1[0].setStädte(sts1);
			wis1[1].setStädte(sts1);
			wis1[2].setStädte(sts1);
			wis1[3].setStädte(sts1);
			Straße sr1 = new Straße(this,false);
			Straße sr2 = new Straße(this,false);
			Straße sr3 = new Straße(this,false);
			Straße sr4 = new Straße(this,false);
			
			SpielObjekt[] side0 = new SpielObjekt[3];
			side0[0] = wis1[0];
			side0[1] = sr1;
			side0[2] = wis1[1];
			this.setSide0(side0);
			SpielObjekt[] side1 = new SpielObjekt[3];
			side1[0] = wis1[1];
			side1[1] = sr2;
			side1[2] = wis1[2];
			this.setSide1(side1);
			SpielObjekt[] side2 = new SpielObjekt[3];
			side2[0] = wis1[2];
			side2[1] = sr3;
			side2[2] = wis1[3];
			this.setSide2(side2);
			SpielObjekt[] side3 = new SpielObjekt[3];
			side3[0] = wis1[3];
			side3[1] = sr4;
			side3[2] = wis1[0];
			this.setSide3(side3);
			this.setMiddle(wis1[0]);
		}
		
		
		
	}
    
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
