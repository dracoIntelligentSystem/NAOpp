package integration;

import java.io.File;

public class AudioFeature {
	private File audio=null;
	private String path=null;
	private String emotionCategory=null;
	private static String Arousal = "";
	private static String Valence = "";
//	public AudioFeature() {
//		// TODO Auto-generated constructor stub
//	}
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getEmotionCategory() {
		return emotionCategory;
	}

	public void setEmotionCategory(String emotionCategory) {
		this.emotionCategory = emotionCategory;
	}


	public File getAudio() {
		return audio;
	}


	public void setAudio(File audio) {
		this.audio = audio;
	}

	public String getArousal() {
		return Arousal;
	}

	public void setArousal(String arousal) {
		Arousal = arousal;
	}

	public String getValence() {
		return Valence;
	}

	public void setValence(String valence) {
		Valence = valence;
	}


}
