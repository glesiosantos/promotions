package br.dev.thinkers.promotions.repositories;

import br.dev.thinkers.promotions.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, String> {
}
