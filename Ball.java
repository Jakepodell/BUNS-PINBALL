import java.awt.geom.*;
import java.awt.Shape;
import java.awt.*;
public class Ball extends Ellipse2D.Double{
  private int xVelocity=5;
  private int yVelocity=5;
  public static final int HEIGHT=10;
  public static final int WIDTH=10;
  public Ball(int px, int py){
	  super();
	  updateBall(px,py);
	  setFrame(x,y,WIDTH,HEIGHT);
  }
  public void drawBall(Graphics2D g2d){
	GradientPaint  blacktowhite = new GradientPaint((int)x,(int)y,Color.BLACK,(int)x+WIDTH,(int) y+HEIGHT,Color.WHITE);
	g2d.setPaint(blacktowhite);
	g2d.fill(this);
	g2d.setPaint(null);
	g2d.setColor(Color.black);
  }
  public void updateBall(int px, int py){
	  x = px;
	  y = py;
  }
  public void move(){
	  x+=xVelocity;
	  y+=yVelocity;
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
  public void flipXVelocity(){
	  xVelocity*=-1;
  }
  public void flipYVelocity(){
	  yVelocity*=-1;
  }
}
