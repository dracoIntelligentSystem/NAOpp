package presentation;

import integration.EmpaticFeatures;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import business.core.BuildEmotion;
//import business.core.JavaSoundRecorder;
import business.core.SimpleSoundCapture;
import business.core.WebServiceVoice;

public class VoiceRecorder extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private EmpaticFeatures emotion;
	@SuppressWarnings("unused")
	private JButton rec, stop, back, confirm, source;
	private JPanel principal, timer, console, buttons;
	private JLabel time;
	//private JavaSoundRecorder recorder;
	private SimpleSoundCapture ssc;
	

	public VoiceRecorder(JFrame jFrame, EmpaticFeatures emotion, JButton source, int featureType) {
		super(jFrame);
		this.emotion=emotion;
		this.source=source;
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Voice/audio recordeer");
		setModal(true);
		//recorder = new JavaSoundRecorder("recordVoice//");
		time=new JLabel();
		//time.setFont(new Font("Serif", Font.BOLD, 36));
        try {
			ssc = new SimpleSoundCapture(time);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ssc.open();
		
		principal=new JPanel();
		principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		timer= new JPanel(new FlowLayout());
		console= new JPanel(new FlowLayout());		
		buttons=new JPanel(new FlowLayout());
		
		
		
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
			WebServiceVoice.Initialize(ssc.getVoiceRec().getAbsolutePath());
			BuildEmotion.setAudioFeature(WebServiceVoice.getWav(), 
					ssc.getVoiceRec().getAbsolutePath(), 
					WebServiceVoice.getEmotion().toLowerCase(),
					WebServiceVoice.getArousal().toLowerCase(), 
					WebServiceVoice.getValence().toLowerCase());
			System.out.println(ssc.getVoiceRec().getAbsolutePath());
			System.out.println("Arousal from service: "+WebServiceVoice.getArousal().toLowerCase()); 
			System.out.println("Arousal from service: "+WebServiceVoice.getValence().toLowerCase());
			//TO-DO REQUEST FOR TO GET AROUSAL AND VALENCE FROM WEBSERVICE
			/*
			 * String arousal = TOMCAT(FILE);
			 * String valence = TOMCAT(FILE);
			 * BuildEmotion.setAudioFeature(arousal,valence);
			 */
			source.setBackground(Color.yellow);
			dispose();
			
		}
		else if (e.getSource() == back){
			dispose();
		}
	}

}
