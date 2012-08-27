/**
 * 
 */
package carcassonne.gui;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import java.util.HashMap;

/**
 *
 * @author landarzar
 */
public class GameRaster {

    private HashMap<Integer, KarteView> map;
    private static final int MOD = 1000;
    private AssetManager assetManager;

    private static Integer calcKey(int x, int y) {
        return (Integer) (MOD * x) + y;
    }
    
    private Node node;

    public GameRaster(AssetManager assetM, Node node) {
        map = new HashMap<Integer, KarteView>();
        this.assetManager = assetM;
        this.node = node;
    }

    public boolean insert(int x, int y, KarteView card) {
        if (isSet(x, y)) {
            return false;
        }
        
        card.init(assetManager, node, x * 0.62f, y * 0.62f);

        return true;
    }

    public void remove(int x, int y) {
        map.remove(calcKey(x, y));
    }

    public void remove(KarteView view) {
        // TODO: implement

        throw new UnsupportedOperationException("Not implemented jet");
    }

    public boolean isSet(int x, int y) {
        return map.containsKey(calcKey(x, y));
    }

    public KarteView get(int x, int y) {
        return map.get(calcKey(x, y));
    }

    public boolean contains(KarteView view) {
        return map.containsValue(view);
    }
    
    public void update()
    {
    }
}
