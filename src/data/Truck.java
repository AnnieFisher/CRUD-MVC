package data;

public class Truck {
	private int id;
	private String truckRank;
	private String truckBrand;
	
	public Truck() {
	}

	public Truck(String truckRank, String truckBrand) {
	
		this.truckRank = truckRank;
		this.truckBrand = truckBrand;
	}
	
	public Truck(int id, String truckRank, String truckBrand) {
		this.id = id;
		this.truckRank = truckRank;
		this.truckBrand = truckBrand;
	}

	public String getTruckRank() {
		return truckRank;
	}

	public void setTruckRank(String truckRank) {
		this.truckRank = truckRank;
	}

	public String getTruckBrand() {
		return truckBrand;
	}

	public void setTruckBrand(String truckBrand) {
		this.truckBrand = truckBrand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Truck [id=" + id + ", truckRank=" + truckRank + ", truckBrand=" + truckBrand + "]";
	}

}
