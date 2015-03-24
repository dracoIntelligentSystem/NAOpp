package presentation;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import integration.EmpaticFeatures;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChoiseModeAudio extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton SelectVoice, recordVoice, back;
	private JPanel principal, choice, buttons;
	private int choiceMethod=0;

	public ChoiseModeAudio(JFrame jFrame) {
		super(jFrame);
		setModal(true);
		SelectVoice=new JButton("Select track", new ImageIcon("icon\\clicked.png"));
		recordVoice= new JButton("Record track", new ImageIcon("icon\\mic.jpg"));
		principal= new JPanel(new GridLayout(2,1));
		choice = new JPanel(new GridLayout(1,2));
		buttons= new JPanel(new FlowLayout());
		SelectVoice.addActionListener(this);
		recordVoice.addActionListener(this);
		choice.add(SelectVoice);
		choice.add(recordVoice);
				
		back= new JButton("BACK");
		back.addActionListener(this);
		buttons.add(back);
		
		principal.add(choice);
		principal.add(buttons);
		getContentPane().add(principal);
		this.pack();
		setVisible(true);
	}
	
	public int getChoise(){
		return choiceMethod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SelectVoice)
		{
			choiceMethod=1;
		}
		else if (e.getSource() == recordVoice)
		{
			choiceMethod=2;
		}
//		else if (e.getSource() == back)
//		{
//			
//		}
		dispose();
		
	}
}
