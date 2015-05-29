import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;
import java.awt.geom.RectangularShape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
public class Board extends Rectangle2D.Double
{
	Ball ball = new Ball(300,300);
	public final static int X=0;
	public final static int Y=0;
	public final static int WIDTH=350;
	public final static int HEIGHT=500;
	public Board(int xcord, int ycord, int height, int width)
	{
		super(xcord,ycord,height,width);
	}
	public Board(){
		super(X+PinballDriver.APPLETPADDING,
		Y+PinballDriver.APPLETPADDING,
		WIDTH,
		HEIGHT);
	}
	public void drawBoard(Graphics2D g)
	{
		g.draw(this);
		//g.draw(ball);
		ball.drawBall(g);
	}
	public void update(){
		Collision.checkBoardIntersection(this,ball);
		ball.move();
	}
	public int getRightSide(){
		return WIDTH+PinballDriver.APPLETPADDING;
	}
	public int getLeftSide(){
		return PinballDriver.APPLETPADDING;
	}
	public int getTopSide(){
		return PinballDriver.APPLETPADDING;
	}
	public int getBottomSide(){
		return PinballDriver.APPLETPADDING+HEIGHT;
	}
}
