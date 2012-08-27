package carcassonne.gui;

import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;

public class GUIManager extends SimpleApplication
{

	public GUIManager(AppSettings settings)
	{
		this.settings = settings;
		// TODO Auto-generated constructor stub
		spielScreen = new SpielScreen(this);
	}
	
    public int getHeight()
    {
    	return settings.getHeight();
    }
    
    public int getWidth()
    {
    	return settings.getWidth();
    }
    
    private SpielScreen spielScreen;

	@Override
	public void simpleInitApp()
	{
        flyCam.setEnabled(false);
		spielScreen.init(this.guiFont);
	}
	
    @Override
    public void simpleUpdate(float tpf) 
    {
    	spielScreen.simpleUpdate(tpf);
    }	
}
