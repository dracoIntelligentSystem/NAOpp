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

//	public static void setAudioFeature(File audio, String path, String emotionCategory){
//		features.setAudioFeature(audio, path, emotionCategory);
//	}
	
//TEST	
	public static void setAudioFeature(File audio, String path, String emotionCategory, String arousal, String valence){
		features.setAudioFeature(audio, path, emotionCategory, arousal, valence);
	}

	public static void setEventFeature(String event, String emotionCategory){
		features.setEventFeature(event, emotionCategory);
	}

	public static void setGestureFeature(ImageIcon gestureImage, String path, String emotionCategory){
		features.setGestureFeature(gestureImage, path, emotionCategory);
	}	
	
	public static EmpaticFeatures getEmotion(){
		return features;
	}
	
	public static void cleanFaceFeature(){
		features.cleanFace();
	}
	
	public static void cleanAudioFeature(){
		features.cleanAudio();
	}

	public static void cleanEventFeature(){
		features.cleanEvent();
	}

	public static void cleanGestureFeature(){
		features.cleanGesture();
	}
	
	public static void cleanEmotion(){
		if(features!=null){
			cleanEventFeature();
			cleanAudioFeature();
			cleanFaceFeature();
			cleanGestureFeature();
			features=null;
		}
	}
	
}
