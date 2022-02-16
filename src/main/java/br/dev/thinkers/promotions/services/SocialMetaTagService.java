package br.dev.thinkers.promotions.services;

import br.dev.thinkers.promotions.domain.SocialMetaTag;

public interface SocialMetaTagService {

    SocialMetaTag getSocialMetaTagByUrl(String url);

    SocialMetaTag getOpenGraphByUrl(String url);

    SocialMetaTag getTwitterCardByUrl(String url);

}
