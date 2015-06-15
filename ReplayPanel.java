import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class ReplayPanel extends JPanel implements ActionListener
{

	JLabel replay;
	JButton play;
	boolean isClicked;
	public ReplayPanel()
	{
				setVisible(false);
				setSize(300,500);
				setLayout(new GridLayout(3,1));
				replay = new JLabel("You Lost! Click to replay!");
				play = new JButton("Replay");
				add(replay);
				//add(ins);
				add(play);
				play.addActionListener(this);
				isClicked=false;

				//play.addActionListener(this);
	}
	public void start()
	{

	}
	public static void main(String[] args){
		new ReplayPanel();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==play){
			isClicked=true;
			System.out.println("Fdsfsa");
		}
	}
	public boolean isClicked(){
		return isClicked;
	}

}
