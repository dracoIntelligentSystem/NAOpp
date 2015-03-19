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

public class ChoiseFaceExpr extends JDialog implements ActionListener {

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
	public ChoiseFaceExpr(JFrame jframe, EmpaticFeatures emotion, JButton featureButton, int featureType)
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
		
		
		disgusto = new JButton("DISGUSTO");
		felicita = new JButton("FELICITA");
		miscele = new JButton("MISCELE");
		neutra = new JButton("NEUTRA");
		paura = new JButton("PAURA");
		rabbia = new JButton("RABBIA");
		sorpresa = new JButton("SORPRESA");
		tristezza = new JButton("TRISTEZZA"); 
		confirm = new JButton("CONFIRM"); 
		back = new JButton("BACK");
		clean = new JButton("CLEAN");
		
		faceExpr.add(disgusto);
		faceExpr.add(felicita);
		faceExpr.add(miscele);
		faceExpr.add(paura);
		faceExpr.add(neutra);
		faceExpr.add(rabbia);
		faceExpr.add(sorpresa);
		faceExpr.add(tristezza);
		
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
			choiseFeatureSelection("disgusto", (JButton)e.getSource());
		}
		else if (e.getSource()== felicita)
		{
			choiseFeatureSelection("felicita", (JButton)e.getSource());
		}
		else if ( e.getSource() == miscele)
		{
			choiseFeatureSelection("miscele", (JButton)e.getSource());
		}
		else if ( e.getSource() == neutra)
		{
			choiseFeatureSelection("neutra", (JButton)e.getSource());
		}
		else if ( e.getSource() == paura)
		{
			choiseFeatureSelection("paura", (JButton)e.getSource());
		}
		else if ( e.getSource() == rabbia)
		{
			choiseFeatureSelection("rabbia", (JButton)e.getSource());
		}
		else if ( e.getSource() == sorpresa)
		{
			choiseFeatureSelection("sorpresa", (JButton)e.getSource());
		}
		else if ( e.getSource() == tristezza)
		{
			choiseFeatureSelection("tristezza", (JButton)e.getSource());
		}
		else if (e.getSource() == confirm)
		{
			EmpaticNAO.upgradeStatus(featureButton.getText().toLowerCase(), this, "put");
			dispose();
		}
		else if (e.getSource() == clean) 
		{
			featureClean();
			EmpaticNAO.upgradeStatus(featureButton.getText().toLowerCase(), this, "del");
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
		case 2://ACTION 
			BuildEmotion.cleanActionFeature();
			break;
		case 3://GESTURE
			BuildEmotion.cleanGestureFeature();
			break;

		default:
			break;
		}
	}

	private void choiseFeatureSelection(String emotionCategory, JButton source) {
		switch (featureType) {
		case 0://FACE EXPRESSION IMAGES
			callFaceExpression(emotionCategory, source);
			break;
		case 1://AUDIO VOICE
			break;
		case 2://ACTION 
			break;
		case 3://GESTURE
			break;

		default:
			break;
		}
		
	}

	private void callFaceExpression(String emotionCat, JButton jButton) {
		try {
			@SuppressWarnings("unused")
			ImageSlider imgChoise = new ImageSlider(new JFrame(), emotionCat, jButton, emotion);
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

}
