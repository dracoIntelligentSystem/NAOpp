package presentation;

import integration.EmpaticFeatures;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import business.core.JavaSoundRecorder;
import business.core.SimpleSoundCapture;

public class VoiceRecorder extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmpaticFeatures emotion;
	private JButton rec, stop, back, confirm, source;
	private JPanel principal, timer, console, buttons;
	private JLabel time;
	private JavaSoundRecorder recorder;
	private SimpleSoundCapture ssc;
	

	public VoiceRecorder(JFrame jFrame, EmpaticFeatures emotion, JButton source, int featureType) {
		super(jFrame);
		this.emotion=emotion;
		this.source=source;
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Voice/audio recordeer");
		setModal(true);
		//recorder = new JavaSoundRecorder("recordVoice//");
        ssc = new SimpleSoundCapture();
        ssc.open();
		
		principal=new JPanel();
		principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		timer= new JPanel(new FlowLayout());
		console= new JPanel(new FlowLayout());		
		buttons=new JPanel(new FlowLayout());
		
		time=new JLabel("00:00");
		time.setFont(new Font("Serif", Font.BOLD, 36));
		
		timer.add(time);
		
//		rec= new JButton(new ImageIcon("icon//rec.png"));
//		rec.addActionListener(this);
//		console.add(rec);
//		
//		stop= new JButton(new ImageIcon("icon//stop.png"));
//		stop.addActionListener(this);
		console.add(ssc);
		
		back= new JButton("back");
		back.addActionListener(this);
		buttons.add(back);
		
		confirm=new JButton("CONFIRM");
		confirm.addActionListener(this);
		buttons.add(confirm);
		
		principal.add(timer);
		principal.add(console);
		principal.add(buttons);
		
		this.getContentPane().add(principal);
		this.pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirm){
			System.out.println(ssc.getVoiceRec().getAbsolutePath());
			//TO-DO REQUEST FOR TO GET AROUSAL AND VALENCE FROM WEBSERVICE
			/*
			 * String arousal = TOMCAT(FILE);
			 * String valence = TOMCAT(FILE);
			 * BuildEmotion.setAudioFeature(arousal,valence);
			 */
			dispose();
			source.setBackground(Color.yellow);
		}
		else if (e.getSource() == back){
			dispose();
		}
	}

}
