package data;

public class BoardSetup {

	private int SetupId;
	private String deckSetup;
	private String wheelSetup;
	private String bearingSetup;
	private String trucksSetup;
	
	public BoardSetup(){}
	
	public BoardSetup(int setupId, String deckSetup, String wheelSetup, String bearingSetup, String trucksSetup) {
		SetupId = setupId;
		this.deckSetup = deckSetup;
		this.wheelSetup = wheelSetup;
		this.bearingSetup = bearingSetup;
		this.trucksSetup = trucksSetup;
	}

	public int getSetupId() {
		return SetupId;
	}

	public void setSetupId(int setupId) {
		SetupId = setupId;
	}

	public String getDeckSetup() {
		return deckSetup;
	}

	public void setDeckSetup(String deckSetup) {
		this.deckSetup = deckSetup;
	}

	public String getWheelSetup() {
		return wheelSetup;
	}

	public void setWheelSetup(String wheelSetup) {
		this.wheelSetup = wheelSetup;
	}

	public String getBearingSetup() {
		return bearingSetup;
	}

	public void setBearingSetup(String bearingSetup) {
		this.bearingSetup = bearingSetup;
	}

	public String getTrucksSetup() {
		return trucksSetup;
	}

	public void setTrucksSetup(String trucksSetup) {
		this.trucksSetup = trucksSetup;
	}

	@Override
	public String toString() {
		return "BoardSetup [SetupId=" + SetupId + ", deckSetup=" + deckSetup + ", wheelSetup=" + wheelSetup
				+ ", bearingSetup=" + bearingSetup + ", trucksSetup=" + trucksSetup + "]";
	}
	
	
	
	

}
