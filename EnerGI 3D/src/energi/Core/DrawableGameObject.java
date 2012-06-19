/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Core;

/**
 * Represents a drawable game object
 * @author Andrew
 */
public abstract class DrawableGameObject implements GameObject
{
    /**
     * Initialize the game object
     * @throws EnergiException 
     */
    @Override
    public abstract void Initialize() throws EnergiException;
    
    /**
     * Update the game object
     */
    @Override
    public abstract void Update();
    
    /**
     * Draw the game object
     * @throws EnergiException 
     */
    public abstract void Draw() throws EnergiException;
}
