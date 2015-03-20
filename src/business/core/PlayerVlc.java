package business.core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;


public class PlayerVlc extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmbeddedMediaPlayerComponent ourMediaPlayer;
	public PlayerVlc(){
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Programmi\\VideoLAN\\VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

		ourMediaPlayer = new EmbeddedMediaPlayerComponent();
		


		/* Set the canvas */
		Canvas c = new Canvas();
		c.setBackground(Color.yellow);
		c.setVisible(false);

		/* Set the layout */
		this.setLayout(new BorderLayout());

		/* Add the canvas */
		this.add(ourMediaPlayer);
		//this.add(c, BorderLayout.CENTER);
		this.setVisible(true);



	}
	public void play(String path) {
		/* Play the video */
		ourMediaPlayer.getMediaPlayer().playMedia(path);

	}
	
	public static String duration(File file) throws UnsupportedAudioFileException, IOException{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		AudioFormat format = audioInputStream.getFormat();
		long frames = audioInputStream.getFrameLength();
		double durationInSeconds = (frames+0.0) / format.getFrameRate();  
		return String.valueOf(durationInSeconds);
	}
}