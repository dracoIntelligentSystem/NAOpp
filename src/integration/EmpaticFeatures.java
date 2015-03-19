package integration;

import java.io.File;

import javax.swing.ImageIcon;


public  class EmpaticFeatures {

	private FaceFeature face = null;
	private AudioFeature audio = null;
	private ActionFeature action = null;
	private GestureFeature gesture = null;
	
	
	public void setFaceFeature(ImageIcon faceImage, String path, String emotionCategory) {
		face = new FaceFeature();
		face.setFace(faceImage);
		face.setPath(path);
		face.setEmotionCategory(emotionCategory);
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

	public void cleanFace() {
		face = null;
	}

	public void cleanAudio() {
		audio=null;		
	}

	public void cleanAction() {
		action=null;		
	}

	public void cleaGesture() {
		gesture=null;		
	}
	
	
}
