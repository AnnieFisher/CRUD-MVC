package data;

public class Deck {
	private int id;
	private String deckBrand;
	private String deckName;

	private String url;

	public Deck() {
	}

	public Deck(int id, String deckBrand, String deckName, String url) {
		this.id = id;
		this.deckBrand = deckBrand;
		this.deckName = deckName;
		this.url = url;
	}

	public String getDeckBrand() {
		return deckBrand;
	}

	public void setDeckBrand(String deckBrand) {
		this.deckBrand = deckBrand;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Deck [id=" + id + ", deckBrand=" + deckBrand + ", deckName=" + deckName + ", url=" + url + "]";
	}

	

}
