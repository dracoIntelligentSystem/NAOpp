package presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import business.core.BuildEmotion;
import business.core.CategorizationEvent;

public class EventChoice extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String emo="";
	private JButton source, back, confirm;
	private JPanel Principal, event, buttons;
	private JComboBox<String> eventExamples=null;
	
	public EventChoice(JFrame jFrame, String emotionCategory, JButton source) {
		super(jFrame);
		this.emo=emotionCategory;
		this.source=source;
		setTitle("Choice appropriate Event");
		setModal(true);
		Principal = new JPanel(new GridLayout(2, 1));
		event = new JPanel(new FlowLayout());
		JLabel label = new JLabel("Choice an event:");
		eventExamples = new JComboBox<String>(CategorizationEvent.getSamples(emotionCategory));
		event.add(label);event.add(eventExamples);
		Principal.add(event);
		
		confirm=new JButton("CONFIRM"); confirm.addActionListener(this);
		back= new JButton("back");back.addActionListener(this);
		buttons= new JPanel(new FlowLayout());
		buttons.add(confirm);
		buttons.add(back);
		Principal.add(buttons);
		//eventExamples = new 
		this.getContentPane().add(Principal);
		this.pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirm){
			BuildEmotion.setEventFeature(eventExamples.getSelectedItem().toString(), emo);
			source.setBackground(Color.YELLOW);
			System.out.println("Event aquired!!!");
		}
		else if (e.getSource() == back){
			
		}
		dispose();
	}

}
