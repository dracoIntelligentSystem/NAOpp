package business.core;

import java.util.HashMap;
import java.util.Vector;

public class CategorizationEvent {

	private static HashMap<String, Vector<String>> eventEx;
	
	private static void InitializeCategorizationEvent() {
		eventEx = new HashMap<String, Vector<String>>();
		Vector<String> angerList = new Vector<>();
		angerList.add("Bocciato all'esame di Interfacce Intelligenti");
		angerList.add("Ho bruciato il motore della macchina");
		angerList.add("Ho perso il worksapce di eclipse perchè mi si è fritto l'HD");
		angerList.add("Marco mi fa incazzare di Suo!!XD");
		eventEx.put("rabbia", angerList);
		
		Vector<String> sadList = new Vector<>();
		sadList.add("La mia ragazza mi ha lasciato");
		sadList.add("Il dentista mi ha prosciugato il portafogli");
		sadList.add("Ho perso il lavoro");
		sadList.add("Ho perso un acconto");
		eventEx.put("tristezza", sadList);
		
		Vector<String> neutralList = new Vector<>();
		neutralList.add("Ho votato Mattarella");
		neutralList.add("Sono apatico");
		neutralList.add("Ho acceso il PC");
		neutralList.add("PH 7");
		eventEx.put("neutra", neutralList);
		
		Vector<String> happyList = new Vector<>();
		happyList.add("Ho trovato 100 euro per terra");
		happyList.add("Il mio cane ha figliato");
		happyList.add("Ho vinto alla lotteria");
		happyList.add("Ho visto Bianca");
		eventEx.put("felicita", happyList);
	}
	
	public static Vector<String> getSamples(String emoCat){
		if (eventEx == null )
			InitializeCategorizationEvent();
		return eventEx.get(emoCat);
	}
}
