import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PinballDriver extends JApplet implements ActionListener, Runnable, KeyListener
{
	public static int APPLETPADDING=50;
	BoardPanel bp;
	//Timer timer;
	Thread thread;
	ScorePanel s;
	public void init()
	{
		setContentPane(new DrawingPanel());
		setSize(new Dimension(Board.WIDTH+APPLETPADDING*2, Board.HEIGHT+APPLETPADDING*2));
		s = new ScorePanel();
		bp = new BoardPanel(s);
		//timer = new Timer(20, this);
		//timer.start();
		setLayout(null);
		s.setLocation(450,50);
		add(s);
		thread = new Thread(this);
		thread.start();
		setFocusable(true);
		addKeyListener(this);
	}
	public void run(){
		while(true){
			bp.update();
			repaint();
			try {
				Thread.sleep(8l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	 public class DrawingPanel extends JPanel
	{
	  public void paintComponent(Graphics g)
  	  {
		  Graphics2D g2 = (Graphics2D) g;
		  bp.drawBoardPanel(g2);

 	  }

	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT && !bp.getBoard().getLeftFlipper().isUp())
		{
			bp.getBoard().getLeftFlipper().Flip();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && !bp.getBoard().getRightFlipper().isUp())
				{
					bp.getBoard().getRightFlipper().Flip();
		}
	}
		public void keyReleased(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				bp.getBoard().getLeftFlipper().Flip();
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				bp.getBoard().getRightFlipper().Flip();
			}

		}
		public void keyTyped(KeyEvent e)
		{

	}

	public void actionPerformed(ActionEvent e){
	}
}
