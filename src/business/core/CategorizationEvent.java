package business.core;

import java.util.HashMap;
import java.util.Vector;

public class CategorizationEvent {

	private static HashMap<String, Vector<String>> eventEx;
	
	private static void InitializeCategorizationEvent() {
		eventEx = new HashMap<String, Vector<String>>();
		Vector<String> angerList = new Vector<>();
		angerList.add("Failed exam of Intelligent Interfaces");
		angerList.add("I burned the car engine");
		angerList.add("I've lost my eclipse workspace beacuse my HD burnt");
		angerList.add("Marco pisses me off, regardless !!XD");
		eventEx.put("rabbia", angerList);
		
		Vector<String> sadList = new Vector<>();
		sadList.add("My girlfriend left me");
		sadList.add("The dentist I emptied my wallet");
		sadList.add("I lost my job");
		sadList.add("I lost the deposit of catering");
		eventEx.put("tristezza", sadList);
		
		Vector<String> neutralList = new Vector<>();
		neutralList.add("I voted for Mattarella");
		neutralList.add("I'm apathetic");
		neutralList.add("I turned on the PC");
		neutralList.add("PH 7");
		eventEx.put("neutra", neutralList);
		
		Vector<String> happyList = new Vector<>();
		happyList.add("I found 100 euro in the street");
		happyList.add("My dog has kidded");
		happyList.add("Sasha Grey is coming in my lab");
		happyList.add("Ho visto Bianca!! I can't translate this!!");
		eventEx.put("felicita", happyList);
	}
	
	public static Vector<String> getSamples(String emoCat){
		if (eventEx == null )
			InitializeCategorizationEvent();
		return eventEx.get(emoCat);
	}
}
