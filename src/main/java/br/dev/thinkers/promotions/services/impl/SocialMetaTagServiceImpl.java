package br.dev.thinkers.promotions.services.impl;

import br.dev.thinkers.promotions.domain.SocialMetaTag;
import br.dev.thinkers.promotions.services.SocialMetaTagService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@Service
public class SocialMetaTagServiceImpl implements SocialMetaTagService {

    @Override
    public SocialMetaTag getSocialMetaTagByUrl(String url) {
        SocialMetaTag twitter = getTwitterCardByUrl(url);

        if(isNotEmpty(twitter)) {
            return twitter;
        }

        SocialMetaTag openGraph = getOpenGraphByUrl(url);
        if(isNotEmpty(openGraph)) {
            return openGraph;
        }
        return null;
    }

    @Override
    public SocialMetaTag getOpenGraphByUrl(String url) {
        SocialMetaTag tag = new SocialMetaTag();
        try {
            Document document = Jsoup.connect(url).header("Access-Control-Allow-Origin", url).get();
            tag.setTitle(document.head().select("meta[property=og:title]").attr("content"));
            tag.setSite(document.head().select("meta[property=og:site_name]").attr("content"));
            tag.setImage(document.head().select("meta[property=og:image]").attr("content"));
            tag.setUrl(document.head().select("meta[property=og:url]").attr("content"));
        } catch (IOException e) {
            log.error(e.getMessage(), e.getCause());
        }
        return tag;
    }

    @Override
    public SocialMetaTag getTwitterCardByUrl(String url) {
        SocialMetaTag tag = new SocialMetaTag();
        try {
            Document document = Jsoup.connect(url).header("Access-Control-Allow-Origin", url).get();
            tag.setTitle(document.head().select("meta[name=twitter:title]").attr("content"));
            tag.setSite(document.head().select("meta[name=twitter:site]").attr("content"));
            tag.setImage(document.head().select("meta[name=twitter:image]").attr("content"));
            tag.setUrl(document.head().select("meta[name=twitter:url]").attr("content"));
        } catch (IOException e) {
            log.error(e.getMessage(), e.getCause());
        }
        return tag;
    }

    private boolean isNotEmpty(SocialMetaTag tag) {
        if(StringUtils.hasText(tag.getSite()) || StringUtils.hasText(tag.getImage()) ||
                StringUtils.hasText(tag.getUrl()) ||
                StringUtils.hasText(tag.getTitle())) return true;
        return false;
    }
}
