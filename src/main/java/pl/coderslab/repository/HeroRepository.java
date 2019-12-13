package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Hero;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
