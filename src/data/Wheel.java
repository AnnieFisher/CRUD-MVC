package data;

public class Wheel {
	private String wheelRank;
	private String wheelBrand;
	
	public Wheel(){	
	}

	public Wheel(String wheelRank, String wheelBrand) {
		this.wheelRank = wheelRank;
		this.wheelBrand = wheelBrand;
	}

	public String getWheelRank() {
		return wheelRank;
	}

	public void setWheelRank(String wheelRank) {
		this.wheelRank = wheelRank;
	}

	public String getWheelBrand() {
		return wheelBrand;
	}

	public void setWheelBrand(String wheelBrand) {
		this.wheelBrand = wheelBrand;
	}

	@Override
	public String toString() {
		return "Wheel [wheelRank=" + wheelRank + ", wheelBrand=" + wheelBrand + "]";
	}
	
}
