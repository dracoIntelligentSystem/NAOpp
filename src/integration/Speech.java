package integration;

public class Speech {

	private String Arousal="";
	private String Valence="";
	public Speech() {
		// TODO Auto-generated constructor stub
	}
	public Speech(String ar, String val) {
		this.setArousal(ar);
		this.setValence(val);
	}
	public String getArousal() {
		return Arousal;
	}
	public void setArousal(String arousal) {
		Arousal = arousal;
	}
	public String getValence() {
		return Valence;
	}
	public void setValence(String valence) {
		Valence = valence;
	}
	
	
}
