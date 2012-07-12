/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Graphics;
import energi.Physics.Vector3;
import static org.lwjgl.opengl.GL11.*;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

/**
 * Represents a lighting object in 3D space
 * @author Andrew
 */
public class Light
{
    private static int lightCount = 0;
    private int id;
    private Color specular;
    private Color diffuse;
    private Color ambient;
    private Vector3 position;
    private boolean isSpot;
    private Vector3 direction;
    private float angle;
    
    /**
     * Create a point light source or a distant light source
     * @param s Specular
     * @param d Diffuse
     * @param a Ambient
     * @param pos Light position
     */
    public Light(Color s, Color d, Color a, Vector3 pos)
    {
        id = GL_LIGHT0 + lightCount;
        specular = s;
        diffuse = d;
        ambient = a;
        position = pos;
        lightCount++;
    }
    
    /**
     * Create a spotlight point source (or a distant light, 
     * equivalent to using a homogenous position coordinate in the above constructor)
     * @param s Specular
     * @param d Diffuse
     * @param a Ambient
     * @param pos Source position
     * @param angle Angle of light cone
     * @param direction Direction of spot light
     */
    public Light(Color s, Color d, Color a, Vector3 pos, float angle, Vector3 direction)
    {
        id = GL_LIGHT0 + lightCount;
        specular = s;
        diffuse = d;
        ambient = a;
        position = pos;
        isSpot = true;
        this.angle = angle;
        this.direction = direction;
        lightCount++;
    }
    
    /**
     * Toggle the state of a light
     * @param on A boolean indicating whether the light is on or off
     */
    public void toggle(boolean on)
    {
        glLight(id, GL_SPECULAR, FloatBuffer.wrap(specular.glVector()));
        glLight(id, GL_DIFFUSE, FloatBuffer.wrap(diffuse.glVector()));
        glLight(id, GL_AMBIENT, FloatBuffer.wrap(diffuse.glVector()));
        glLight(id, GL_POSITION, FloatBuffer.wrap(position.glVector()));
        if (isSpot)
        {
            glLight(id, GL_SPOT_DIRECTION, FloatBuffer.wrap(direction.glVector()));
            glLightf(id, GL_SPOT_CUTOFF, angle);
        }
        if (on)
            glEnable(id);
    }
    
    /**
     * Enable in-game manual lighting
     */
    public static void enable()
    {
        glEnable(GL_LIGHTING);
    }
    
    /**
     * Set the ambient color for global lighting
     * @param ambient The ambient color intensity
     */
    public static void globalLight(Color ambient)
    {
        glLightModel(GL_LIGHT_MODEL_AMBIENT, FloatBuffer.wrap(ambient.glVector()));
    }
}
