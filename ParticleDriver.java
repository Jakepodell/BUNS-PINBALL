import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class ParticleDriver extends JApplet implements MouseListener, ActionListener
{
	DrawingPanel dp;
	ParticleEngine pe;
	Timer t;
	public final static int WIDTH = 2000;
	public final static int HEIGHT = 2000;
	
	public void init()
	{
		setSize(WIDTH, HEIGHT);
		pe = new ParticleEngine();
		dp = new DrawingPanel();
		setContentPane(dp);
		addMouseListener(this);
		t = new Timer(30, this);
		t.start();
	//	t.addActionListener(this);

	}

	public void actionPerformed (ActionEvent e)
	{
		for (Particle p : pe.getParticleList())
			p.tick();
		pe.removeOffScreenParticles();
		repaint();
	}
	
	public void mousePressed(MouseEvent e)
	{
		//--------------------------------------------------------------
		pe.explodeRandomColors(e.getX(), e.getY());
		//--------------------------------------------------------------
	}

	public void mouseClicked(MouseEvent e) {}
 	public void mouseReleased(MouseEvent e){}
 	public void mouseEntered(MouseEvent e) {}
 	public void mouseExited(MouseEvent e) {}
 	
	public class DrawingPanel extends JPanel
	{
		public void paintComponent (Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			pe.draw(g2);
		}
	}

}
