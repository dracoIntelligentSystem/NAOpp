package presentation;

import integration.EmpaticFeatures;

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
	
	

	public VoiceRecorder(JFrame jFrame, EmpaticFeatures emotion, JButton source, int featureType) {
		super(jFrame);
		this.emotion=emotion;
		this.source=source;
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Voice/audio recordeer");
		setModal(true);
		recorder = new JavaSoundRecorder("recordVoice//");
		
		principal=new JPanel();
		principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		timer= new JPanel(new FlowLayout());
		console= new JPanel(new FlowLayout());		
		buttons=new JPanel(new FlowLayout());
		
		time=new JLabel("00:00");
		time.setFont(new Font("Serif", Font.BOLD, 36));
		
		timer.add(time);
		
		rec= new JButton(new ImageIcon("icon//rec.png"));
		rec.addActionListener(this);
		console.add(rec);
		
		stop= new JButton(new ImageIcon("icon//stop.png"));
		stop.addActionListener(this);
		console.add(stop);
		
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
		if (e.getSource() == rec){
			rec.setEnabled(false);
			recorder.start();
		}
		else if (e.getSource() == stop){
			rec.setEnabled(true);
			recorder.finish();
		}

	}

}
