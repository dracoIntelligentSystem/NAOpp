package business.core;
//operation=upload&facial_expression=sad&audio_valence=low&audio_areasual=hight&event=happy
import integration.EmpaticFeatures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NAORequest {
	private final static String address_url = "http://bdii.cloudapp.net/NAO_services/Emotions?";
	private static String parameter;
	private static String operation="upload";

	public static void send2NAO(EmpaticFeatures emotion) {
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

	private static String buildParameterString(EmpaticFeatures emotion) {
		return parameter = "operation="+operation + "&"+
					"facial_expression="+emotion.getFace().getEmotionCategory() + "&"+
					"audio_valence=low"+ emotion.getAudio().getValence() + "&"+
					"audio_arousal=high"+ emotion.getAudio().getArousal() + "&"+
					"event=happy";// + emotion.getAction().getEmotionCategory();
				
		 
	}

}
