package presentation;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EmpaticNAO extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame startFrame;
	private String image;
	private JPanel Principal, buttonPanel;
	private JButton Images, Audio, Gesture, Action, Back, Confirm;
	
	public EmpaticNAO(StartFrame startFrame) {
		this.startFrame=startFrame;
		this.setTitle("NAO EMPATIC SOCIAL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Principal= new JPanel(new GridLayout(5, 1));
		buttonPanel = new JPanel(new FlowLayout());
		Images = new JButton("Images", new ImageIcon("C:\\Users\\dragoSI\\Downloads\\eclipse\\workspace\\NAOpp\\src\\integration\\male-user-icon-clip-art.jpg"));
		Images.addActionListener(this);
		Audio = new JButton("Audio", new ImageIcon("C:\\Users\\dragoSI\\Downloads\\eclipse\\workspace\\NAOpp\\src\\integration\\voice_icon.jpg"));
		Audio.addActionListener(this);
		Gesture = new JButton("Gesture", new ImageIcon("C:\\Users\\dragoSI\\Downloads\\eclipse\\workspace\\NAOpp\\src\\integration\\body.png"));
		Gesture.addActionListener(this);
		Action = new JButton("Action", new ImageIcon("C:\\Users\\dragoSI\\Downloads\\eclipse\\workspace\\NAOpp\\src\\integration\\gloabl-action-icon.png"));
		Action.addActionListener(this);
		Back = new JButton("Back");
		Back.addActionListener(this);
		Confirm = new JButton("Confirm");
		Confirm.addActionListener(this);
		
		Principal.add(Images);
		Principal.add(Audio);
		Principal.add(Gesture);
		Principal.add(Action);
		buttonPanel.add(Back);
		buttonPanel.add(Confirm);
		Principal.add(buttonPanel);
		this.getContentPane().add(Principal);
		this.pack();this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Images){
			System.out.println("Scelta: Images");
		}
		else if (e.getSource() == Audio){
			System.out.println("Scelta: Audio");
		}
		else if (e.getSource() == Gesture){
			System.out.println("Scelta: Gesture");
		}
		else if (e.getSource() == Action){
			System.out.println("Scelta: Action");
		}
		else if (e.getSource() == Back){
			System.out.println("Nessuna Scelta fatta, schermata principale");
			startFrame.setVisible(true);
			this.dispose();
		}
		else if (e.getSource() == Confirm){
			System.out.println("Scelta Confermata");
		}
			

	}

}
