package br.dev.thinkers.promotions.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "promotions")
public class Promotion extends DateAudit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank(message = "required field")
    private String title;

    @NotNull(message = "required field")
    @Column(name = "link_promotion")
    private String linkPromotion;

    @NotNull(message = "required field")
    @Column(name = "site_promotion")
    private String sitePromotion;

    private String description;

    @NotNull(message = "required field")
    @Column(name = "image_link")
    private String imageLink;

    @NotNull(message = "required field")
    @NumberFormat(pattern = "#,##0.00", style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;

    @Column(name = "total_likes")
    private int likes;

    @NotNull(message = "required field")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_category")
    private Category category;
}
