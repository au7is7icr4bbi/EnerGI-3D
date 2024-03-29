/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Input;
import org.lwjgl.input.Keyboard;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import energi.Core.Event;
import energi.Core.EnergiException;
import energi.Core.EventHandler;
import java.util.Vector;

/**
 * Singleton for all input types. Generates input events and triggers their handling
 * @author Andrew
 */
public class InputDevice
{
    /**
     * Represents the possible mouse button events
     */
    public enum ButtonEvent
    {
        /**
         * Left button
         */
        LeftButton,
        /**
         * Right Button
         */
        RightButton,
        /**
         * Middle Button
         */
        MiddleButton,
    }
    
    /**
     * Represents the mouse axes (both deltas and absolutes)
     */
    public enum AxisEvent
    {
        /**
         * Delta X
         */
        DeltaX,
        /**
         * Delta Y
         */
        DeltaY,
        /**
         * Absolute X
         */
        AbsX,
        /**
         * Absolute Y
         */
        AbsY,
        /**
         * Wheel movement
         */
        Wheel
    }
    
    /**
     * Represents the mouse button states
     */
    public enum ButtonAction
    {
        /**
         * Button up
         */
        BUTTONUP,
        /**
         * Button Down
         */
        BUTTONDOWN
    }
    
    /**
     * Represents the possible keyboard states
     */
    public enum KeyboardAction
    {
        /**
         * Key released/not pressed
         */
        KEYUP,
        /**
         * Key pressed
         */
        KEYDOWN,
    }
    static Vector <Event> events;
    private static InputThread thread;
    /**
     * Initialize the input event loop
     * @throws EnergiException 
     */
    public static void Initialize() throws EnergiException
    {
        try
        {
            Keyboard.create();
            Mouse.create();
            thread = new InputThread();
            thread.start();
        }
        catch (LWJGLException e)
        {
            throw new EnergiException(e);
        }
        events = new Vector<>();
    }
    
    /**
     * Scan for new events
     */
    static void scanEvents() throws EnergiException
    {
        for (int i = 0; i < events.size(); i++)
        {
            try
            {
                // check if the event is an instance of a keyboard event or a mouse event
                if (events.get(i) instanceof KeyboardEvent)
                {
                    KeyboardEvent event = (KeyboardEvent)events.get(i);
                    if (Keyboard.isKeyDown(event.getEventKey()) == event.getAction())
                    {
                        thread.events.put(event);
                    }
                }
                else if (events.get(i) instanceof MouseEvent)
                {
                    MouseEvent event = (MouseEvent)events.get(i);
                    if (event.bEvent != null && Mouse.isButtonDown(event.bEvent.ordinal()))
                    {
                        thread.events.put(event);
                    }
                    else if (event.aEvent != null)
                    {
                        if (Mouse.getDX() != 0 && event.aEvent == AxisEvent.DeltaX)
                            thread.events.put(event);
                        else if (Mouse.getDY() != 0 && event.aEvent == AxisEvent.DeltaY)
                            thread.events.put(event);
                        else if (Mouse.getDWheel() != 0 && event.aEvent == AxisEvent.Wheel)
                            thread.events.put(event);
                    }
                }
            }
            catch (InterruptedException e)
            {
                throw new EnergiException(e);
            }
        }
    }
    
    /**
     * Register a new keyboard event
     * @param handler The event handler
     * @param key The event key
     * @param isDown The event action (keyup (false) or keydown (true))
     */
    public static void registerEvent(EventHandler handler, int key, boolean isDown)
    {
        events.add(new KeyboardEvent(handler, key, isDown));
    }
    
    /**
     * Register a new mouse button event
     * @param handler The event handler
     * @param e The event button
     * @param a The event action (ButtonUp or ButtonDown)
     */
    public static void registerEvent(EventHandler handler, ButtonEvent e, ButtonAction a)
    {
        events.add(new MouseEvent(handler, e, a));
    }
    
    /**
     * Register a new mouse movement event
     * @param handler The event handler
     * @param e The event axis
     */
    public static void registerEvent(EventHandler handler, AxisEvent e)
    {
        events.add(new MouseEvent(handler, e));
    }
}

/**
 * Defines a mouse click or movement event
 * @author Andrew
 */
class MouseEvent extends Event
{
    InputDevice.ButtonAction action;
    InputDevice.AxisEvent aEvent;
    InputDevice.ButtonEvent bEvent;
    
    /**
     * Called when a mouse button event is registered
     * @param handler Event handler
     * @param event The event to look for
     * @param action The event action (ie. button up or button down)
     */
    public MouseEvent(EventHandler handler, InputDevice.ButtonEvent event, InputDevice.ButtonAction action)
    {
        this.handler = handler;
        bEvent = event;
        aEvent = null;
        this.action = action;
    }
    
    /**
     * Called when a mouse axis movement event is registered
     * @param handler Event handler
     * @param event Mouse axis event
     */
    public MouseEvent(EventHandler handler, InputDevice.AxisEvent event)
    {
        action = null;
        this.handler = handler;
        aEvent = event;
        bEvent = null;
    }
    
    /**
     * Trigger the event handler
     */
    @Override
    public void triggerEvent()
    {
        handler.handleEvent();
    }
}

/**
 * Defines a keyboard press/release event
 * @author Andrew
 */
class KeyboardEvent extends Event
{
    int key;
    boolean isPressed = true;
    
    /**
     * Create a new KeyboardEvent instance. Generated internally
     * @param handler The event handler
     * @param key The event key
     * @param action The action taken (keyup or keydown)
     */
    public KeyboardEvent(EventHandler handler, int key, boolean down)
    {
        this.handler = handler;
        this.key = key;
        this.isPressed = down;
    }
    
    /**
     * Get the event key
     * @return The event key
     */
    public int getEventKey()
    {
        return key;
    }
    
    /**
     * Get the event action
     * @return The event action
     */
    public boolean getAction()
    {
        return isPressed;
    }
    
    /**
     * Trigger the event handler
     */
    @Override
    public void triggerEvent()
    {
        handler.handleEvent();
    }
}
