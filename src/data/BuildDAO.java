package data;

import java.util.List;

public interface BuildDAO {

	

	int count = 0;

	public Deck getDeck();
	
	public List<Deck> getDecksByBrand(String deckBrand);

	public void addDeck(Deck deck);

	public Deck getDeckByName(String deckName);
	
	public List<Deck> ListAllDecks();

	public List<Wheel> getAllWheels();

	public void addWheel(Wheel wheel);

	public List<Wheel> getWheelsByRank(String wheelRank);

	public Wheel getWheelsByBrand(String wheelBrand);

	List<Bearing> getBearingsByRank(String bearingRank);

	List<Bearing> getAllBearings();

	public void addBearing(Bearing bearing);

	public Bearing getBearingsByBrand(String bearingBrand);

	public List<Truck> getTrucksByRank(String truckRank);

	public List<Truck> getAllTrucks();

	public void addTruck(Truck truck);

	public Truck getTrucksByBrand(String truckBrand);

	public Deck getDeckById(int id);

//	List<Deck> getDeckByUrl(String url);
//	
	public Deck getDeckByUrl(String url);

	public void removeDeck(Deck deck);

	public void removeWheel(Wheel wheel);

	public void removeBearing(Bearing bearing);

	public void removeTruck(Truck truck);

	

	

	
	
	

}
