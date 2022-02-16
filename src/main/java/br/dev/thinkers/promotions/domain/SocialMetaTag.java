package br.dev.thinkers.promotions.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SocialMetaTag implements Serializable {

    private String site;
    private String title;
    private String url;
    private String image;


}
