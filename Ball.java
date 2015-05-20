import java.awt.geom;
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

	  if(ballArea.intersects(objectArea))
	  	return true;
	  else
	  	return false;
  }

  public int getDirectionAngle()
  {
    return directionAngle;
  }
  public int getSpeed()
  {
    return speed;
  }
}
