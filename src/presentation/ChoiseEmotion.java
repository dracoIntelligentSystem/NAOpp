package presentation;

import integration.EmpaticFeatures;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import business.core.BuildEmotion;

public class ChoiseEmotion extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JButton disgusto, felicita, miscele, neutra, paura, rabbia, sorpresa, tristezza, confirm, clean, back;
	private JPanel panel, faceExpr, button;
	private EmpaticFeatures emotion;
	private int featureType;
	private JButton featureButton;
	
	//public ChoiseFaceExpr(JFrame jframe, boolean b)
	public ChoiseEmotion(JFrame jframe, EmpaticFeatures emotion, JButton featureButton, int featureType)
	{
		
		super(jframe);
		this.emotion=emotion;
		this.featureButton=featureButton;
		this.featureType=featureType;
		setTitle(this.featureButton.getText() + " Emotion Selection");
		setModal(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
		panel = new JPanel(new GridLayout(2,1));
		faceExpr = new JPanel(new GridLayout(4, 2));
		button = new JPanel(new FlowLayout());
		
		
		disgusto = new JButton("DISGUSTO");disgusto.setName("disgust");
		disgusto.setEnabled(false);
		felicita = new JButton("FELICITA");felicita.setName("happy");
		miscele = new JButton("MISCELE");miscele.setName("mixtures");
		miscele.setEnabled(false);
		neutra = new JButton("NEUTRA");neutra.setName("neutral");
		paura = new JButton("PAURA");paura.setName("fear");
		paura.setEnabled(false);
		rabbia = new JButton("RABBIA");rabbia.setName("anger");
		sorpresa = new JButton("SORPRESA");sorpresa.setName("surprise");
		sorpresa.setEnabled(false);
		tristezza = new JButton("TRISTEZZA");tristezza.setName("sad"); 
		confirm = new JButton("CONFIRM"); 
		back = new JButton("BACK");
		clean = new JButton("CLEAN");
		
		if (this.emotion!= null)
			controlPreviousChoise(this.emotion, this.featureType);
		
		faceExpr.add(tristezza);
		faceExpr.add(rabbia);
		faceExpr.add(neutra);
		faceExpr.add(felicita);
		faceExpr.add(paura);
		faceExpr.add(miscele);
		faceExpr.add(sorpresa);
		faceExpr.add(disgusto);		

		button.add(confirm);
		button.add(clean);
		button.add(back);
		
		disgusto.addActionListener(this);
		felicita.addActionListener(this);
		miscele.addActionListener(this);
		neutra.addActionListener(this);
		paura.addActionListener(this);
		rabbia.addActionListener(this);
		sorpresa.addActionListener(this);
		tristezza.addActionListener(this); 
		confirm.addActionListener(this); 
		clean.addActionListener(this);
		back.addActionListener(this);
		
		panel.add(faceExpr);
		panel.add(button);
		this.getContentPane().add(panel);
		setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
		
		this.pack();
		this.setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == disgusto)
		{
			choiseFeatureSelection("disgusto", ((JButton)e.getSource()).getName(),(JButton)e.getSource());
		}
		else if (e.getSource()== felicita)
		{
			choiseFeatureSelection("felicita", ((JButton)e.getSource()).getName(),(JButton)e.getSource());
		}
		else if ( e.getSource() == miscele)
		{
			choiseFeatureSelection("miscele", ((JButton)e.getSource()).getName(),(JButton)e.getSource());
		}
		else if ( e.getSource() == neutra)
		{
			choiseFeatureSelection("neutra", ((JButton)e.getSource()).getName(),(JButton)e.getSource());
		}
		else if ( e.getSource() == paura)
		{
			choiseFeatureSelection("paura", ((JButton)e.getSource()).getName(),(JButton)e.getSource());
		}
		else if ( e.getSource() == rabbia)
		{
			choiseFeatureSelection("rabbia", ((JButton)e.getSource()).getName(),(JButton)e.getSource());
		}
		else if ( e.getSource() == sorpresa)
		{
			choiseFeatureSelection("sorpresa", ((JButton)e.getSource()).getName(),(JButton)e.getSource());
		}
		else if ( e.getSource() == tristezza)
		{
			choiseFeatureSelection("tristezza", ((JButton)e.getSource()).getName(),(JButton)e.getSource());
		}
		else if (e.getSource() == confirm)
		{
//			EmpaticNAO.upgradeStatus(featureButton.getText().toLowerCase(), this, "put");
			featureButton.setBackground(Color.YELLOW);
			//setVisible(false);
			//this.emotion=BuildEmotion.getEmotion();
			dispose();
		}
		else if (e.getSource() == clean) 
		{
			featureClean();
//			EmpaticNAO.upgradeStatus(featureButton.getText().toLowerCase(), this, "del");
			featureButton.setBackground(null);
			dispose();
		}
		else if (e.getSource() == back)
		{
			dispose();
		}
	}

	private void featureClean() {
		switch (featureType) {
		case 0: //FACE EXPRESSION IMAGES
			BuildEmotion.cleanFaceFeature();
			break;
		case 1://AUDIO VOICE
			BuildEmotion.cleanAudioFeature();
			break;
		case 2://Event 
			BuildEmotion.cleanEventFeature();
			break;
		case 3://GESTURE
			BuildEmotion.cleanGestureFeature();
			break;

		default:
			break;
		}
	}

	private void choiseFeatureSelection(String emotionCategory, String emo2Send, JButton source) {
		switch (featureType) {
		case 0://FACE EXPRESSION IMAGES
			callFaceExpression(emotionCategory, emo2Send, source);
			break;
		case 1://AUDIO VOICE
			callAudioExpression(emotionCategory, source);
			break;
		case 2://Event
			callEventExpression(emotionCategory,source);
			break;
		case 3://GESTURE
			break;

		default:
			break;
		}
		
	}

	private void callEventExpression(String emotionCategory, JButton source) {
		@SuppressWarnings("unused")
		EventChoice eventChoice = new EventChoice(new JFrame(), emotionCategory, source);
		
	}

	private void callAudioExpression(String emotionCategory, JButton source) {
		@SuppressWarnings("unused")
		VoiceChoise voiseChoise = new VoiceChoise(new JFrame(), emotionCategory, source);
	}

	private void callFaceExpression(String emotionCat, String emo2Send, JButton jButton) {
		try {
			@SuppressWarnings("unused")
			ImageSlider imgChoise = new ImageSlider(new JFrame(), emotionCat, emo2Send, jButton, emotion);
		} catch (HeadlessException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}

	public static void refreshButton() {
		disgusto.setBackground(null);
		felicita.setBackground(null);
		miscele.setBackground(null);
		neutra.setBackground(null);
		paura.setBackground(null);
		rabbia.setBackground(null);
		sorpresa.setBackground(null);
		tristezza.setBackground(null);
	}

	private void controlPreviousChoise(EmpaticFeatures status,int PreviousType) {
		switch (PreviousType) {
		case 0:
			if(status.getFace()!=null){
				HighLight(status.getFace().getEmotionCategory());
			}
			break;
		case 1:
			if(status.getAudio()!=null){
				HighLight(status.getAudio().getEmotionCategory());
			}
			break;
		case 2:
			if(status.getEvent()!=null){
				HighLight(status.getEvent().getEmotionCategory());
			}
			break;
		case 3:
			if(status.getGesture()!=null){
				//HighLight(status.getGesture().getEmotionCategory());
			}
			break;
		default:
			break;
		}

	}

	private void HighLight(String emotionCategory) {
		if (disgusto.getText().toLowerCase().equals(emotionCategory))
			disgusto.setBackground(Color.YELLOW);
		else if(felicita.getText().toLowerCase().equals(emotionCategory))
			felicita.setBackground(Color.YELLOW);
		else if(miscele.getText().toLowerCase().equals(emotionCategory))
			miscele.setBackground(Color.YELLOW);
		else if(neutra.getText().toLowerCase().equals(emotionCategory))
			neutra.setBackground(Color.YELLOW);
		else if(paura.getText().toLowerCase().equals(emotionCategory))
			paura.setBackground(Color.YELLOW);
		else if(rabbia.getText().toLowerCase().equals(emotionCategory))
			rabbia.setBackground(Color.YELLOW);
		else if(sorpresa.getText().toLowerCase().equals(emotionCategory))
			sorpresa.setBackground(Color.YELLOW);
		else if(tristezza.getText().toLowerCase().equals(emotionCategory))
			tristezza.setBackground(Color.YELLOW);
	}
}
