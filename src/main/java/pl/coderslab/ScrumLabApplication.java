package pl.coderslab;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.coderslab.model.Hero;
import pl.coderslab.repository.HeroRepository;

import java.util.stream.IntStream;

@SpringBootApplication

public class ScrumLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrumLabApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(HeroRepository heroRepository) {
        Faker faker = new Faker();
        return args -> IntStream.range(0, 100).forEach(i->heroRepository.save(new Hero(faker.superhero().name())));
    }

}
