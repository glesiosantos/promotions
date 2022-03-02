package br.dev.thinkers.promotions.web;

import br.dev.thinkers.promotions.domain.Category;
import br.dev.thinkers.promotions.domain.Promotion;
import br.dev.thinkers.promotions.repositories.CategoryRepository;
import br.dev.thinkers.promotions.repositories.PromotionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/promotions")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PromotionController {

    private final CategoryRepository categoryRepository;
    private final PromotionRepository promotionRepository;

    @ModelAttribute("categories")
    public List<Category> loadCategories() {
        return this.categoryRepository.findAll();
    }

    @GetMapping("/form")
    public String addPromotion() {
        return "promo-add";
    }

    @PostMapping("/save")
    public ResponseEntity<Promotion> savePromotions(Promotion promotion){
      promotionRepository.save(promotion);
      return ResponseEntity.ok().build();
    }
}
