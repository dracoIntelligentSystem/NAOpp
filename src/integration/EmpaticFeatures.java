package integration;

import java.io.File;

import javax.swing.ImageIcon;


public  class EmpaticFeatures {

//	private FaceFeature face;
//	private AudioFeature audio;
//	private ActionFeature action;
//	private GestureFeature gesture;
	
	
	public void setFaceFeature(ImageIcon faceImage, String path, String emotionCategory) {
		FaceFeature.setFace(faceImage);
		FaceFeature.setPath(path);
		FaceFeature.setEmotionCategory(emotionCategory);
	}


	public void setAudioFeature(File audio2, String path, String emotionCategory) {
		// TODO Auto-generated method stub
		
	}


	public void setActionFeature(ImageIcon actionImage, String path,
			String emotionCategory) {
		// TODO Auto-generated method stub
		
	}


	public void setGestureFeature(ImageIcon gestureImage, String path,
			String emotionCategory) {
		// TODO Auto-generated method stub
		
	}
	
	
}
