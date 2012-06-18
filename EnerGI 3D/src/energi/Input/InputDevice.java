/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Input;
import org.lwjgl.input.Keyboard;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import energi.Core.*;
import java.util.Vector;

/**
 * Singleton for all input types. Generates input events and triggers their handling
 * @author Andrew
 */
public class InputDevice
{
    public enum EventType
    {
        Mouse,
        Keyboard
    }
    
    static Vector <Event> events;
    public static void Initialize() throws EnergiException
    {
        try
        {
            Keyboard.create();
            Mouse.create();
        }
        catch (LWJGLException e)
        {
            throw new EnergiException(e);
        }
        events = new Vector<>();
    }
    
    public static void scanEvents()
    {
    }
    
    public static void registerEvent(EventHandler handler, int key, KeyboardEvent.Action a)
    {
        events.add(new KeyboardEvent(handler, key, a));
    }
    
    public static void registerEvent(EventHandler handler, MouseEvent.ButtonEvent e, MouseEvent.ButtonAction a)
    {
        events.add(new MouseEvent(handler, e, a));
    }
    
    public static void registerEvent(EventHandler handler, MouseEvent.AxisEvent e)
    {
        events.add(new MouseEvent(handler, e));
    }
}
