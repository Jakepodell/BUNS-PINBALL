import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class BoardPanel extends JPanel
{

	Board b;
	ScorePanel sp;
	public BoardPanel(ScorePanel sp)
	{
		this.sp=sp;
		b = new Board(sp);
		setVisible(false);

	}
	public void restart(ScorePanel sp){
		b = new Board(sp);
	}
	public void drawBoardPanel(Graphics2D g2){
		b.drawBoard(g2);
	}
	public void update(){
		b.update();
	}
	public Board getBoard(){
		return b;
	}

}
