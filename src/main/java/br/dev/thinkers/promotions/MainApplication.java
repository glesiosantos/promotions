package br.dev.thinkers.promotions;

import br.dev.thinkers.promotions.domain.SocialMetaTag;
import br.dev.thinkers.promotions.services.SocialMetaTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	@Autowired
	private SocialMetaTagService socialMetaTagService;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SocialMetaTag tag = socialMetaTagService
				.getSocialMetaTagByUrl("https://www.pichau.com.br/gabinete-gamer-deepcool-cg560-rgb-mid-tower-lateral-de-vidro-com-4-fans-preto-r-cg560-bkaae4-g-1");
		System.out.println("TAG "+ tag.toString());

	}
}
