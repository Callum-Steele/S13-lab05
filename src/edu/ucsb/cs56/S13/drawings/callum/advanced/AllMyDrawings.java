package edu.ucsb.cs56.S13.drawings.callum.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad
 * @author Callum Steele
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with a few fields 
     */

    public static void drawPicture1(Graphics2D g2){ 
	
	// draw a cyan field
	
	Field f1 = new Field(10, 50, 100);
	g2.setColor(Color.CYAN);
	g2.draw(f1);

	// make a black field thats twice the size and moved 200 pixels in y direction

	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1, 2, 2);
	f2 = ShapeTransforms.translatedCopyOf(f2, 0, 200);
	g2.setColor(Color.BLACK);
	g2.draw(f2);

	// make a thicker stroke field of color 'International Klein Blue' which is
	// three times the size of the original and moved 200 pixels to the right and 300
	// pixels in the y direction

	Shape f3 = ShapeTransforms.scaledCopyOfLL(f1, 3, 3);
	f3 = ShapeTransforms.translatedCopyOf(f3, 200, 300);
	g2.setColor(new Color(0x002FA7));
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	Stroke orig = g2.getStroke();
	g2.setStroke(thick);
	g2.draw(f3);
	g2.setStroke(orig);

	// signing the picture

	g2.setColor(Color.BLACK);
	g2.drawString("A few fields by Callum Steele", 20, 20);
    }


    /** Draw a picture with a fields, some of which are rotated.
     */
    public static void drawPicture2(Graphics2D g2) {

	// Create a basic field, red in color
	Field f1 = new Field(40, 40, 75);
	g2.setColor(Color.RED);
	g2.draw(f1);

	// Create a field twice the size, black in color and rotated 45 degrees
	// while translated 150 pixels in the x direction and 150 pixels in the
	// y direction
	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1, 2, 2);
	f2 = ShapeTransforms.rotatedCopyOf(f2, Math.PI/4.0);
	f2 = ShapeTransforms.translatedCopyOf(f2, 150, 150);
	g2.setColor(Color.BLACK);
	g2.draw(f2);

	// Modify the second field to be half the size, cyan in color, rotated
	// 90 degrees while translated 150 pixels in the x direction and 150
	// pixels in the y direction with a thicker stroke
	Shape f3 = ShapeTransforms.scaledCopyOfLL(f2, 0.5, 0.5);
	f3 = ShapeTransforms.rotatedCopyOf(f3,Math.PI/2);
	f3 = ShapeTransforms.translatedCopyOf(f3, 150, 150);
	g2.setColor(Color.CYAN);
	Stroke thick = new BasicStroke (8.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	Stroke orig = g2.getStroke();
	g2.setStroke(thick);
	g2.draw(f3);

	// signing the picture

	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Fields by Callum Steele", 20,20);
    }
  
    /** Draw a different picture with a few rugby fields and fields
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// simple rugby field, with a color of red
	RugbyField rf1 = new RugbyField(40, 40, 400);
	g2.setColor(Color.RED);
	g2.draw(rf1);

	// rotatation of original rugby field by 45 degress, color black, thicker stroke
	// and half the size shifted 100 in the y and x axis
	Shape rf2 = ShapeTransforms.scaledCopyOfLL(rf1, 0.5, 0.5);
	rf2 = ShapeTransforms.rotatedCopyOf(rf2, Math.PI/4);
	rf2 = ShapeTransforms.translatedCopyOf(rf2, 100, 100);
	g2.setColor(Color.BLACK);
	Stroke thick = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke orig = g2.getStroke();
	g2.setStroke(thick);
	g2.draw(rf2);

	// a standard field, colored blue, rotated by 90 degrees
	Field f1 = new Field(300, 300, 150);
	Shape f2 = ShapeTransforms.rotatedCopyOf(f1, Math.PI/2);
	g2.setStroke(orig);
	g2.setColor(Color.BLUE);
	g2.draw(f2);

	// signing the picture
	g2.setColor(Color.BLACK);
	g2.drawString("A bunch of Fields and RugbyFields by Callum Steele", 20,20);
    }
}
