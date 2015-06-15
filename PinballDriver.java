import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class PinballDriver extends JApplet implements ActionListener, Runnable, KeyListener
{
	public static int APPLETPADDING=50;
	StartPanel sp = new StartPanel();
	BoardPanel bp;
	//Timer timer;
	Thread thread;
	ScorePanel s;
	ReplayPanel r;
	double scoreCounter;
	static AudioClip bumpSound, flipperSound, backgroundSound, bouncyBounce,bounce2, launchSound, solidSound,menuSound,success,lose,grassfrohit, explodeSound, explodeSound2;
	enum GameState{playing,won,menu,lose}
	GameState state = GameState.menu;
	ParticleEngine pe;
	public void init()
	{
		setContentPane(new DrawingPanel());
		setSize(new Dimension(Board.WIDTH+APPLETPADDING*2+300, Board.HEIGHT+APPLETPADDING*2));
		s = new ScorePanel();
		bp = new BoardPanel(s);
		r = new ReplayPanel();
		//timer = new Timer(20, this);
		//timer.start();
		setLayout(null);
		s.setLocation(450,50);
		add(s);
		add(r);
		thread = new Thread(this);
		thread.start();
		setFocusable(true);
		addKeyListener(this);
		//sp.setVisible(true);
		add(sp);
		pe = new ParticleEngine();

		backgroundSound = getAudioClip(getDocumentBase(), "background.wav");
		bumpSound = getAudioClip(getDocumentBase(), "bumpSound.wav");
		flipperSound = getAudioClip(getDocumentBase(), "flipperSound.wav");
		bounce2 = getAudioClip(getDocumentBase(), "bounce2.wav");
		bouncyBounce = getAudioClip(getDocumentBase(), "bouncy-bounce.wav");
		launchSound = getAudioClip(getDocumentBase(), "launch.wav");
		solidSound = getAudioClip(getDocumentBase(), "solidcollide.wav");
		menuSound= getAudioClip(getDocumentBase(),"menubackground.wav");
		success= getAudioClip(getDocumentBase(),"success.wav");
		lose= getAudioClip(getDocumentBase(),"lose.wav");
		grassfrohit= getAudioClip(getDocumentBase(),"grassfroHit.wav");
		explodeSound= getAudioClip(getDocumentBase(),"explode.wav");
		explodeSound2= getAudioClip(getDocumentBase(),"explode2.wav");

		//backgroundSound.loop();
	//	bouncyBounce.loop();

	}
	public static void playBumperSound(){
		bumpSound.play();
	}
	public static void playFlipperSound(){
		flipperSound.play();
	}
	public void run(){
		while(true){


			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(state==GameState.menu&&sp.isClicked){
				sp.setVisible(false);
				bp.setVisible(true);
				s.setVisible(true);
				r.setVisible(false);
				state = GameState.playing;
				backgroundSound.loop();
			}
			if(state==GameState.playing){
				bp.update();
				repaint();
				if(scoreCounter%20==0)s.addScore(1);
				scoreCounter++;
				if(s.getLives() == 0)
				{
					state=GameState.lose;
				}
			}
			if(state==GameState.lose){
				sp.setVisible(false);
				bp.setVisible(false);
				s.setVisible(false);
				r.setVisible(true);
			}
			if(s.getScore()>s.getHighScore()){
				s.setHighScore(s.getScore());
				pe.explodeRandomColors(s.getX()+30,s.getY()+450);
			}
			for (Particle p : pe.getParticleList())
				p.tick();
			pe.removeOffScreenParticles();

		}
	}

	 public class DrawingPanel extends JPanel
	{
	  public void paintComponent(Graphics g)
  	  {
		  super.paintComponent(g);
		  Graphics2D g2 = (Graphics2D) g;
		  pe.draw(g2);

		  if(bp.isVisible())bp.drawBoardPanel(g2);

 	  }

	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT && !bp.getBoard().getLeftFlipper().isUp())
		{
			bp.getBoard().getLeftFlipper().Flip();
			bp.getBoard().checkFlipperCollision();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && !bp.getBoard().getRightFlipper().isUp())
				{
					bp.getBoard().getRightFlipper().Flip();
					bp.getBoard().checkFlipperCollision();
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
