package br.dev.thinkers.promotions.web;

import br.dev.thinkers.promotions.domain.SocialMetaTag;
import br.dev.thinkers.promotions.services.SocialMetaTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/metas")
public class SocialMetaTagController {

    @Autowired
    private SocialMetaTagService socialMetaTagService;

    @PostMapping("/info")
    public ResponseEntity<SocialMetaTag> getDataByUrl(@RequestParam("url") String url) {
        SocialMetaTag socialMetaTag = socialMetaTagService.getSocialMetaTagByUrl(url);
        return socialMetaTag != null ? ResponseEntity.ok(socialMetaTag) : ResponseEntity.notFound().build();
    }
}
