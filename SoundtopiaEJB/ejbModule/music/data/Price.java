package music.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the price database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(
		name="price.findBySongIDAndProvider",
		query="SELECT p FROM Price p WHERE p.song.id = :songID AND p.provider LIKE :provider"),
@NamedQuery(
		name="price.findBySongID",
		query="SELECT p FROM Price p WHERE p.song.id = :songID")
})

/*@NamedQuery(
		name="price.findBySongIDAndProvider",
		query="SELECT p FROM Price p WHERE p.song = :song AND p.provider LIKE :provider")*/
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int id;

	private String offerUrl;

	private String provider;

	private float value;
	
	private String currency;

	//bi-directional many-to-one association to Song
    @ManyToOne
	@JoinColumn(name="songID")
	private Song song;
    
    public Price() {
    }
    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getOfferUrl() {
		return this.offerUrl;
	}

	public void setOfferUrl(String offerUrl) {
		this.offerUrl = offerUrl;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

		
}