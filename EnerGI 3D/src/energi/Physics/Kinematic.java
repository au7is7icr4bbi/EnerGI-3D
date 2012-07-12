/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Physics;
import energi.Core.GameObject;

/**
 * Base class for any object that is under the influence of kinematics. 
 * Have a class that will be controlled by kinematics inherit from this class
 * @author Andrew
 */
public class Kinematic implements GameObject
{
    /**
     * Calculate static horizontal motion (no acceleration)
     * @return The final position after calculation
     */
    public Vector3 staticHorizontalMotion()
    {
        Vector3 endPos = new Vector3(true);
        return endPos;
    }
    
    /**
     * Calculate static vertical motion (no gravity effects)
     * @return The final position after calculation
     */
    public Vector3 staticVerticalMotion()
    {
        Vector3 endPos = new Vector3(true);
        return endPos;
    }
    
    /**
     * Calculate dynamic vertical motion (gravity)
     * @return The final position after calculation
     */
    public Vector3 dynamicVerticalMotion()
    {
        Vector3 endPos = new Vector3(true);
        return endPos;
    }
    
    /**
     * Initialize the kinematic object
     */
    @Override
    public void Initialize()
    {
    }
    
    /**
     * Update the kinematic object
     */
    @Override
    public void Update()
    {
    }
}
