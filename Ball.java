import java.awt.geom.*;
import java.awt.Shape;
import java.awt.*;
public class Ball extends Ellipse2D.Double{
  private int xVelocity=3;
  private int yVelocity=4;
  public int radius;
  private int terminalVelocity =5;
  public static final int HEIGHT=10;
  public static final int WIDTH=10;
  int gravityCounter;
  public double centerX = x+radius;
  public double centerY = y+radius;
  public Ball(int px, int py){
	  super();
	  updateBall(px,py);
	  setFrame(x,y,WIDTH,HEIGHT);
	  radius = WIDTH/2;
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
  public void moveHoriz(){
	  if(xVelocity>0)x+=1;
	  else x-=1;
  }
  public void moveVert(){
  	  if(yVelocity>0)y+=1;
  	  else y-=1;
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
  public double getX(){
	  return x;
  }
  public double getY(){
	  return y;
  }
  public void gravitize(){
	  if(yVelocity<terminalVelocity && gravityCounter%20==0){
		  yVelocity+=2;
	  }
	  gravityCounter++;
  }
  public double getXVelocity(){
	  return xVelocity;
  }
  public double getYVelocity(){
	  return yVelocity;
  }
  public void setVelocity(double x,double y){
	  xVelocity=(int)x;
	  yVelocity=(int)y;
  }
  public int vx(){
	  return xVelocity;
  }
  public int vy(){
	  return yVelocity;
  }
  public double x(){
	  return x+radius;
  }
  public double y(){
	  return y+radius;
  }
  public void addYVelocity(){
	  yVelocity-=5;
  }
}
