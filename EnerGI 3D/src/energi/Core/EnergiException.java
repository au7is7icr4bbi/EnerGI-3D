/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Core;
import org.lwjgl.LWJGLException;
import java.io.IOException;

/**
 * Encapsulates all exception types
 * @author Andrew
 */
public class EnergiException extends Throwable
{
    /**
     * Defines the three possible actions an exception can use
     */
    public enum Action
    {
        /**
         * Continue execution
         */
        CONTINUE,
        /**
         * Terminate the program
         */
        EXIT,
        /**
         * Invoke a custom event handler
         */
        CUSTOM
    }
    private EventHandler handler;
    private Action action;
    private String message;
    
    /**
     * Create a new EnergiException instance from another internal exception
     * @param t The internal exception
     */
    public EnergiException(Throwable t)
    {
        if (t instanceof LWJGLException)
            this.message = "LWJGL Exception: " + t.getMessage();
        else
            this.message = "IO Exception: " + t.getMessage();
        this.handler = null;
        this.action = Action.EXIT;
    }
    
    /**
     * Create a new EnergiException instance for an engine-specific exception
     * @param message The message to display
     * @param a The action to take
     * @param e The handler to handle the exception
     */
    public EnergiException(String message, Action a, EventHandler e)
    {
        handler = e;
        action = a;
        this.message = "EnerGI Exception: " + message;
    }
    
    /**
     * Returns the exception message
     * @return The exception message
     */
    @Override
    public String getMessage()
    {
        return message;
    }
    
    /**
     * Gets the action the exception will take
     * @return the exception action
     */
    public Action getAction()
    {
        return action;
    }
    
    /**
     * Handles the exception based on the supplied event handler
     */
    public void handleEvent()
    {
        handler.handleEvent();
    }
}
