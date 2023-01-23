package shortener;

class UrlNotFoundException extends RuntimeException {
	UrlNotFoundException(String url) {
		super("URL not found!" + url);
	}
}
