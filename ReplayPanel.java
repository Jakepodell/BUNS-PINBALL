import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class ReplayPanel extends JPanel implements ActionListener
{

<<<<<<< HEAD
	JLabel start;
	JButton ins;
=======
	JLabel replay;
>>>>>>> origin/master
	JButton play;
	boolean isClicked;
	public ReplayPanel()
	{
				setVisible(false);
				setSize(300,500);
				setLayout(new GridLayout(3,1));
<<<<<<< HEAD
				start = new JLabel("You lost, loser! :p");
				ins = new JButton("Instructions");
				play = new JButton("Replay");
				add(start);
=======
				replay = new JLabel("You Lost! Click to replay!");
				play = new JButton("Replay");
				add(replay);
>>>>>>> origin/master
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
<<<<<<< HEAD
		new StartPanel();
=======
		new ReplayPanel();
>>>>>>> origin/master
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
<<<<<<< HEAD
	public void reset(){
		isClicked=false;
	}
=======
>>>>>>> origin/master

}
