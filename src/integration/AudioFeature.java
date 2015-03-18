package integration;

import java.io.File;

public class AudioFeature {
	private static File audio=null;
	private static String path=null;
	private static String emotionCategory=null;
	
//	public AudioFeature() {
//		// TODO Auto-generated constructor stub
//	}
	

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		AudioFeature.path = path;
	}

	public static String getEmotionCategory() {
		return emotionCategory;
	}

	public static void setEmotionCategory(String emotionCategory) {
		AudioFeature.emotionCategory = emotionCategory;
	}


	public static File getAudio() {
		return audio;
	}


	public static void setAudio(File audio) {
		AudioFeature.audio = audio;
	}


}
