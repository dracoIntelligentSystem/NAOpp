package presentation;

import integration.Speech;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import table.JTableAdHooc;
import table.MyTableModel;
import business.core.BuildEmotion;
import business.core.CategorizationVoiceEmotion;
import business.core.PlayerVlc;

public class VoiceChoise extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String[] columnNames;
	private static Object[][] data;
	private JButton confirm, back;
	private JPanel Principal, mediaPlayerPanel, button;
	//private JLabel etichetta;
	private JTableAdHooc myTable;
	private MyTableModel mymodel;
	private String path = "file_audio\\";
	private JButton SELECTION_VOICETYPE;
	private PlayerVlc p;
	private String Emo;
	
	public VoiceChoise(JFrame jframe, String Emo, JButton source) {
		super(jframe);
		this.SELECTION_VOICETYPE=source;
		this.Emo=Emo;
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//etichetta = new JLabel("Testo su evento tabella");
//TEST	//columnNames=new String[] {"#Voice","Name","Emotion","Valence","Arousal","Duration (s)","Format","Path"};
		columnNames=new String[] {"#Voice","Name","Emotion","Duration (s)","Format","Path"};
		data = fillDataMatrix(path, this.Emo);
		setModal(true);
		
		p = new PlayerVlc();
		
		mymodel = new MyTableModel(columnNames, data);
		myTable = new JTableAdHooc(mymodel);
		{	
			Principal=new JPanel();		
			Principal.setLayout(new BoxLayout(Principal, BoxLayout.Y_AXIS));
			{
				
				myTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			        public void valueChanged(ListSelectionEvent event) {
			        	//APPRONTARE IL MEDIA PLAYER QUI
			            //etichetta.setText(myTable.getValueAt(event.getLastIndex(), 5).toString());
			        	p.play(myTable.getValueAt(myTable.getSelectedRow(), 5).toString());
			        }
			    });
				
				myTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(java.awt.event.MouseEvent e) {
						p.play(((JTableAdHooc)e.getSource()).getValueAt(myTable.getSelectedRow(), 5).toString());
					}
				});
				JScrollPane scrollPane = new JScrollPane(myTable);
				//scrollPane.setPreferredSize(new Dimension(myTable.getPreferredSize().width, myTable.getRowHeight()*myTable.getRowCount()));
				Principal.add(scrollPane);
			}
			
			{
				mediaPlayerPanel = new JPanel(new GridLayout(1, 1));
//				etichetta = new JLabel("Testo su evento tabella");
				mediaPlayerPanel.add(p);
				Principal.add(mediaPlayerPanel);
			}
			
			{
				button = new JPanel(new FlowLayout());
				confirm = new JButton("CONFIRM");
				back = new JButton("BACK");
				confirm.addActionListener(this);
				back.addActionListener(this);
				button.add(confirm);
				button.add(back);
				Principal.add(button);
			}
			
		}
		
		this.getContentPane().add(Principal);
		
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirm){
			ChoiseEmotion.refreshButton();
			SELECTION_VOICETYPE.setBackground(Color.YELLOW);
			BuildEmotion.setAudioFeature(new File(myTable.getValueAt(myTable.getSelectedRow(), 5).toString()),
					myTable.getValueAt(myTable.getSelectedRow(), 5).toString(), this.Emo);
//TEST		//			BuildEmotion.setAudioFeature(new File(myTable.getValueAt(myTable.getSelectedRow(), 7).toString()),
//TEST		//										 myTable.getValueAt(myTable.getSelectedRow(), 7).toString(), 
//TEST		//										 this.Emo, 
//TEST		//										 myTable.getValueAt(myTable.getSelectedRow(), 5).toString(),
//TEST		//										 myTable.getValueAt(myTable.getSelectedRow(), 4).toString(),);
			System.out.println("Vocal expression, acquired!!");
			dispose();
		}
		else if(e.getSource() == back){
			dispose();
		}

	}
	
	private static Object[][] fillDataMatrix(String path, String Emo) {
		File[] samples = new File(path+Emo+"\\").listFiles();
		Object[][] data = new Object[samples.length][columnNames.length];
		Speech speecValues=null;

		for(int row=0; row<samples.length; row++){
			//int col=0;
			String[] dets = samples[row].getName().split("\\.");
			data[row][0]=String.valueOf(row+1);
			data[row][1]=dets[0];
			data[row][2]=Emo;
			try {
				data[row][3]=PlayerVlc.duration(samples[row]);
			} catch (UnsupportedAudioFileException | IOException e) {
				data[row][3]="NOT AVAIABLE";
			}
			speecValues = CategorizationVoiceEmotion.getRandomSpeech(Emo);
//TEST		//data[row][4]=speecValues.getValence();
//TEST		//data[row][5]=speecValues.getArousal();
			data[row][4]=dets[1];
			data[row][5]=samples[row].getAbsolutePath();
		}

		return data;
	}
}
