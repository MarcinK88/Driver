package pl.coderslab.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String superPower;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTimeOfBirth = LocalDateTime.now();
    @DecimalMin("0")
    private double ranked;

    public Hero(String name) {
        this.name = name;
    }

    public Hero() {
    }
}
