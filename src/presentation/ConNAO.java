package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import com.aldebaran.*;
//import com.aldebaran.proxy.*;

public class ConNAO extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame startframe;
	private JButton connect, disconnect;
	private JPanel pannello;
	private JTextField DNSBotServer;
	private JTextField BotServer;
	private JTextField CommProt;
	private JTextField PORT;
//	private JTextField username_login;
//	private JPasswordField user_psw;
//	private String RamServerDB_IP="";
	
	public ConNAO(JFrame startFrame) {
		this.startframe= startFrame;
		this.setTitle("NAO ROBOT CONNECTION");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pannello= new JPanel(new GridLayout(5, 2));
		this.getContentPane().add(pannello);
		
		connect = new JButton("CONNECT NAO");
		if (StartFrame.isConnected())
			connect.setEnabled(false);
		else 
			connect.setEnabled(true);
		disconnect = new JButton("DISCONNECT NAO");
		connect.addActionListener(this);
		disconnect.addActionListener(this);
		
		JLabel CommunicationProtocol = new JLabel("Protocol:");
		CommProt = new JTextField("ftp");
		CommProt.setEditable(false);
		
		JLabel lblDNSBotServer = new JLabel("NAO-DNS:");
		DNSBotServer = new JTextField("nao.local");
		DNSBotServer.setEditable(false);
		
		JLabel lblServer = new JLabel("BOT IP:");
		BotServer = new JTextField("0.0.0.0");
		//BotServer = new JTextField("192.168.0.1");
		BotServer.setEditable(false);
		
		JLabel lblPort = new JLabel("PORT:");
		PORT = new JTextField("9559");
		PORT.setEditable(false);
		
		
		pannello.add(CommunicationProtocol);pannello.add(this.CommProt);
		pannello.add(lblDNSBotServer);pannello.add(this.DNSBotServer);
		pannello.add(lblServer);pannello.add(this.BotServer);
		pannello.add(lblPort);pannello.add(this.PORT);

		//JPanel pulsantiera = new JPanel(new FlowLayout());
		pannello.add(connect);pannello.add(disconnect);
		//pannello.add(pulsantiera);
		this.pack();this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connect){
			
				//TEST DA FARE SU BOT
//			ALTextToSpeechProxy tts;
//			tts = new ALTextToSpeechProxy("192.168.0.100",9559);
//			tts.say("Hello, world");
			
			System.out.println("Connesso");
			StartFrame.setConnection(true);
			connect.setEnabled(false);
		}
		else if (e.getSource() == disconnect ){
			System.out.println("Disconnesso");
			StartFrame.setConnection(false);
			connect.setEnabled(true);
		}
		startframe.setVisible(true);
		this.dispose();

	}

}
