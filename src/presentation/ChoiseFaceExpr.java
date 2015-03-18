package presentation;

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

public class ChoiseFaceExpr extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton disgusto, felicita, miscele, neutra, paura, rabbia, sorpresa, tristezza, confirm, abort;
	private JPanel panel, faceExpr, button;
	
	//public ChoiseFaceExpr(JFrame jframe, boolean b)
	public ChoiseFaceExpr(JFrame jframe)
	{
		
		super(jframe);
//		super(new JFrame());
//		jframe.setEnabled(false);
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
		abort = new JButton("ABORT");
		
		faceExpr.add(disgusto);
		faceExpr.add(felicita);
		faceExpr.add(miscele);
		faceExpr.add(paura);
		faceExpr.add(neutra);
		faceExpr.add(rabbia);
		faceExpr.add(sorpresa);
		faceExpr.add(tristezza);
		
		button.add(confirm);
		button.add(abort);
		
		disgusto.addActionListener(this);
		felicita.addActionListener(this);
		miscele.addActionListener(this);
		neutra.addActionListener(this);
		paura.addActionListener(this);
		rabbia.addActionListener(this);
		sorpresa.addActionListener(this);
		tristezza.addActionListener(this); 
		confirm.addActionListener(this); 
		abort.addActionListener(this);
		
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
			callFaceExpression("disgusto", (JButton)e.getSource());
		}
		else if (e.getSource()== felicita)
		{
			callFaceExpression("felicita", (JButton)e.getSource());
		}
		else if ( e.getSource() == miscele)
		{
			callFaceExpression("miscele", (JButton)e.getSource());
		}
		else if ( e.getSource() == neutra)
		{
			callFaceExpression("neutra", (JButton)e.getSource());
		}
		else if ( e.getSource() == paura)
		{
			callFaceExpression("paura", (JButton)e.getSource());
		}
		else if ( e.getSource() == rabbia)
		{
			callFaceExpression("rabbia", (JButton)e.getSource());
		}
		else if ( e.getSource() == sorpresa)
		{
			callFaceExpression("sorpresa", (JButton)e.getSource());
		}
		else if ( e.getSource() == tristezza)
		{
			callFaceExpression("tristezza", (JButton)e.getSource());
		}
		else if (e.getSource() == confirm)
		{
			
		}
		else if (e.getSource() == abort) 
		{
			dispose();
		}
	}

	private void callFaceExpression(String emotion, JButton jButton) {
		try {
			@SuppressWarnings("unused")
			ImageSlider imgChoise = new ImageSlider(new JFrame(), emotion, jButton);
		} catch (HeadlessException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}

}
