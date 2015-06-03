import java.awt.geom.*;
import java.awt.Shape;
import java.awt.*;

public class Bumper extends Ellipse2D.Double{
  public static final int HEIGHT=30;
  public static final int WIDTH=30;
  public Bumper(int px, int py){
	  super();
	  setFrame(px,py,WIDTH,HEIGHT);
  }
  public void drawBumper(Graphics2D g2d){
	GradientPaint  bluetored = new GradientPaint((int)x,(int)y,Color.RED,(int)x+WIDTH,(int) y+HEIGHT,Color.BLUE);
	g2d.setPaint(bluetored);
	g2d.fill(this);
	g2d.setPaint(null);
	g2d.setColor(Color.green);
  }
  public double getRightSide(){
	  return x+WIDTH;
  }
  public double getLeftSide(){
	  return x;
  }
  public double getTopSide(){
	  return y;
  }
  public double getBottomSide(){
	  return y+HEIGHT;
  }
}
