package carcassonne.gui;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.util.BufferUtils;

/**
 *
 * @author Landarzar
 */
public class Triangle extends Mesh
{

    public Triangle(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3)
    {
        super();

        Vector3f[] vertices = new Vector3f[4];
        vertices[0] = new Vector3f(x1, y1, z1);
        vertices[1] = new Vector3f(x2, y2, z2);
        vertices[2] = new Vector3f(x3, y3, z3);

        Vector2f[] texCoord = new Vector2f[4];
        texCoord[0] = new Vector2f(0, 0);
        texCoord[1] = new Vector2f(1, 0);
        texCoord[2] = new Vector2f(0, 1);

        int[] indexes = {2, 0, 1};

        this.setBuffer(Type.Position, 3, BufferUtils.createFloatBuffer(vertices));
        this.setBuffer(Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        this.setBuffer(Type.Index, 3, BufferUtils.createIntBuffer(indexes));
        this.updateBound();
    }
}
