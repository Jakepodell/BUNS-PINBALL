import java.awt.geom.*;
import java.awt.Shape;
public class Collision{
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
		System.out.println(ball.getRightSide());
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
		(ball.getX()<LeftFlipper.X || ball.getX()>RightFlipper.X)){
			ball.flipYVelocity();
			ball.moveVert();
		}
	}
	public static void checkBumperCollision(Bumper bumper, Ball ball){
		double bumperCenterX = bumper.getX()+Bumper.WIDTH/2;
		double bumperCenterY = bumper.getY()+Bumper.HEIGHT/2;
		double ballCenterX = ball.getX()+Ball.WIDTH/2;
		double ballCenterY = ball.getY()+Ball.HEIGHT/2;
		double radicalTwo = Math.pow(2,.5);
		double s = Bumper.WIDTH/2/(radicalTwo/1.05);

		if(intersectsShape(ball,bumper)){
			if(ball.getBottomSide()<=bumperCenterY-s || ball.getTopSide()>=bumperCenterY+s)
				ball.flipYVelocity();
			if(ball.getLeftSide()>=bumperCenterX+s || ball.getRightSide()<=bumperCenterX-s)
				ball.flipXVelocity();
			else{
				ball.flipXVelocity();
				ball.flipYVelocity();
			}
		}
	}

	public static void checkFlipperCollision(Flipper[] flips, Ball ball){
		for(Flipper f: flips){
			if(f.isUp()&&ball.getYVelocity()>0&&intersectsShape(ball,f.getCollisionArea())){
				ball.flipYVelocity();
				ball.addYVelocity();
			}
		}
	}
	public static boolean ballHasFallen(Ball b){
		if(b.getY()>Board.Y+Board.HEIGHT+PinballDriver.APPLETPADDING)
			return true;
		return false;
	}
}
