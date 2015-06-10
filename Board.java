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
	Bumper bumper = new Bumper(200,200);
	Bumper bumper2 = new Bumper(310,400);
	public final static int X=0;
	public final static int Y=0;
	public final static int WIDTH=350;
	public final static int HEIGHT=500;
	LeftFlipper lf = new LeftFlipper(LeftFlipper.X,Flipper.Y);
	RightFlipper rf = new RightFlipper(RightFlipper.X,Flipper.Y);
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
		drawBottom(g);
		//g.draw(ball);
		ball.drawBall(g);
		lf.drawFlip(g);
		rf.drawFlip(g);
		bumper.drawBumper(g);
		bumper2.drawBumper(g);
		//g.fill(lf.getCollisionArea());
		//g.fill(rf.getCollisionArea());
	}
	public void update(){
		Flipper[] flips = {rf,lf};
		for(int i =0; i<Math.abs(ball.getXVelocity()); i++){
			Collision.checkBoardIntersection(this,ball);
			Collision.checkBumperCollision(bumper,ball);
			Collision.checkBumperCollision(bumper2,ball);
			Collision.checkFlipperCollision(flips,ball);
			ball.moveHoriz();

		}
		for(int i =0; i<Math.abs(ball.getYVelocity()); i++){
			Collision.checkBoardIntersection(this,ball);
			Collision.checkBumperCollision(bumper,ball);
			Collision.checkBumperCollision(bumper2,ball);
			Collision.checkFlipperCollision(flips,ball);
			ball.moveVert();
		}
		ball.gravitize();
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
	public Flipper getLeftFlipper(){
		return (Flipper)lf;
	}
	public Flipper getRightFlipper(){
			return (Flipper)rf;
	}
	public void drawBottom(Graphics2D g){
		g.drawLine(getBoardX(), Flipper.Y,LeftFlipper.X, Flipper.Y);
		g.drawLine(RightFlipper.X, Flipper.Y,getBoardX()+Board.WIDTH, Flipper.Y);
	}
	public int getBoardX(){
		return (int)(X+PinballDriver.APPLETPADDING);
	}
	public int getBoardY(){
			return (int)(Y+PinballDriver.APPLETPADDING);
	}
}
