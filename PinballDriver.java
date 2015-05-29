import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PinballDriver extends JApplet implements ActionListener, Runnable
{
	public static int APPLETPADDING=50;
	BoardPanel bp;
	//Timer timer;
	Thread thread;
	public void init()
	{
		setContentPane(new DrawingPanel());
		setSize(new Dimension(Board.WIDTH+APPLETPADDING*2, Board.HEIGHT+APPLETPADDING*2));
		bp = new BoardPanel();
		//timer = new Timer(20, this);
		//timer.start();
		thread = new Thread(this);
		thread.start();

	}
	public void run(){
		while(true){
			bp.update();
			repaint();
			try {
				Thread.sleep(30L);
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

	public void actionPerformed(ActionEvent e){
	}
}
