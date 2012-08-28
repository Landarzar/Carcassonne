package carcassonne.gui;

import carcassonne.model.Spiel;

import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapFont;
import com.jme3.input.InputManager;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class SpielScreen
{
	public SpielScreen(GUIManager manager)
	{
		this.manager = manager;
	}

	private GUIManager manager;

	public GUIManager getManager()
	{
		return manager;
	}

	private InputManager inputManager;
	private AssetManager assetManager;
	private Node rootNode;
	private Camera cam;
	private Node guiNode;
	private BitmapFont guiFont;

	private HUD hud;
	private GameRaster raster;
	private Node spielfeld;
	private Spiel spiel;
	private GUIMovement movementManager;
	private SpielLogik logik;

	public void init(BitmapFont guiFont)
	{
		this.assetManager = manager.getAssetManager();
		this.inputManager = manager.getInputManager();
		this.cam = manager.getCamera();

		this.rootNode = manager.getRootNode();
		this.guiNode = manager.getGuiNode();
		this.guiFont = guiFont;

		movementManager = new GUIMovement(this);
		spielfeld = new Node("Spielfeld");
		rootNode.attachChild(spielfeld);
		GUIKarte.Init(assetManager);
		raster = new GameRaster(assetManager, spielfeld);
		movementManager.init();
		initModel();

		setSpiel(SpielFabrik.createNormalGame());
//		setSpiel(SpielFabrik.createAbnormalGame());
		initGameStuff();

		hud = new HUD(guiNode, guiFont, manager, this);

		logik = new SpielLogik(this);
		logik.showTriangles();
	}

	GUIKarte view;
	private Spatial figure;

	private void initGameStuff()
	{
		// Init Startkarte

		// KarteView

		view = (GUIKarte) spiel.getAktuelleKarte();
		raster.insert(0, 0, view);
		spiel.put(0, 0, 0);

		GUIKarte view2 = (GUIKarte) spiel.getAktuelleKarte();
		raster.insert(1, -1, view2);
		spiel.put(1, -1, 0);
	}

	private void initModel()
	{
		figure = assetManager.loadModel("assets/Models/fig.j3o");
		figure.setLocalScale(0.2f);
		figure.setLocalTranslation(0, 2f, 8f);
		Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md"); // default material
		// mat.setColor("Color", ColorRGBA.randomColor());
		mat.setTexture("NormalMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond_normal.png"));
		mat.setBoolean("UseMaterialColors", true);
		mat.setColor("Specular", ColorRGBA.White);
		mat.setColor("Diffuse", ColorRGBA.White);
		mat.setFloat("Shininess", 5f); // [1,128]
		figure.setMaterial(mat);
		rootNode.attachChild(figure);

		// ** Must add a light to make the lit object visible! *//*
		DirectionalLight sun = new DirectionalLight();
		sun.setDirection(new Vector3f(1, 0, -2).normalizeLocal());
		sun.setColor(ColorRGBA.White);
		rootNode.addLight(sun);
	}

	public void simpleUpdate(float tpf)
	{
		hud.onUpdate();
		movementManager.update(tpf);
		figure.rotate(1.5f * tpf, 2f * tpf, .5f * tpf);
	}

	public Spiel getSpiel()
	{
		return spiel;
	}

	public void setSpiel(Spiel spiel)
	{
		this.spiel = spiel;
	}

}
