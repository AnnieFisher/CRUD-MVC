package data;

public class Wheel {
	private int id;
	private String wheelRank;
	private String wheelBrand;
	
	public Wheel(){	
	}
	
	public Wheel(String wheelRank, String wheelBrand) {
	
		this.wheelRank = wheelRank;
		this.wheelBrand = wheelBrand;
	}
	
	public Wheel(int id, String wheelRank, String wheelBrand) {
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Wheel [id=" + id + ", wheelRank=" + wheelRank + ", wheelBrand=" + wheelBrand + "]";
	}
	
}
