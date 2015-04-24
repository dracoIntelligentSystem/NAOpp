package business.core;
//operation=upload&facial_expression=sad&audio_valence=low&audio_areasual=hight&event=happy
import integration.EmpaticFeatures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class NAORequest {
	private final static String address_url = "http://bdii.cloudapp.net/NAO_services/Emotions?";
	private static String operation="upload";
	private static HashMap<String, String> emoAssociation = new HashMap<String, String>();
	public static void send2NAO(EmpaticFeatures emotion) {
		InitializeHashMap();
		String request = address_url+ buildParameterString(emotion);
		try {
			URL url = new URL(request);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private static void InitializeHashMap() {
		emoAssociation.put("rabbia", "anger");
		emoAssociation.put("felicita", "happy");
		emoAssociation.put("tristezza", "sad");
		emoAssociation.put("neutra", "neutral");
	}

	private static String buildParameterString(EmpaticFeatures emotion) {
		
		String separator="&";
		String query="operation="+operation + separator;
		
		query=query+"facial_expression=";
		try{
			query=query+emoAssociation.get(emotion.getFace().getEmotionCategory())+separator;
		} catch (NullPointerException e){
			query=query+"null"+separator;
		}
		
		query=query+"audio_valence=";
		try{
			query=query+emotion.getAudio().getValence()+separator;
		}catch (NullPointerException e){
			query=query+"null"+separator;
		}
		
		query=query+"audio_arousal=";
		try{
			query=query+emotion.getAudio().getArousal()+separator;
		}catch (NullPointerException e){
			query=query+"null"+separator;
		}
		
		query=query+"event=";
		try{
			query=query+ emoAssociation.get(emotion.getEvent().getEmotionCategory());
		}catch (NullPointerException e){
			query=query+"null";
		}
		return query;
//		return "operation="+operation + "&"+
//					"facial_expression="+ emoAssociation.get(emotion.getFace().getEmotionCategory()) + "&"+
//					"audio_valence="+ emotion.getAudio().getValence() + "&"+
//					"audio_arousal="+ emotion.getAudio().getArousal() + "&"+
//					"event="+ emoAssociation.get(emotion.getEvent().getEmotionCategory());// + emoAssociation.get(emotion.getAction().getEmotionCategory());						 
	}

}
