
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
		if(ball.getRightSide()>=board.getRightSide()
		|| ball.getLeftSide()<=board.getLeftSide()){
			ball.flipXVelocity();
		}
		if(ball.getBottomSide()>=board.getBottomSide()
		|| ball.getTopSide()<=board.getTopSide()){
			ball.flipYVelocity();
		}
	}
}
