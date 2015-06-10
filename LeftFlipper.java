import java.awt.*;
public class LeftFlipper extends Flipper{
	public static final int X = 150;
	public LeftFlipper(int px, int py){
		super(px,py);
		int[] triangleXs = {X,X+Flipper.WIDTH,X+Flipper.WIDTH};
		int[] triangleYs = {Flipper.Y, Flipper.Y-Flipper.HEIGHT,Flipper.Y+Flipper.HEIGHT};
		triangleArea = new Polygon(triangleXs,triangleYs,3);
	}

	public void drawFlip(Graphics2D g)
	{
		g.drawLine(x1,y1,(x1+xlength),(y1+ylength));
	}
}
