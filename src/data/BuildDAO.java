package data;

import java.util.List;

public interface BuildDAO {

	public List<Deck> getDecksByBrand(String deckBrand);
	public void addDeck(Deck deck);
	public Deck getDeckByName(String deckName);
	public List<Deck> ListAllDecks();
	public Deck getDeckById(int id);
	public Deck getDeckByUrl(String url);
	public void removeDeck(Deck deck);
	public void updateDeck(Deck deck, String deckName);

	public List<Wheel> getAllWheels();
	public void addWheel(Wheel wheel);
	public List<Wheel> getWheelsByRank(String wheelRank);
	public Wheel getWheelsByBrand(String wheelBrand);
	public void removeWheel(Wheel wheel);
	public void updateWheels(Wheel wheel, String wheelBrand);

	public List<Bearing> getBearingsByRank(String bearingRank);
	public List<Bearing> getAllBearings();
	public void addBearing(Bearing bearing);
	public Bearing getBearingsByBrand(String bearingBrand);
	public void removeBearing(Bearing bearing);
	public void updateBearings(Bearing bearing, String bearingBrand);
	
	public List<Truck> getTrucksByRank(String truckRank);
	public List<Truck> getAllTrucks();
	public void addTruck(Truck truck);
	public Truck getTrucksByBrand(String truckBrand);
	public void removeTruck(Truck truck);
	public void updateTrucks(Truck truck, String truckBrand);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	

}
