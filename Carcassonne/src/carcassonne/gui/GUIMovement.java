package carcassonne.gui;

import com.jme3.collision.CollisionResults;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Plane;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;

public class GUIMovement
{
	public GUIMovement(SpielScreen screen)
	{
		this.screen = screen;
	}

	private SpielScreen screen;

	public void init()
	{
		InputManager inputManager = screen.getManager().getInputManager();
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

		initMark();
	}

	public void update(float tpf)
	{
		Camera cam = screen.getManager().getCamera();
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
			Camera cam = screen.getManager().getCamera();

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

	public GeoFu selected;

	/** A red ball that marks the last spot that was "hit" by the "shot". */
	protected void initMark()
	{
		Sphere sphere = new Sphere(30, 30, 0.2f);
		mark = new Geometry("BOOM!", sphere);
		Material mark_mat = new Material(this.screen.getManager().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
		mark_mat.setColor("Color", ColorRGBA.Red);
		mark.setMaterial(mark_mat);
	}

	private Geometry mark;

	private AnalogListener klickListener = new AnalogListener()
	{

		public void onAnalog(String name, float intensity, float tpf)
		{
			Camera cam = screen.getManager().getCamera();
			InputManager inputManager = screen.getManager().getInputManager();
			Node rootNode = screen.getManager().getRootNode();

			if (name.equals("pick target"))
			{
				// Reset results list.
				CollisionResults results = new CollisionResults();
				// Convert screen click to 3d position
				Vector2f click2d = inputManager.getCursorPosition();
				Vector3f click3d = cam.getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 0f).clone();
				Vector3f dir = cam.getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 1f).subtractLocal(click3d).normalizeLocal();

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

					if (results.getClosestCollision().getGeometry() instanceof GeoFu)
					{
						GeoFu fu = (GeoFu) results.getClosestCollision().getGeometry();

						// screen.getRaster().insert(i, i, null);

						if (selected == null)
						{
							selected = fu;

							fu.getMaterial().setColor("Color", ColorRGBA.Red);
						}
					}
				}

				if (selected != null)
				{
					Vector3f vec = new Vector3f();
					Plane p = new Plane();
					p.setPlanePoints(new Vector3f(1, 0, 0), new Vector3f(0, 1, 0), new Vector3f(1, 1, 0));
					if (ray.intersectsWherePlane(p, vec))
					{
						System.out.println("Iam at Pos: x: " + vec.x + " y: " + vec.y + " z: " + vec.z);
						selected.setLocalTranslation(vec);
						rootNode.attachChild(selected);
						mark.center().setLocalTranslation(vec);
						rootNode.attachChild(mark);

						System.out.println("Mark World trans: " + mark.getWorldTransform().toString());
						System.out.println("Mark World trans: " + mark.getLocalTransform().toString());

						System.out.println("Sel World trans: " + selected.getWorldTransform().toString());
						System.out.println("Sel World trans: " + selected.getLocalTransform().toString());
					}
				}
			}
		}
	};
}
