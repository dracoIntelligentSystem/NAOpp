package integration;

import javax.swing.ImageIcon;

public class GestureFeature {
	private static ImageIcon gesture=null;
	private static String path="";
	private static String emotionCategory="";
	
//	public FaceFeature() {
//		// TODO Auto-generated constructor stub
//	}
	

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		GestureFeature.path = path;
	}

	public static String getEmotionCategory() {
		return emotionCategory;
	}

	public static void setEmotionCategory(String emotionCategory) {
		GestureFeature.emotionCategory = emotionCategory;
	}


	public static ImageIcon getGesture() {
		return gesture;
	}


	public static void setGesture(ImageIcon gesture) {
		GestureFeature.gesture = gesture;
	}
}
