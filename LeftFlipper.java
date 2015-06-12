import java.awt.*;
import java.awt.geom.*;
public class LeftFlipper extends Flipper{
	public static final int X = 150;
	public LeftFlipper(int px, int py){
		super(px,py);
		int[] triangleXs = {X,X+(int)(Flipper.WIDTH*1),X+(int)(Flipper.WIDTH*1)};
		triangleArea = new Polygon(triangleXs,triangleYs,3);
		upLine = new Line2D.Double(triangleXs[0],triangleYs[0],triangleXs[1],triangleYs[1]);
		downLine = new Line2D.Double(triangleXs[0],triangleYs[0],triangleXs[2],triangleYs[2]);
	}

	public void drawFlip(Graphics2D g)
	{
		//g.draw(upLine);
		//g.draw(downLine);
		g.drawLine(x1,y1,(x1+xlength),(y1+ylength));
	}
}