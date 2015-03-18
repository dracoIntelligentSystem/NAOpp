package integration;

import javax.swing.ImageIcon;

public class FaceFeature {

	private ImageIcon choisedFaceExpr=null;
	private String path="";
	private String emotionCategory="";
	
//	public FaceFeature() {
//		// TODO Auto-generated constructor stub
//	}
	

	public  String getPath() {
		return path;
	}

	public  void setPath(String path) {
		this.path = path;
	}

	public  String getEmotionCategory() {
		return emotionCategory;
	}

	public  void setEmotionCategory(String emotionCategory) {
		this.emotionCategory = emotionCategory;
	}


	public  ImageIcon getFace() {
		return choisedFaceExpr;
	}


	public  void setFace(ImageIcon choisedFaceExpr) {
		this.choisedFaceExpr = choisedFaceExpr;
	}

}
