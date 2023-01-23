package shortener;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

interface UrlRepository extends JpaRepository<Url, Long> {
	Optional<Url> findByShortUrl(String shortUrl);
}
