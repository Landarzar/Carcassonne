package net.game.carcassonne;
/**
 * 
 */

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.font.BitmapText;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;
import java.util.LinkedList;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();

        app.settings = new AppSettings(true);
        app.settings.setHeight(800);
        app.settings.setWidth(1024);
        app.setShowSettings(false);
        app.start();
    }
    private LinkedList<CardView> views;
    private GameRaster raster;
    private Node spielfeld;
    private Geometry geo;

    private void initGameStuff() {
        raster = new GameRaster(assetManager, spielfeld);

        // Init Startkarte

        CardView view = new CardView(CardFactory.City1Street2Gerade);
        CardView view1 = new CardView(CardFactory.getTexture());
        CardView view2 = new CardView(CardFactory.getTexture());
        CardView view3 = new CardView(CardFactory.getTexture());

        raster.insert(0, 0, view);
        raster.insert(0, 1, view1);
        raster.insert(1, 1, view3);
        raster.insert(0, 2, view2);


        Triangle triangle = new Triangle(-0.2f, 0f, 8f, -0.2f, 0.3f, 8f, -0.4f, 0.15f, 8f);
        geo = new Geometry("triangle", triangle);
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Red);
        geo.setMaterial(material);
        spielfeld.attachChild(geo);
    }

    private void initInput() {
        //Disable Flycam
        flyCam.setEnabled(false);
        // Enable Mouse stuff
        inputManager.addMapping("pick target", new MouseButtonTrigger(0));
        inputManager.addListener(klickListener, "pick target");

        inputManager.addMapping("move up", new KeyTrigger(keyInput.KEY_UP), new KeyTrigger(keyInput.KEY_W));
        inputManager.addMapping("move down", new KeyTrigger(keyInput.KEY_DOWN), new KeyTrigger(keyInput.KEY_S));
        inputManager.addMapping("move left", new KeyTrigger(keyInput.KEY_LEFT), new KeyTrigger(keyInput.KEY_A));
        inputManager.addMapping("move right", new KeyTrigger(keyInput.KEY_RIGHT), new KeyTrigger(keyInput.KEY_D));
        inputManager.addMapping("move zoomout", new MouseAxisTrigger(mouseInput.AXIS_WHEEL, true), new KeyTrigger(keyInput.KEY_Q));
        inputManager.addMapping("move zoomin", new MouseAxisTrigger(mouseInput.AXIS_WHEEL, false), new KeyTrigger(keyInput.KEY_E));
        inputManager.addListener(movementListener, "move up", "move down", "move left", "move right", "move zoomin", "move zoomout");

    }

    @Override
    public void simpleInitApp() {

        spielfeld = new Node("Spielfeld");
        rootNode.attachChild(spielfeld);
        CardFactory.Init(assetManager);
        initGameStuff();
        initInput();

        Spatial figure = assetManager.loadModel("assets/Models/fig.j3o");
        figure.setLocalScale(0.2f);
        figure.setLocalTranslation(0, 2f, 8f);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md"); // default material
        figure.setMaterial(mat);
        rootNode.attachChild(figure);

        /** Must add a light to make the lit object visible! */
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(1, 0, -2).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);

        /** Test HUD */
        BitmapText hudText = new BitmapText(guiFont, false);
        hudText.setSize(guiFont.getCharSet().getRenderedSize());      // font size
        hudText.setColor(ColorRGBA.Blue);                             // font color
        hudText.setText("You can write any string here");             // the text
        hudText.setLocalTranslation(300, hudText.getLineHeight(), 0); // position
        guiNode.attachChild(hudText);

        /** Stats off & Frames on */
        setDisplayStatView(false);
        setDisplayFps(true);
    }

    @Override
    public void simpleUpdate(float tpf) {
        Vector3f pos = cam.getLocation();
        Vector3f dir = cam.getDirection();

        if (moveup) {
            pos.y += 4 * tpf;
        }
        if (movedown) {
            pos.y -= 4 * tpf;
        }
        if (moveright) {
            pos.x += 4 * tpf;
        }
        if (moveleft) {
            pos.x -= 4 * tpf;
        }

        cam.setLocation(pos);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    private boolean moveup = false;
    private boolean movedown = false;
    private boolean moveright = false;
    private boolean moveleft = false;
    private ActionListener movementListener = new ActionListener() {

        public void onAction(String name, boolean isPressed, float tpf) {


            if (name.equals("move up")) {
                moveup = isPressed;
            }
            if (name.equals("move down")) {
                movedown = isPressed;
            }
            if (name.equals("move left")) {
                moveleft = isPressed;
            }
            if (name.equals("move right")) {
                moveright = isPressed;
            }

            if (name.equals("move zoomin")) {
                Vector3f pos = cam.getLocation();
                pos.z -= 0.5;
                cam.setLocation(pos);

                // Rotationstest
//                Quaternion rota = cam.getRotation();
//                float [] dings = rota.toAngles(null);
//                
//                for(int i = 0; i <dings.length; ++i)
//                {
//                    System.out.println("Angle " + i + " ist " + dings[i]);
//                }
//                
//                dings[2] = (float) Math.PI / 2;
//                
//                cam.setRotation(rota.fromAngles(dings));
            }

            if (name.equals("move zoomout")) {
                Vector3f pos = cam.getLocation();
                pos.z += 0.5;
                cam.setLocation(pos);
            }
        }
    };
    /** Pick a Target Using the Mouse Pointer. <ol><li>Map "pick target" action to a MouseButtonTrigger. <li>flyCam.setEnabled(false); <li>inputManager.setCursorVisible(true); <li>Implement action in AnalogListener (TODO).</ol>
     */
    private AnalogListener klickListener = new AnalogListener() {

        public void onAnalog(String name, float intensity, float tpf) {
            if (name.equals("pick target")) {
                // Reset results list.
                CollisionResults results = new CollisionResults();
                // Convert screen click to 3d position
                Vector2f click2d = inputManager.getCursorPosition();
                Vector3f click3d = cam.getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 0f).clone();
                Vector3f dir = cam.getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 1f).subtractLocal(click3d);
                // Aim the ray from the clicked spot forwards.
                Ray ray = new Ray(click3d, dir);
                // Collect intersections between ray and all nodes in results list.
                rootNode.collideWith(ray, results);
                // (Print the results so we see what is going on:)
                for (int i = 0; i < results.size(); i++) {
                    // (For each "hit", we know distance, impact point, geometry.)
                    float dist = results.getCollision(i).getDistance();
                    Vector3f pt = results.getCollision(i).getContactPoint();
                    String target = results.getCollision(i).getGeometry().getName();
                    System.out.println("Selection #" + i + ": " + target + " at " + pt + ", " + dist + " WU away.");
                }

                if (results.getClosestCollision() != null) {
                    System.out.println("Select: " + results.getClosestCollision().getGeometry().getName());
                    if (results.getClosestCollision().getGeometry() == geo) {

                        CardView view1 = new CardView(CardFactory.getTexture());

                        raster.insert(-1, 0, view1);
                        spielfeld.detachChild(geo);
                    }
                }

                // Use the results -- we rotate the selected geometry.
                if (results.size() > 0) {
                    // The closest result is the target that the player picked:
                    Geometry target = results.getClosestCollision().getGeometry();
                    // Here comes the action:
                    if (target.getName().equals("Red Box")) {
                        target.rotate(0, -intensity, 0); // TODO
                    }
                }
            }
        }
    };
}
