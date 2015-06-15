import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class ScorePanel extends JPanel
{
	Toolkit tk;
	JLabel score;
	JLabel lives;
	JLabel HighScore;
	JLabel p;
	Image i1,i2,i3;
	int currentscore = 0;
	int highscore = 0;
	int livesleft = 3;

	public ScorePanel()
	{
				tk = Toolkit.getDefaultToolkit();
				//i1 = tk.getImage("");
				//i2 = tk.getImage("");
				//i3 = tk.getImage("");
				setSize(300,500);
				setLayout(new GridLayout(4,1));
				score = new JLabel("Your score is: " + currentscore);
				//lives = new JLabel("" + i3);
				HighScore = new JLabel("The High Score is: " + highscore);
				p = new JLabel("Score Panel");
				score.setLocation(0,100);
				//lives.setLocation(0,200);
				HighScore.setLocation(0,300);
				p.setLocation(0,0);
				add(p);
				add(score);
				//add(lives);
				add(HighScore);
				setVisible(false);
		        setOpaque(false);
	}
	public int getScore()
	{
		return currentscore;
	}
	public void addScore(int s)
	{
		currentscore += s;
		score.setText("Your score is: " + currentscore);
	}
	public void loseLife()
	{

			/*livesleft--;
			if(livesleft == 2)
			{
				lives.setText("" + i2);
			}
			if(livesleft == 1)
			{
				lives.setText("" + i1);
			}*/
	}
	public int getLives()
	{
		return livesleft;
	}
	public int getHighScore()
	{
		return highscore;
	}
	public void setHighScore(int hs){
		highscore  =hs;
		HighScore.setText("The High Score is: " + highscore);
	}
}
