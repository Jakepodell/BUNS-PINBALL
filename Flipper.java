import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
public class Flipper
{
	public static final int WIDTH=55;
	public static final int HEIGHT=30;
	public static final int Y = 450;
	boolean isUp = false;
	int x1;
	int y1;
	int xlength = 50;
	int ylength = 30;
	Polygon triangleArea;
	int[] triangleYs = {Flipper.Y, Flipper.Y-Flipper.HEIGHT,Flipper.Y+(int)(Flipper.HEIGHT*1)};
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
	public Area getCollisionArea(){
		return new Area(triangleArea);
	}
	public boolean isUp(){
		return isUp;
	}

}
