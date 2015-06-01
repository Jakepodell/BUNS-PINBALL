import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class BoardPanel extends JPanel
{

	Board b;
	public BoardPanel()
	{

		b = new Board();

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
