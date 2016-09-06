package data;

public class Bearing {

	private String bearingRank;
	private String bearingBrand;
	
	
	public Bearing() {
	}


	public Bearing(String bearingRank, String bearingBrand) {
		this.bearingRank = bearingRank;
		this.bearingBrand = bearingBrand;
	}


	public String getBearingRank() {
		return bearingRank;
	}


	public void setBearingRank(String bearingRank) {
		this.bearingRank = bearingRank;
	}


	public String getBearingBrand() {
		return bearingBrand;
	}


	public void setBearingBrand(String bearingBrand) {
		this.bearingBrand = bearingBrand;
	}


	@Override
	public String toString() {
		return "Bearing [bearingRank=" + bearingRank + ", bearingBrand=" + bearingBrand + "]";
	}
	
	
	
}
