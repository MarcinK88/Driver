package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Advice;

public interface AdviceRepository extends JpaRepository<Advice, Long> {
}
