/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Graphics;

/**
 * Represents a 32-bit color using the RGBA gamut.
 * Some simple colors are pre-defined for convenience.
 * @author Andrew
 */
public class Color
    {
        /**
         * Red component (0 - 255)
         */
        private int r;
        /**
         * Green component (0 - 255)
         */
        private int g;
        /**
         * Blue component (0 - 255)
         */
        private int b;
        /**
         * Alpha component (0 - 255)
         */
        private int a;
        
        /**
         * Construct a new color using RGBA values.
         * All components are truncated to the range (0 - 255)
         * @param r Red component
         * @param g Green component
         * @param b Blue component
         * @param a Alpha component
         */
        public Color(int r, int g, int b, int a)
        {
            // if the number is greater than 255 or less than 0,
            // move it to the closest valid value (0 or 255, depending on magnitude)
            r = Math.min(r, 255);
            r = Math.max(r, 0);
            g = Math.min(g, 255);
            g = Math.max(g, 0);
            b = Math.min(b, 255);
            b = Math.max(b, 0);
            a = Math.min(a, 255);
            a = Math.max(a, 0);
            
            // assign the validated values
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }
        /**
         * Returns a new color object reflecting pure black
         * @return The black color
         */
        static public Color Black()
        {
            return new Color(0, 0, 0, 0);
        }
        /**
         * Returns a new color object reflecting pure white
         * @return The white color
         */
        static public Color White()
        {
            return new Color(255, 255, 255, 0);
        }
        /**
         * Returns a new color object reflecting pure red
         * @return The red color
         */
        static public Color Red()
        {
            return new Color(255, 0, 0, 0);
        }
        
        /**
         * Returns a new color object reflecting pure green
         * @return The green color
         */
        static public Color Green()
        {
            return new Color(0, 255, 0, 0);
        }
        
        /**
         * Returns a new color object reflecting pure blue
         * @return The blue color
         */
        static public Color Blue()
        {
            return new Color(0, 0, 255, 0);
        }
        
        /**
         * Returns a new color object reflecting pure Yellow
         * @return The yellow color
         */
        static public Color Yellow()
        {
            return new Color(255, 255, 0, 0);
        }
        
        /**
         * Returns a new color object reflecting pure purple
         * @return The purple color
         */
        static public Color Purple()
        {
            return new Color(255, 0, 255, 0);
        }
        
        /**
         * Returns a new color object reflecting teal
         * @return The teal color
         */
        static public Color Teal()
        {
            return new Color(0, 255, 255, 0);
        }
        
        /**
         * Returns a new color object reflecting pure grey
         * @return The red color
         */
        static public Color Grey()
        {
            return new Color(127, 127, 127, 0);
        }
        
        /**
         * Returns an OpenGL vector for use in glLight or glMaterial
         * @return A corresponding array of RGBA values, converted to floating-point.
         */
        public float[] glVector()
        {
            float vector[] = new float[4];
            vector[0] = (float)r / 255.0f;
            vector[1] = (float)g / 255.0f;
            vector[2] = (float)b / 255.0f;
            vector[3] = (float)a / 255.0f;
            return vector;
        }
    }
