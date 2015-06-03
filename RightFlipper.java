import java.awt.*;
public class RightFlipper extends Flipper{

	public RightFlipper(int px, int py){
		super(px,py);
	}

	public void drawFlip(Graphics2D g)
	{
		g.drawLine(x1,y1,(x1-xlength),(y1+ylength));
	}
}
