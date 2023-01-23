package shortener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PopulateDatabase {
	private static final Logger log = LoggerFactory.getLogger(PopulateDatabase.class);

	@Bean
	CommandLineRunner initDatabase(UrlRepository repository) {
		return args -> {
			log.info("Preloading", repository.save(new Url("https://google.com")));
			log.info("Preloading", repository.save(new Url("https://lobste.rs")));
		};
	}
}
