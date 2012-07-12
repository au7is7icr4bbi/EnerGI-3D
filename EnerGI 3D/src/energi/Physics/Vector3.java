/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Physics;

/**
 * Represents a coordinate in 3D space
 * @author Andrew
 */
public class Vector3 
{
    /**
     * X coordinate
     */
    public float x;
    /**
     * Y coordinate
     */
    public float y;
    /**
     * Z coordinate
     */
    public float z;
    /**
     * Homogenous coordinate flag
     */
    public float w;
    
    /**
     * Returns an OpenGL vector for use in glLight or glMaterial
     * @return A corresponding array of (x, y, z, w) values
     */
    public float[] glVector()
    {
        float vector[] = new float[4];
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
        vector[3] = w;
        return vector;
    }
    
    /**
     * Creates a default Vector3 at (0, 0, 0) with an option for homogenous point or vector
     * @param point If true, vector is a point. Otherwise, it is an infinite line with no direction
     */
    public Vector3(boolean point)
    {
        x = 0;
        y = 0;
        z = 0;
        w = Integer.parseInt(Boolean.toString(point));
    }
    
    /**
     * Create a non-default Vector3 with non-default values
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @param w Homogenous point flag
     */
    public Vector3(float x, float y, float z, float w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    /**
     * Calculate the dot product of two Vectors
     * @param vec The vector you wish to multiply
     * @return A new vector that is the dot product of the two vectors
     */
    public Vector3 dotProduct(Vector3 vec)
    {
        Vector3 vector = new Vector3(true);
        vector.x = x * vec.x;
        vector.y = y * vec.y;
        vector.z = z * vec.z;
        return vector;
    }
    
    /**
     * Calculate the cross product of two Vectors
     * @param vec The vector you wish to multiply
     * @return A new vector that is the cross product of the two vectors
     */
    public Vector3 crossProduct(Vector3 vec)
    {
        Vector3 vector = new Vector3(true);
        vector.x = y * vec.z - z * vec.y;
        vector.y = x * vec.z - z * vec.x;
        vector.z = x * vec.y - y * vec.x;
        return vector;
    }
}
