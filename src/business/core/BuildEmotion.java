package business.core;

import integration.EmpaticFeatures;

import java.io.File;

import javax.swing.ImageIcon;

public class BuildEmotion {

	private static EmpaticFeatures features = new EmpaticFeatures();

	//	public BuildEmotion() {
	//		
	//	}

	public static void setFaceFeature(ImageIcon faceImage, String path, String emotionCategory){
		features.setFaceFeature(faceImage, path, emotionCategory);
	}

	public static void setAudioFeature(File audio, String path, String emotionCategory){
		features.setAudioFeature(audio, path, emotionCategory);
	}

	public static void setActionFeature(ImageIcon actionImage, String path, String emotionCategory){
		features.setActionFeature(actionImage, path, emotionCategory);
	}

	public static void setGestureFeature(ImageIcon gestureImage, String path, String emotionCategory){
		features.setGestureFeature(gestureImage, path, emotionCategory);
	}	
	
	public static EmpaticFeatures getEmotion(){
		return features;
	}

}
