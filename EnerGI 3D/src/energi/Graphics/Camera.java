/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Graphics;
import static org.lwjgl.util.glu.GLU.*;
import energi.Physics.Vector3;
import static org.lwjgl.opengl.GL11.*;

/**
 * Represents a camera viewpoint
 * @author Andrew
 */
public class Camera
{
    Vector3 eye;
    Vector3 center;
    
    /**
     * Draw the camera before drawing the game objects
     */
    public void Draw()
    {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(45.0f, 800.0f / 600.0f, 30.0f, 300.0f);
        
        glMatrixMode(GL_MODELVIEW);
        
        glPushMatrix();
        gluLookAt(eye.x, eye.y, eye.z, center.x, center.y, center.z, 0.0f, 1.0f, 0.0f);
        glPopMatrix();
    }
}
