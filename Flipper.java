import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Flipper
{
	public static final int WIDTH=50;
	public static final int HEIGHT=30;
	boolean isUp = false;
	int x1;
	int y1;
	int xlength = 50;
	int ylength = 30;
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
}
