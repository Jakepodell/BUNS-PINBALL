import java.awt.geom.*;
import java.awt.Shape;
import java.util.*;
public class Collision{
	public static int BUMPER = 10;
	public static int FLIPPER = 5;
    public static boolean intersectsShape(Ball b, Shape pshape){
  	  Area ballArea = new Area(b);
  	  Area objectArea = new Area(pshape);
  	  Area intersectionArea = ballArea;
  	  intersectionArea.intersect(objectArea);

  	  if(intersectionArea.isEmpty())
  	  	return false;
  	  else
  	  	return true;
    }
    public static boolean intersectsBoard(Ball ball, Board board){
      Area ballArea = new Area(ball);
      Rectangle2D boardRect = board.getBounds();
      Area boardArea = new Area(boardRect);

      ballArea.exclusiveOr(boardArea);

      if(!ballArea.isEmpty())
        return true;
      return false;
    }
    public static void checkBoardIntersection(Board board, Ball ball){
//		System.out.println(ball.getRightSide());
		if(ball.getRightSide()==board.getRightSide()
		|| ball.getLeftSide()==board.getLeftSide()){
			ball.flipXVelocity();
			ball.moveHoriz();
		}
		if(//ball.getBottomSide()==board.getBottomSide()||
		(ball.getTopSide()==board.getTopSide() && ball.getYVelocity()<2)){
			ball.flipYVelocity();
			ball.moveVert();
			return;
		}
		checkBottomIntersection(board,ball);
	}
	public static void checkBottomIntersection(Board board, Ball ball){
		if(ball.getY()+Ball.HEIGHT==Flipper.Y&&
		(ball.getX()<(LeftFlipper.X+5) || ball.getX()+Ball.WIDTH>RightFlipper.X)){
			ball.flipYVelocity();
			ball.moveVert();
		}
	}
	public static void checkBumperCollision(ArrayList<Bumper> bumpers, Ball ball, ScorePanel sp){
		for(Bumper bumper:bumpers){
			double bumperCenterX = bumper.getX()+Bumper.WIDTH/2;
			double bumperCenterY = bumper.getY()+Bumper.HEIGHT/2;
			double ballCenterX = ball.getX()+Ball.WIDTH/2;
			double ballCenterY = ball.getY()+Ball.HEIGHT/2;
			double radicalTwo = Math.pow(2,.5);
			double s = Bumper.WIDTH/2/(radicalTwo*1.2);

			if(intersectsShape(ball,bumper)){
				sp.addScore(BUMPER);
				if((ball.getBottomSide()<=bumperCenterY-s && ball.getYVelocity()>0) || (ball.getTopSide()>=bumperCenterY+s && ball.getYVelocity()<0))
					ball.flipYVelocity();
				if((ball.getLeftSide()>=bumperCenterX+s && ball.getXVelocity()<0) || (ball.getRightSide()<=bumperCenterX-s && ball.getXVelocity()>0))
					ball.flipXVelocity();
				PinballDriver.playBumperSound();
				/*else{
					ball.flipXVelocity();
					ball.flipYVelocity();
				}*/
			}
		}
	}

	public static void checkFlipperCollision(Flipper[] flips, Ball ball, ScorePanel sp){
		for(Flipper f: flips){
			if(f.isUp()&&ball.getYVelocity()>0&&intersectsShape(ball,f.getCollisionArea())){
				ball.flipYVelocity();
				ball.addYVelocity();
				sp.addScore(FLIPPER);
				ball.updateBall((int)ball.getX(),Flipper.Y-Flipper.HEIGHT-15);
				PinballDriver.playFlipperSound();
			}
		}
	}
	public static void checkStaticFlipperCollision(Flipper left,Flipper right, Ball ball){
		if(left.isUp()&&left.getUpLine().intersects(ball.getBounds2D())){
			ball.setXVelocity((int)ball.getXVelocity()+-4);
			ball.setYVelocity(-3);
			PinballDriver.playFlipperSound();
		}
		if((!left.isUp())&&left.getDownLine().intersects(ball.getBounds2D())){
			ball.setXVelocity((int)ball.getXVelocity()+2);
			ball.setYVelocity(1);
			PinballDriver.playFlipperSound();
		}
		if(right.isUp()&&right.getUpLine().intersects(ball.getBounds2D())){
			ball.setXVelocity((int)ball.getXVelocity()+1);
			ball.setYVelocity(-3);
			PinballDriver.playFlipperSound();
		}
		if((!right.isUp())&&right.getDownLine().intersects(ball.getBounds2D())){
			ball.setXVelocity((int)ball.getXVelocity()-2);
			ball.setYVelocity(1);
			PinballDriver.playFlipperSound();
		}
	}
	public static boolean ballHasFallen(Ball b){
		if(b.getY()>Board.Y+Board.HEIGHT+PinballDriver.APPLETPADDING)
			return true;
		return false;
	}
}
