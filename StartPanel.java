import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class StartPanel extends JFrame
{

	JLabel start;
	JButton ins;
	JButton play;
	public StartPanel()
	{
				setVisible(true);
				setSize(300,500);
				setLayout(new GridLayout(3,1));
				start = new JLabel("Welcome to BUNS' Pinball!");
				ins = new JButton("Instructions");
				play = new JButton("Start");
				add(start);
				//add(ins);
				add(play);

				//play.addActionListener(this);
	}
	public void start()
	{

	}
	public static void main(String[] args){
		new StartPanel();
	}
	/*public void actionPerformed(ActionEvent e){
		if(e.getSource()==play){
			System.out.println("Will work");
		}
	}*/

}
