package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuildDbDAO implements BuildDAO {
	private static String url = "jdbc:mysql://localhost:3306/build_a_board";
	private static String user = "board";
	private static String pass = "board";

	private List<Deck> decks = new ArrayList<>();
	private List<Wheel> wheels = new ArrayList<>();
	private List<Bearing> bearings = new ArrayList<>();
	private List<Truck> trucks = new ArrayList<>();

	public BuildDbDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	@Override
	public List<Deck> ListAllDecks() {
		List<Deck> decks = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT iddecks, decks_brand, decks_name, urls FROM decks ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqltxt);
			while (rs.next()) {
				decks.add(new Deck(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return decks;
	}

	@Override
	public List<Deck> getDecksByBrand(String deckBrand) {
		List<Deck> decks = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT iddecks, decks_brand, decks_name, urls FROM decks WHERE decks_brand = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, deckBrand);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Deck deck = new Deck();
				deck.setId(rs.getInt("id"));
				deck.setDeckBrand(rs.getString("deckBrand"));
				deck.setDeckName(rs.getString("deckName"));
				deck.setUrl(rs.getString("url"));

				decks.add(deck);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return decks;
	}

	@Override
	public void addDeck(Deck deck) {

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "INSERT INTO decks (iddecks, decks_brand, decks_name, urls) VALUES(?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);

			stmt.setInt(1, deck.getId());
			stmt.setString(2, deck.getDeckBrand());
			stmt.setString(3, deck.getDeckName());
			stmt.setString(4, deck.getUrl());
			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("DEBUG: Db.addDeck(): Deck added: " + deck);
			} else {
				System.out.println("DEBUG: DB.addDeck() FAIL no deck added");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Deck getDeckByName(String deckName) {
		Deck deck = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT iddecks, decks_brand, decks_name, urls FROM decks WHERE decks_name = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, deckName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				deck = new Deck(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deck;
	}

	@Override
	public Deck getDeckById(int id) {
		Deck deck = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT iddecks, decks_brand, decks_name, urls FROM decks WHERE iddecks = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				deck = new Deck(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deck;
	}

	@Override
	public Deck getDeckByUrl(String url) {
		Deck deck = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT iddecks, decks_brand, decks_name, urls FROM decks WHERE url = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, url);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				deck = new Deck(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deck;
	}

	@Override
	public void updateDeck(Deck deck) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt;
			int deckId = this.getDeckIdByDeckName(deck.getDeckName());
			sqltxt = "UPDATE decks SET iddecks=?, decks_brand = ?, decks_name = ?, url=?  " + " WHERE iddecks = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, deck.getId());
			stmt.setString(2, deck.getDeckBrand());
			stmt.setString(3, deck.getDeckName());
			stmt.setString(4, deck.getUrl());
			stmt.setInt(5, deckId);

			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("Deck updated.");
			} else {
				System.err.println("deck not updated.");
			}
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
	}

	private int getDeckIdByDeckName(String deckName) {
		int id = 0;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt;
			sqltxt = "SELECT iddecks FROM decks WHERE iddecks = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, deckName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
		return id;
	}

	@Override
	public List<Wheel> getAllWheels() {
		List<Wheel> wheels = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT idwheels, wheels_rank, wheels_brand FROM wheels ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqltxt);
			while (rs.next()) {
				wheels.add(new Wheel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wheels;
	}

	@Override
	public void addWheel(Wheel wheel) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "INSERT INTO wheels (idwheels, wheels_rank, wheels_brand) VALUES(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);

			stmt.setInt(1, wheel.getId());
			stmt.setString(2, wheel.getWheelRank());
			stmt.setString(3, wheel.getWheelBrand());
			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("DEBUG: DB.addWheel(): added" + wheel);
			} else {
				System.out.println("DEBUG: DB.addWheel() FAIL: No wheel added");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Wheel> getWheelsByRank(String wheelRank) {
		List<Wheel> wheels = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT idwheels, wheels_rank, wheels_brand FROM wheels WHERE wheels_rank = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, wheelRank);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Wheel wheel = new Wheel();
				wheel.setId(rs.getInt("id"));
				wheel.setWheelRank(rs.getString("wheelRank"));
				wheel.setWheelBrand(rs.getString("wheelBrand"));

				wheels.add(wheel);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wheels;
	}

	@Override
	public Wheel getWheelsByBrand(String wheelBrand) {
		Wheel wheel = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT idwheels, wheels_rank, wheels_Brand FROM wheels WHERE wheels_brand = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, wheelBrand);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				wheel = new Wheel(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wheel;
	}

	@Override
	public void updateWheels(Wheel wheel) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt;
			int wheelId = this.getWheelIdByWheelBrand(wheel.getWheelBrand());
			sqltxt = "UPDATE wheels SET idwheels=?, wheels_rank = ?, wheels_brand = ?  " + " WHERE idwheels = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, wheel.getId());
			stmt.setString(2, wheel.getWheelRank());
			stmt.setString(3, wheel.getWheelBrand());
			stmt.setInt(4, wheelId);

			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("Wheel updated.");
			} else {
				System.err.println("wheel not updated.");
			}
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
	}

	private int getWheelIdByWheelBrand(String wheelBrand) {
		int id = 0;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt;
			sqltxt = "SELECT idwheels FROM wheels WHERE idwheels = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, wheelBrand);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
		return id;
	}

	@Override
	public List<Bearing> getBearingsByRank(String bearingRank) {
		List<Bearing> bearings = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT idbearings, bearings_rank, bearings_brand FROM bearings WHERE bearings_rank = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, bearingRank);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Bearing bearing = new Bearing();
				bearing.setId(rs.getInt("id"));
				bearing.setBearingRank(rs.getString("bearingRank"));
				bearing.setBearingBrand(rs.getString("bearingBrand"));

				bearings.add(bearing);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bearings;
	}

	@Override
	public List<Bearing> getAllBearings() {
		List<Bearing> bearings = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT idbearings, bearings_rank, bearings_brand FROM bearings ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqltxt);
			while (rs.next()) {
				bearings.add(new Bearing(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bearings;
	}

	@Override
	public void addBearing(Bearing bearing) {

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "INSERT INTO bearings (idbearings, bearings_rank, bearings_brand) VALUES(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);

			stmt.setInt(1, bearing.getId());
			stmt.setString(2, bearing.getBearingRank());
			stmt.setString(3, bearing.getBearingBrand());
			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("DEBUG: DB.addBearing(): added" + bearing);
			} else {
				System.out.println("DEBUG: DB.addBearing() FAIL: No bearing added");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Bearing getBearingsByBrand(String bearingBrand) {
		Bearing bearing = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT idbearings, bearings_rank, bearings_Brand FROM bearings WHERE bearings_brand = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, bearingBrand);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				bearing = new Bearing(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bearing;
	}

	@Override
	public void updateBearings(Bearing bearing) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt;
			int bearingId = this.getBearingIdByBearingBrand(bearing.getBearingBrand());
			sqltxt = "UPDATE bearings SET idbearings=?, bearings_rank = ?, bearings_brand = ?  "
					+ " WHERE idwheels = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, bearing.getId());
			stmt.setString(2, bearing.getBearingRank());
			stmt.setString(3, bearing.getBearingBrand());
			stmt.setInt(4, bearingId);

			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("Bearing updated.");
			} else {
				System.err.println("bearing not updated.");
			}
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
	}

	private int getBearingIdByBearingBrand(String bearingBrand) {
		int id = 0;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt;
			sqltxt = "SELECT idbearings FROM bearings WHERE idbearings = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, bearingBrand);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
		return id;
	}

	@Override
	public List<Truck> getTrucksByRank(String truckRank) {
		List<Truck> trucks = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT idtrucks, trucks_rank, trucks_brand FROM trucks WHERE trucks_rank = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, truckRank);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Truck truck = new Truck();
				truck.setId(rs.getInt("id"));
				truck.setTruckRank(rs.getString("truckRank"));
				truck.setTruckBrand(rs.getString("truckBrand"));

				trucks.add(truck);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trucks;
	}

	@Override
	public List<Truck> getAllTrucks() {
		List<Truck> trucks = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT idtrucks, trucks_rank, trucks_brand FROM trucks ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqltxt);
			while (rs.next()) {
				trucks.add(new Truck(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trucks;

	}

	@Override
	public void addTruck(Truck truck) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "INSERT INTO trucks(idtrucks, trucks_rank, trucks_brand) VALUES(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);

			stmt.setInt(1, truck.getId());
			stmt.setString(2, truck.getTruckRank());
			stmt.setString(3, truck.getTruckBrand());

			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("DEBUG: DB.addBearing(): added" + truck);
			} else {
				System.out.println("DEBUG: DB.addBearing() FAIL: No bearing added");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Truck getTrucksByBrand(String truckBrand) {
		Truck truck = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "SELECT idtrucks, trucks_rank, trucks_Brand FROM trucks WHERE trucks_brand = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, truckBrand);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				truck = new Truck(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return truck;
	}
	
	@Override
	public void updateTrucks(Truck truck) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt;
			int truckId = this.getTruckIdByTruckBrand(truck.getTruckBrand());
			sqltxt = "UPDATE trucks SET idtrucks=? , trucks_brand = ?  "
					+ " WHERE idtrucks = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, truck.getId());
			stmt.setString(2, truck.getTruckBrand());
			stmt.setInt(3, truckId);

			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("Truck updated.");
			} else {
				System.err.println("truck not updated.");
			}
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
	}

	private int getTruckIdByTruckBrand(String truckBrand) {
		int id = 0;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt;
			sqltxt = "SELECT idtrucks FROM trucks WHERE idtrucks = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, truckBrand);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
		return id;
	}

	@Override
	public void removeDeck(Deck deck) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			String sqltxt = "DELETE FROM decks WHERE decks_brand = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);

			stmt.setString(1, deck.getDeckBrand());

			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("DEBUG: Db.removeDeck(): Deck removed: " + deck);
			} else {
				System.out.println("DEBUG: DB.removeDeck() FAIL ");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeWheel(Wheel wheel) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "DELETE FROM wheels WHERE wheels_brand = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);

			stmt.setString(1, wheel.getWheelBrand());
			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("DEBUG: DB.removeWheel(): removed " + wheel);
			} else {
				System.out.println("DEBUG: DB.removeWheel():FAIL");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeBearing(Bearing bearing) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "DELETE FROM bearings WHERE bearings_brand = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);

			stmt.setString(1, bearing.getBearingBrand());

			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("DEBUG: DB.removeBearing(): removed" + bearing);
			} else {
				System.out.println("DEBUG: DB.removeBearing() FAIL: ");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeTruck(Truck truck) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sqltxt = "DELETE FROM trucks  WHERE trucks_brand = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);

			stmt.setString(1, truck.getTruckBrand());

			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("DEBUG: DB.removeTruck(): removed" + truck);
			} else {
				System.out.println("DEBUG: DB.removeTruck() FAIL:");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
