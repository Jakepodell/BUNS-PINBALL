import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;
import java.awt.geom.RectangularShape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
public class Board extends Rectangle2D.Double
{
	Graphics2D g2;
	public Board(int xcord, int ycord, int height, int width)
	{
		super(xcord,ycord,height,width);
	}
	public void draw(Graphics g)
	{
		g2 = (Graphics2D) g;
		g2.draw(this);
	}
}
