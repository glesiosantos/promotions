package br.dev.thinkers.promotions.repositories;

import br.dev.thinkers.promotions.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
