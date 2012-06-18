/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Core;

/**
 * Abstract representation of a standard game object
 * @author Andrew
 */
public interface GameObject {
    public void Initialize() throws EnergiException;
    public void Update();
}
