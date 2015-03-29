package integration;


public class EventFeature {

	private static String event="";
	private static String emotionCategory="";
	
	
//	public FaceFeature() {
//		// TODO Auto-generated constructor stub
//	}
	

	public static String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		EventFeature.event = event;
	}

	public String getEmotionCategory() {
		return emotionCategory;
	}

	public void setEmotionCategory(String emotionCategory) {
		EventFeature.emotionCategory = emotionCategory;
	}
}
