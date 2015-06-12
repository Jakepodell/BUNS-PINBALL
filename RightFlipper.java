import java.awt.*;
public class RightFlipper extends Flipper{

	public static final int X = 295;
	public RightFlipper(int px, int py){
		super(px,py);
		int[] triangleXs = {X,(int)(X-Flipper.WIDTH*1),X-(int)(Flipper.WIDTH*1)};
		triangleArea = new Polygon(triangleXs,triangleYs,3);
	}

	public void drawFlip(Graphics2D g)
	{
		g.drawLine(x1,y1,(x1-xlength),(y1+ylength));
	}
}