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
   A Rugby Field, complete with all the lines drawn in.
      
   @author Callum Steele 
   @version for CS56, S13, UCSB
   
*/
public class RugbyField extends Field implements Shape
{
    /**
       Constructor for objects of class RugbyField
       @param x x coord of upper left corner.
       @param y y coord of upper left corner.
       @param length Length of the field.
     */
    public RugbyField(double x, double y, double length)
    {
	// construct the basic house shell
	super(x,y,length);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	// scale to use for calculations based on length, where 122 metres is
	// standard length of rugby field
	double standardLength = 122;
	double standardWidth = 68;
	double scale = length / standardLength;
	
	// y value for lower section of field
	double lowerY = y + standardWidth * scale;

        // create the halfway line
	double halfwayX = x + 61 * scale;
	Line2D.Double halfwayLine = new Line2D.Double(halfwayX, y, halfwayX, lowerY);

	// create the left try line
	double leftTryLineX = x + 11 * scale;
	Line2D.Double leftTryLine = new Line2D.Double(leftTryLineX, y, leftTryLineX, lowerY);

	// create the right try line
	double rightTryLineX = x + 111 * scale;
	Line2D.Double rightTryLine = new Line2D.Double(rightTryLineX, y, rightTryLineX, lowerY);

	// create the left 22 line
	double left22LineX = x + 33 * scale;
	Line2D.Double left22Line = new Line2D.Double(left22LineX, y, left22LineX, lowerY);
	
	// create the right 22 line
	double right22LineX = x + 89 * scale;
	Line2D.Double right22Line = new Line2D.Double(right22LineX, y, right22LineX, lowerY);

	// create the upper and lower 10 from touch lines
	double left10TouchLineX = x + 11 * scale;
	double right10TouchLineX = x + 111 * scale;
	double upper10TouchLineY = y + 10 * scale;
	Line2D.Double upper10TouchLine = new Line2D.Double(left10TouchLineX, upper10TouchLineY, right10TouchLineX, upper10TouchLineY);
	double lower10TouchLineY = y + 58 * scale;
	Line2D.Double lower10TouchLine = new Line2D.Double(left10TouchLineX, lower10TouchLineY, right10TouchLineX, lower10TouchLineY);

	// create the left and right 10m lines
	double left10LineX = x + 51 * scale;
	Line2D.Double left10Line = new Line2D.Double(left10LineX, upper10TouchLineY, left10LineX, lower10TouchLineY);
	double right10LineX = x + 71 * scale;
	Line2D.Double right10Line = new Line2D.Double(right10LineX, upper10TouchLineY, right10LineX, lower10TouchLineY);

	// create the left and right 10 to lines
	double left10ToLineX = x + 16 * scale;
	Line2D.Double left10ToLine = new Line2D.Double(left10ToLineX, y, left10ToLineX, lowerY);
	double right10ToLineX = x + 106 * scale;
	Line2D.Double right10ToLine = new Line2D.Double(right10ToLineX, y, right10ToLineX, lowerY);

        GeneralPath rugbyField = this.get();
        rugbyField.append(halfwayLine, false);
        rugbyField.append(leftTryLine, false);
        rugbyField.append(rightTryLine, false);
	rugbyField.append(left22Line, false);
	rugbyField.append(right22Line, false);
	rugbyField.append(upper10TouchLine, false);
	rugbyField.append(lower10TouchLine, false);
	rugbyField.append(left10Line, false);
	rugbyField.append(right10Line, false);
	rugbyField.append(left10ToLine, false);
	rugbyField.append(right10ToLine, false);
    }
}
