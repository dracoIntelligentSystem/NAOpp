package integration;

import java.io.File;

import javax.swing.ImageIcon;


public  class EmpaticFeatures {

	private FaceFeature face = null;
	private AudioFeature audio = null;
	private EventFeature event = null;
	private GestureFeature gesture = null;
	
	
	public void setFaceFeature(ImageIcon faceImage, String path, String emotionCategory) {
		face = new FaceFeature();
		face.setFace(faceImage);
		face.setPath(path);
		face.setEmotionCategory(emotionCategory);
	}


	public void setAudioFeature(File audio2, String path, String emotionCategory) {
		audio = new AudioFeature();
		audio.setAudio(audio2);
		audio.setPath(path);
		audio.setEmotionCategory(emotionCategory);
	}
	
	public void setAudioFeature(File audio2, String path, String emotionCategory, String arousal, String valence) {
		audio = new AudioFeature();
		audio.setAudio(audio2);
		audio.setPath(path);
		audio.setEmotionCategory(emotionCategory);
		audio.setArousal(arousal);
		audio.setValence(valence);
	}


	public void setEventFeature(String eventString, String emotionCategory) {
		event = new EventFeature();
		event.setEvent(eventString);
		event.setEmotionCategory(emotionCategory);
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

	public void cleanEvent() {
		event=null;		
	}

	public void cleanGesture() {
		gesture=null;		
	}


	public FaceFeature getFace(){
		return face;
	}
	public AudioFeature getAudio(){
		return audio;
	}
	public EventFeature getEvent(){
		return event;
	}
	public GestureFeature getGesture(){
		return gesture;
	}

}
