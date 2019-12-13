package pl.coderslab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pathToImage;
    private String title;
    private String lead;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Long recommends;
    private List<String> tags;


}
