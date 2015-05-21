import java.awt.geom.*;
import java.awt.Shape;
public class Ball extends Ellipse2D.Double
{
  private double directionAngle;
  private int speed;
  public static final int HEIGHT=25;
  public static final int WIDTH=25;
  public Ball(int px, int py)
  {
	  super(px, py, HEIGHT, WIDTH);
  }

  public boolean intersects(Shape pshape)
  {
	  Area ballArea = new Area(this);
	  Area objectArea = new Area(pshape);
	  Area intersectionArea = ballArea;
	  intersectionArea.intersect(objectArea);

	  if(intersectionArea.isEmpty())
	  	return false;
	  else
	  	return true;
  }

  public double getDirectionAngle()
  {
    return directionAngle;
  }
  public int getSpeed()
  {
    return speed;
  }
}
