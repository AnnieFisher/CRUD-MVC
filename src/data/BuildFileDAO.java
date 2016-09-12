package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class BuildFileDAO implements BuildDAO {
	private static final String FILE_NAME_Deck = "/WEB-INF/boards.csv";
	private static final String FILE_NAME_Wheel = "/WEB-INF/wheels.csv";
	private static final String FILE_NAME_Bearing = "/WEB-INF/bearings.csv";
	private static final String FILE_NAME_Truck = "/WEB-INF/trucks.csv";

	private List<Deck> decks = new ArrayList<>();
	private List<Wheel> wheels = new ArrayList<>();
	private List<Bearing> bearings = new ArrayList<>();
	private List<Truck> trucks = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void initDeck() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME_Deck);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				int id = Integer.parseInt(tokens[0]);
				if (tokens[0] == null)
					id = decks.lastIndexOf(ListAllDecks()) + 1;

				String deckBrand = tokens[1];
				String deckName = tokens[2];
				String url = tokens[3];

				decks.add(new Deck(id, deckBrand, deckName, url));

			}
			for (Deck deck : decks) {
				System.out.println(deck);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public List<Deck> getDecksByBrand(String deckBrand) {
		List<Deck> d = new ArrayList<>();
		for (Deck deck : decks) {
			if (deck.getDeckBrand().equalsIgnoreCase(deckBrand)) {
				d.add(deck);
			}
		}
		return d;
	}

	public List<Deck> getDecksByURL(String url) {
		List<Deck> d = new ArrayList<>();
		for (Deck deck : decks) {
			if (deck.getUrl().equalsIgnoreCase(url)) {
				d.add(deck);
			}
		}
		return d;
	}

	@Override
	public Deck getDeckByName(String deckName) {
		Deck d = null;
		for (Deck deck : decks) {
			if (deck.getDeckName().equalsIgnoreCase(deckName)) {
				d = deck;
				break;
			}
		}
		return d;
	}

	@Override
	public List<Deck> ListAllDecks() {
		return decks;
	}

	@Override
	public Deck getDeckById(int id) {
		Deck d = null;
		for (Deck deck : decks) {
			if (deck.getId() == id) {
				d = deck;
				break;
			}
		}
		return d;
	}

	@Override
	public void addDeck(Deck deck) {
		decks.add(deck);

	}

	@Override
	public void removeDeck(Deck deck) {
		decks.remove(deck);
	}

	@PostConstruct
	public void initWheel() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME_Wheel);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String wheelRank = tokens[0];
				String wheelBrand = tokens[1];

				wheels.add(new Wheel(wheelRank, wheelBrand));
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	
	@Override
	public List<Wheel> getWheelsByRank(String wheelRank) {
		List<Wheel> w = new ArrayList<>();
		for (Wheel wheel : wheels) {
			if (wheel.getWheelRank().equalsIgnoreCase(wheelRank)) {
				w.add(wheel);
			}
		}
		return w;
	}

	@Override
	public List<Wheel> getAllWheels() {
		return wheels;
	}

	@Override
	public void addWheel(Wheel wheel) {
		wheels.add(wheel);
	}

	@Override
	public Wheel getWheelsByBrand(String wheelBrand) {
		Wheel w = null;
		for (Wheel wheel : wheels) {
			if (wheel.getWheelBrand().equalsIgnoreCase(wheelBrand)) {
				w = wheel;
				break;
			}
		}
		return w;
	}

	@Override
	public void removeWheel(Wheel wheel) {
		wheels.remove(wheel);

	}

	@PostConstruct
	public void initBearing() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME_Bearing);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String bearingRank = tokens[0];
				String bearingBrand = tokens[1];

				bearings.add(new Bearing(bearingRank, bearingBrand));
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public List<Bearing> getBearingsByRank(String bearingRank) {
		List<Bearing> b = new ArrayList<>();
		for (Bearing bearing : bearings) {
			if (bearing.getBearingRank().equalsIgnoreCase(bearingRank)) {
				b.add(bearing);
			}
		}
		return b;
	}

	@Override
	public List<Bearing> getAllBearings() {
		return bearings;
	}

	@Override
	public void addBearing(Bearing bearing) {
		bearings.add(bearing);
	}

	@Override
	public Bearing getBearingsByBrand(String bearingBrand) {
		Bearing b = null;
		for (Bearing bearing : bearings) {
			if (bearing.getBearingBrand().equalsIgnoreCase(bearingBrand)) {
				b = bearing;
				break;
			}
		}
		return b;
	}

	@Override
	public void removeBearing(Bearing bearing) {
		bearings.remove(bearing);

	}

	@PostConstruct
	public void initTrucks() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME_Truck);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String truckRank = tokens[0];
				String truckBrand = tokens[1];

				trucks.add(new Truck(truckRank, truckBrand));
			}
			for (Truck truck : trucks) {
				System.out.println(truck);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public List<Truck> getTrucksByRank(String truckRank) {
		List<Truck> t = new ArrayList<>();
		for (Truck truck : trucks) {
			if (truck.getTruckRank().equalsIgnoreCase(truckRank)) {
				t.add(truck);
			}
		}
		return t;
	}

	@Override
	public List<Truck> getAllTrucks() {
		return trucks;
	}

	@Override
	public void addTruck(Truck truck) {
		trucks.add(truck);
	}

	@Override
	public Truck getTrucksByBrand(String truckBrand) {
		Truck t = null;
		for (Truck truck : trucks) {
			if (truck.getTruckBrand().equalsIgnoreCase(truckBrand)) {
				t = truck;
				break;
			}
		}
		return t;
	}

	@Override
	public Deck getDeckByUrl(String url) {
		Deck d = null;
		for (Deck deck : decks) {
			if (deck.getDeckName().equalsIgnoreCase(url)) {
				d = deck;
				break;
			}
		}
		return d;
	}

	@Override
	public void removeTruck(Truck truck) {
		trucks.remove(truck);

	}


	
	@Override
	public void updateDeck(Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWheels(Wheel wheel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBearings(Bearing bearing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTrucks(Truck truck) {
		// TODO Auto-generated method stub
		
	}

}
