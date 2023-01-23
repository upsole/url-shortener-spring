package shortener;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
class UrlController {
	private final UrlRepository repository;

	UrlController(UrlRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/ok")
	List<Url> all() {
		return repository.findAll();
	}

	// TODO BASE URL
	@ResponseBody
	@PostMapping("/short")
	String newUrl(@RequestBody Url newUrl) {
		return "/short/" + repository.save(newUrl).getShortUrl();
	}

	@GetMapping("/short/{url}")
	RedirectView redirect(@PathVariable String url) {
		Url target = repository.findByShortUrl(url).orElseThrow(() -> new UrlNotFoundException(url));
		return new RedirectView(target.getOriginal());
	}
}
