package edu.ucsb.cs56.S13.drawings.callum.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a field that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Callum Steele
   @version for CS56, Winter 11, UCSB
   
*/
public class Field extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of field
       @param y y coord of upper left corner of field
       @param length length of the field
     */
    public Field(double x, double y, double length)
    {
    
        // uses standard length of a field to be 122 metres and the
	// standard width of a field to be 68 metres, to scale the
	// field specified in the parameters.
        
	double standardWidth = 68;
	double standardLength = 122;

        double width = length * (standardWidth / standardLength);

        // Make the basic field
        Rectangle2D.Double baseField = 
            new Rectangle2D.Double(x, y,
				   length, width);

	// assemble field
        GeneralPath field = this.get();
        field.append(baseField, false); 
    }
}
