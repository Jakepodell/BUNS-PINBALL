import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Flipper
{
	boolean isUp = false;
	int x2;
	int y2;
	int x1;
	int y1;
	int xlength = 50;
	int ylength = 50;
	public Flipper(int x1, int y1)
	{
		this.x1 = x1;
		this.y1 = y1;
	}
	public void Flip()
	{
		ylength*=-1;
		isUp=!isUp;
	}
	public void drawFlip(Graphics2D g)
	{

		g.drawLine(x1,y1,(x1+xlength),(y1+ylength));
	}

}
