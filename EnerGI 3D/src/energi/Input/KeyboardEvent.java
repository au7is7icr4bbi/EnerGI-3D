/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Input;
import energi.Core.*;

/**
 * Encapsulates a keyboard button press
 * @author Andrew
 */
public class KeyboardEvent extends Event
{
    public enum Action
    {
        KEYUP,
        KEYDOWN,
    }
    
    int key;
    Action action;
    
    public KeyboardEvent(EventHandler handler, int key, Action action)
    {
        this.handler = handler;
        this.key = key;
        this.action = action;
    }
    
    public int getEventKey()
    {
        return key;
    }
    
    public Action getAction()
    {
        return action;
    }
    
    public void triggerEvent()
    {
        handleEvent();
    }
}
