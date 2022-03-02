package br.dev.thinkers.promotions.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "promotions")
public class Promotion extends DateAudit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;

    @Column(name = "link_promotion")
    private String linkPromotion;

    @Column(name = "site_promotion")
    private String sitePromotion;

    private String description;

    @Column(name = "image_link")
    private String imageLink;


    @NumberFormat(pattern = "#,##0.00", style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;

    @Column(name = "total_likes")
    private int likes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_category")
    private Category category;
}
