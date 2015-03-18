package presentation;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton conNAO;
	private JButton conEmpatic;
	private JPanel Principal = new JPanel(new GridLayout(2,1));
	private static boolean Connection = false;

	public StartFrame() {
		this.setTitle("NAOpp");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ImageIcon icon = new ImageIcon("C:\\Users\\dragoSI\\Downloads\\eclipse\\workspace\\NAOpp\\src\\integration\\nao-icon.jpg");
		ImageIcon icon = new ImageIcon("src\\integration\\icon\\nao-icon.jpg");
		conNAO = new JButton("NAO CONNECTION", icon );
		conEmpatic = new JButton("NAO EMPATIC", new ImageIcon("src\\integration\\icon\\empathy-3.png"));
		
		conNAO.addActionListener(this);
		conEmpatic.addActionListener(this);
		
		Principal.add(conNAO);
		Principal.add(conEmpatic);
		this.getContentPane().add(Principal);
		this.pack();this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		if(e.getSource() == conNAO)
		{
			ConNAO connessioneBot = new ConNAO(this);
		}
		else if (e.getSource() == conEmpatic){
			EmpaticNAO empatic = new EmpaticNAO(this); 
		}
	}

	public static boolean isConnected() {
		return Connection;
	}

	public static void setConnection(boolean connection) {
		Connection = connection;
	}

}
