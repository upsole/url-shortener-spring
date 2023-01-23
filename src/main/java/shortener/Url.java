package shortener;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
class Url {
	private @Id @GeneratedValue Long id;
	private @GeneratedValue String shortUrl;
	private String original;

	// the no params constructor will be called by the post route
	Url () {
		this.shortUrl = randomString.generateString(5);
	}
	Url(String original) {
		this.original = original;
		this.shortUrl = randomString.generateString(5);
	}
	public Long getId() {
		return this.id;
	}
	public String getOriginal() {
		return this.original;
	}
	public String getShortUrl() {
		return this.shortUrl;
	}
	public void setOriginal(String original) {
		this.original = original;
	}

	public void setShortUrl() {
		System.out.println("setter called");
		this.shortUrl = randomString.generateString(5);
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.original, this.shortUrl);
	}
	@Override
	public String toString() {
		return "Url Pair: " + this.original + " | " + this.shortUrl;
	}
}

