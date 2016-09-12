package data;

public class Bearing {
	private int id;
	private String bearingRank;
	private String bearingBrand;
	
	
	public Bearing() {
	}

	public Bearing(String bearingRank, String bearingBrand) {
	
		this.bearingRank = bearingRank;
		this.bearingBrand = bearingBrand;
	}

	
	public Bearing(int id, String bearingRank, String bearingBrand) {
		this.id = id;
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

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bearing [id=" + id + ", bearingRank=" + bearingRank + ", bearingBrand=" + bearingBrand + "]";
	}

	
}
