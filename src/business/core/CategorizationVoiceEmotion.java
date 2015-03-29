package business.core;

import integration.Speech;

import java.util.ArrayList;
import java.util.HashMap;

public class CategorizationVoiceEmotion {

	private static HashMap<String, ArrayList<Speech>> speechParam = new HashMap<String, ArrayList<Speech>>();
	
	public CategorizationVoiceEmotion() {
		Speech anger = new Speech("medium", "veryneg");
		Speech anger1 = new Speech("high", "veryneg");
		Speech anger2 = new Speech("medium", "negative");
		Speech anger3 = new Speech("high", "negative");
		ArrayList<Speech> angerList = new ArrayList<Speech>();
		angerList.add(anger);
		angerList.add(anger1);
		angerList.add(anger2);
		angerList.add(anger3);
		
		Speech sad = new Speech("low", "veryneg");
		Speech sad1 = new Speech("low", "negative");
		ArrayList<Speech> sadList = new ArrayList<Speech>();
		sadList.add(sad);
		sadList.add(sad1);
		
		Speech neutral = new Speech("low", "neutral");
		Speech neutral1 = new Speech("medium", "neutral");
		Speech neutral2 = new Speech("high", "neutral");
		ArrayList<Speech> neutralList = new ArrayList<Speech>();
		neutralList.add(neutral);
		neutralList.add(neutral1);
		neutralList.add(neutral2);
		
		Speech happy = new Speech("low", "positie");
		Speech happy1 = new Speech("medium", "positie");
		Speech happy2 = new Speech("high", "positie");
		ArrayList<Speech> happylist = new ArrayList<Speech>();
		happylist.add(happy);
		happylist.add(happy1);
		happylist.add(happy2);
		
		speechParam.put("rabbia", angerList);
		speechParam.put("tristezza", sadList);
		speechParam.put("felicita", happylist);
		speechParam.put("neutra", neutralList);
	}
	
	public static Speech getRandomSpeech(String Emotion){
		//index numero random tra 0 e la lunghezza
		int randomItem = (int)Math.random()*speechParam.get(Emotion).size();
		return speechParam.get(Emotion).get(randomItem);
	}
	
}
