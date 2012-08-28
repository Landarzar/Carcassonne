package carcassonne.gui;

import com.jme3.asset.AssetManager;
import com.jme3.collision.CollisionResults;
import com.jme3.font.BitmapFont;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class SpielScreen
{
	public SpielScreen(GUIManager manager)
	{
		this.manager = manager;
	}

	private GUIManager manager;
	private InputManager inputManager;
	private AssetManager assetManager;
	private Node rootNode;
	private Camera cam;
	private Node guiNode;
	private BitmapFont guiFont;

	private HUD hud;
	private GameRaster raster;
	private Node spielfeld;

	public void init(BitmapFont guiFont)
	{
		this.assetManager = manager.getAssetManager();
		this.inputManager = manager.getInputManager();
		this.cam = manager.getCamera();

		this.rootNode = manager.getRootNode();
		this.guiNode = manager.getGuiNode();
		this.guiFont = guiFont;

		spielfeld = new Node("Spielfeld");
		rootNode.attachChild(spielfeld);
		GUIKarte.Init(assetManager);
		raster = new GameRaster(assetManager, spielfeld);
		initGameStuff();
		initInput();
		initModel();

		hud = new HUD(guiNode, guiFont, manager);
	}

	GUIKarte view;

	private void initGameStuff()
	{
		// Init Startkarte

		// KarteView
		view = new GUIKarte(GUIKarte.City1Street2Gerade);

		raster.insert(0, 0, view);

		// Triangle triangle = new Triangle(-0.2f, 0f, 8f, -0.2f, 0.3f, 8f, -0.4f, 0.15f, 8f);
		// geo = new Geometry("triangle", triangle);
		// Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		// material.setColor("Color", ColorRGBA.Red);
		// geo.setMaterial(material);
		// spielfeld.attachChild(geo);
	}

	private Spatial figure;

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

	private void initInput()
	{
		// Enable Mouse stuff
		inputManager.addMapping("pick target", new MouseButtonTrigger(0));
		inputManager.addListener(klickListener, "pick target");

		inputManager.addMapping("move up", new KeyTrigger(KeyInput.KEY_UP), new KeyTrigger(KeyInput.KEY_W));
		inputManager.addMapping("move down", new KeyTrigger(KeyInput.KEY_DOWN), new KeyTrigger(KeyInput.KEY_S));
		inputManager.addMapping("move left", new KeyTrigger(KeyInput.KEY_LEFT), new KeyTrigger(KeyInput.KEY_A));
		inputManager.addMapping("move right", new KeyTrigger(KeyInput.KEY_RIGHT), new KeyTrigger(KeyInput.KEY_D));
		inputManager.addMapping("mouse move x up", new MouseAxisTrigger(MouseInput.AXIS_X, false));
		inputManager.addMapping("mouse move x down", new MouseAxisTrigger(MouseInput.AXIS_X, true));
		inputManager.addMapping("mouse move y up", new MouseAxisTrigger(MouseInput.AXIS_Y, false));
		inputManager.addMapping("mouse move y down", new MouseAxisTrigger(MouseInput.AXIS_Y, true));
		inputManager.addMapping("mouse left down", new MouseButtonTrigger(0));
		inputManager.addMapping("move zoomout", new MouseAxisTrigger(MouseInput.AXIS_WHEEL, true), new KeyTrigger(KeyInput.KEY_Q));
		inputManager.addMapping("move zoomin", new MouseAxisTrigger(MouseInput.AXIS_WHEEL, false), new KeyTrigger(KeyInput.KEY_E));
		inputManager.addListener(keymoveListener, "move up", "move down", "move left", "move right", "move zoomin", "move zoomout", "mouse left down");
	}

	public void simpleUpdate(float tpf)
	{

		Vector3f pos = cam.getLocation();

		if (moveup)
		{
			pos.y += 4 * tpf;
		}
		if (movedown)
		{
			pos.y -= 4 * tpf;
		}
		if (moveright)
		{
			pos.x += 4 * tpf;
		}
		if (moveleft)
		{
			pos.x -= 4 * tpf;
		}

		cam.setLocation(pos);

		figure.rotate(1.5f * tpf, 2f * tpf, .5f * tpf);

		if (mouseleftdown)
		{

		}
	}

	private boolean moveup = false;
	private boolean movedown = false;
	private boolean moveright = false;
	private boolean moveleft = false;
	private boolean mouseleftdown = false;

	private ActionListener keymoveListener = new ActionListener()
	{

		public void onAction(String name, boolean isPressed, float tpf)
		{

			if (name.equals("move up"))
			{
				moveup = isPressed;
			}
			if (name.equals("move down"))
			{
				movedown = isPressed;
			}
			if (name.equals("move left"))
			{
				moveleft = isPressed;
			}
			if (name.equals("move right"))
			{
				moveright = isPressed;
			}

			if (name.equals("move zoomin"))
			{
				Vector3f pos = cam.getLocation();
				pos.z -= 0.5;
				cam.setLocation(pos);
			}

			if (name.equals("move zoomout"))
			{
				Vector3f pos = cam.getLocation();
				pos.z += 0.5;
				cam.setLocation(pos);
			}

			if (name.equals("mouse left down"))
			{
				mouseleftdown = isPressed;
			}
		}
	};

	private Geometry picked = null;

	private AnalogListener klickListener = new AnalogListener()
	{

		public void onAnalog(String name, float intensity, float tpf)
		{
			if (name.equals("pick target"))
			{
				// Reset results list.
				CollisionResults results = new CollisionResults();
				// Convert screen click to 3d position
				Vector2f click2d = inputManager.getCursorPosition();
				Vector3f click3d = cam.getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 8f);
				Vector3f dir = cam.getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 0f).subtractLocal(click3d);
				// Aim the ray from the clicked spot forwards.
				Ray ray = new Ray(click3d, dir);
				// Collect intersections between ray and all nodes in results list.
				rootNode.collideWith(ray, results);
				// (Print the results so we see what is going on:)
				for (int i = 0; i < results.size(); i++)
				{
					// (For each "hit", we know distance, impact point, geometry.)
					float dist = results.getCollision(i).getDistance();
					Vector3f pt = results.getCollision(i).getContactPoint();
					String target = results.getCollision(i).getGeometry().getName();
					System.out.println("Selection #" + i + ": " + target + " at " + pt + ", " + dist + " WU away.");
					
				}

				if (results.getClosestCollision() != null)
				{
					System.out.println("Select: " + results.getClosestCollision().getGeometry().getName());
				}

				// Use the results -- we rotate the selected geometry.
				if (results.size() > 0)
				{
					// The closest result is the target that the player picked:
					Geometry target = results.getClosestCollision().getGeometry();
					// Here comes the action:
					if (target.getName().equals("Red Box"))
					{
						target.rotate(0, -intensity, 0); // TODO
					}
				}
			}
		}
	};
}
