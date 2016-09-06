package data;

public class Truck {
	private String truckRank;
	private String truckBrand;
	
	public Truck() {
	}

	public Truck(String truckRank, String truckBrand) {
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

	@Override
	public String toString() {
		return "Truck [truckRank=" + truckRank + ", truckBrand=" + truckBrand + "]";
	}
	
}
