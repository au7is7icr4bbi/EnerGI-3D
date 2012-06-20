/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Core;
import java.io.*;


/**
 * Base class for all assets that can be loaded from external files.
 * Texture2D and AudioItem both extend this base class.
 * @author Andrew
 */
public abstract class Asset implements Serializable
{
    /**
     * Load an asset from a file
     * @param filename The asset file name
     * @return A compiled asset for use within a game or utility program
     * @throws EnergiException 
     */
    public static Asset load(String filename) throws EnergiException
    {
        Asset newAsset = null;
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            newAsset = (Asset)in.readObject();
        }
        catch (Exception e)
        {
            throw new EnergiException(e);
        }
        return newAsset;
    }
    
    /**
     * Save an asset to a file
     * @param filename The asset file name
     * @throws EnergiException 
     */
    final public void save(String filename) throws EnergiException
    {
        try
        {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename));
            o.writeObject(this);
        }
        catch (Exception e)
        {
            throw new EnergiException(e);
        }
    }
}
