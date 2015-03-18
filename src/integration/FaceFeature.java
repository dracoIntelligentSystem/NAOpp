package integration;

import javax.swing.ImageIcon;

public class FaceFeature {

	private static ImageIcon choisedFaceExpr=null;
	private static String path="";
	private static String emotionCategory="";
	
//	public FaceFeature() {
//		// TODO Auto-generated constructor stub
//	}
	

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		FaceFeature.path = path;
	}

	public static String getEmotionCategory() {
		return emotionCategory;
	}

	public static void setEmotionCategory(String emotionCategory) {
		FaceFeature.emotionCategory = emotionCategory;
	}


	public static ImageIcon getFace() {
		return choisedFaceExpr;
	}


	public static void setFace(ImageIcon choisedFaceExpr) {
		FaceFeature.choisedFaceExpr = choisedFaceExpr;
	}

}
