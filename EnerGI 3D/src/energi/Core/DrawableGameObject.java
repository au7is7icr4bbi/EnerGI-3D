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
    @Override
    public abstract void Initialize() throws EnergiException;
    
    @Override
    public abstract void Update();
    
    public abstract void Draw() throws EnergiException;
}
