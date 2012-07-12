/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Core;

/**
 * Abstract representation of a standard game object
 * @author Andrew
 */
public interface GameObject
{
    /**
     * Initialize the game object
     * @throws EnergiException 
     */
    public void Initialize() throws EnergiException;
    /**
     * Update the game object
     */
    public void Update();
}
