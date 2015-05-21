import java.awt.geom.*;
import java.awt.Shape;
public class Ball extends Ellipse2D.Double
{
  private double directionAngle;
  private int speed;
  public static final int HEIGHT=25;
  public static final int WIDTH=25;
  public static int currentXcoord;
  public static int currentYcoord;
  public Ball(int px, int py)
  {
	  currentXcoord = px;
	  currentYcoord = py;
	  super(currentXcoord, currentYcoord, HEIGHT, WIDTH);
  }
  public void drawBall(int pxcoord, pycoord)
  {
	  
  }//not sure if this instead
  public void paintComponent(Graphics g){
	  super.paintComponent(g);
	  Graphics g2d = (Graphics2D)g;
	  Ellipse2D.Double newCircle = new Ellipse2D.Double(currentXcoord, currentYcoord, HEIGHT, WIDTH);
	  g2d.fill(circle);
  }//what I think it should be but I am not sure
  public double getDirectionAngle()
  {
    return directionAngle;
  }
  public int getSpeed()
  {
    return speed;
  }
}

