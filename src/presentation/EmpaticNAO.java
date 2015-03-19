package presentation;

import integration.EmpaticFeatures;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import business.core.BuildEmotion;

public class EmpaticNAO extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean abort = false;
	private static HashMap<String, ChoiseFaceExpr> status = new HashMap<String, ChoiseFaceExpr>();
	
	
	private JFrame startFrame;
	private JPanel Principal, buttonPanel;
	private JButton Images, Audio, Gesture, Action, Back, Confirm, clean;
	private EmpaticFeatures emotion;
	
	
	public EmpaticNAO(StartFrame startFrame) {
		this.startFrame=startFrame;
		this.setTitle("NAO EMPATIC SOCIAL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Principal= new JPanel(new GridLayout(5, 1));
		buttonPanel = new JPanel(new FlowLayout());
		Images = new JButton("Images", new ImageIcon("src\\integration\\icon\\male-user-icon-clip-art.jpg"));
		Images.addActionListener(this);
		Audio = new JButton("Audio", new ImageIcon("src\\integration\\icon\\voice_icon.jpg"));
		Audio.addActionListener(this);
		Gesture = new JButton("Gesture", new ImageIcon("src\\integration\\icon\\body.png"));
		Gesture.addActionListener(this);
		Action = new JButton("Action", new ImageIcon("src\\integration\\icon\\gloabl-action-icon.png"));
		Action.addActionListener(this);
		Back = new JButton("Back");
		Back.addActionListener(this);
		Confirm = new JButton("Confirm");
		Confirm.addActionListener(this);
		clean = new JButton("Clean");
		clean.addActionListener(this);
		
		Principal.add(Images);
		Principal.add(Audio);
		Principal.add(Gesture);
		Principal.add(Action);
		buttonPanel.add(Back);
		buttonPanel.add(Confirm);
		buttonPanel.add(clean);
		Principal.add(buttonPanel);
		this.getContentPane().add(Principal);
		this.pack();this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Images){ //feature type 0
			ChoiseFaceExpr choiseFace=null;
			if(status.get("images")==null)
				{
				choiseFace = new ChoiseFaceExpr(new JFrame(), emotion, (JButton)e.getSource(), 0);
				}
			else {
				choiseFace=status.get("images");
				choiseFace.setVisible(true);
			}
			//new ChoiseFaceExpr(new JFrame(), emotion, (JButton)e.getSource(), 0);
			emotion=BuildEmotion.getEmotion();
			if(!abort)
				System.out.println("Espressione Facciale Acquisita");
		}
		else if (e.getSource() == Audio){//feature type 1
			System.out.println("Scelta: Audio");
		}
		else if (e.getSource() == Gesture){//feature type 2
			System.out.println("Scelta: Gesture");
		}
		else if (e.getSource() == Action){//feature type 3
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
	
	public static void upgradeStatus(String feature, ChoiseFaceExpr choiseFaceExpr, String operationStatus){
		if(operationStatus.equals("put"))
		{
			status.put(feature, choiseFaceExpr);
			abort=false;
		}
		else if (operationStatus.equals("del"))
		{
			status.remove(feature);
			abort=true;
		}
			
	}

}
