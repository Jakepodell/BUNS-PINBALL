import java.awt.geom.*;
import java.awt.Shape;
import java.awt.*;

public class Bumper extends Ellipse2D.Double{
  public static final int HEIGHT=20;
  public static final int WIDTH=20;
  public int radius = WIDTH/2;
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
	g2d.fill(this.getRect());
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
  public double getX(){
  	  return x;
    }
    public double getY(){
  	  return y;
  }
  public double getBottomSide(){
	  return y+HEIGHT;
  }
  public double x(){
  	  return x+radius;
    }
    public double y(){
  	  return y+radius;
  }
  public Rectangle getRect(){
	  double bumperCenterX = this.getX()+Bumper.WIDTH/2;
	  double bumperCenterY = this.getY()+Bumper.HEIGHT/2;
	  double radicalTwo = Math.sqrt(2);
	  double s = Bumper.WIDTH/2/(radicalTwo*.8);
	  return (new Rectangle((int)(bumperCenterX-s), (int)(bumperCenterY-s),(int)(s*2),(int)(s*2.0)));
  }
}
