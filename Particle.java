import java.awt.*;
import java.util.Random;

public class Particle
{
	final int DIAMETER = 10;
	final int MAX_VELOCITY = 15;
	int x, y, dx, dy;
	Image i;
	Random r;
	Color c;

	public Particle (int px, int py, Color pc) //Constructor for particles without images
	{
		r = new Random();
		x = px;
		y = py;
		dx = r.nextInt(2 * MAX_VELOCITY) - MAX_VELOCITY; //Allows for negatives
		dy = r.nextInt(2 * MAX_VELOCITY) - MAX_VELOCITY;
		c = pc;
	}

	public Particle (int px, int py, Image pi) //Constructor for particles with images
	{
		r = new Random();
		x = px;
		y = py;
		dx = r.nextInt(2 * MAX_VELOCITY) - MAX_VELOCITY; //Allows for negatives
		dy = r.nextInt(2 * MAX_VELOCITY) - MAX_VELOCITY;
		i = pi;
	}

	public void draw(Graphics2D g) //Draws the particle's image if it exists, otherwise draws a circle
	{
		if (i == null)
		{
			g.setColor(c);
			g.fillOval(x, y, DIAMETER, DIAMETER);
		}
		else
			g.drawImage(i, x,  y, DIAMETER, DIAMETER, null);
	}

	public void tick()
	{
		x+=dx;
		y+=dy;
		if (dx > 2)		// sets minimum
			dx--;		// magnitude of
		else if (dx < -2)	// horiztonal velocity
			dx++;		// at 2
		dy++;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}