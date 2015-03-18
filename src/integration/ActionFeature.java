package integration;

import javax.swing.ImageIcon;

public class ActionFeature {
	private static ImageIcon action=null;
	private static String path="";
	private static String emotionCategory="";
	
//	public FaceFeature() {
//		// TODO Auto-generated constructor stub
//	}
	

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		ActionFeature.path = path;
	}

	public static String getEmotionCategory() {
		return emotionCategory;
	}

	public static void setEmotionCategory(String emotionCategory) {
		ActionFeature.emotionCategory = emotionCategory;
	}


	public static ImageIcon getAction() {
		return action;
	}


	public static void setAction(ImageIcon action) {
		ActionFeature.action = action;
	}
}
