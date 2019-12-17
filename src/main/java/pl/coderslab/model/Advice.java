package pl.coderslab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "advices")
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pathToImage;
    private String title;
    private String leader;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Long recommends;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "advice_tag", joinColumns = @JoinColumn(name = "advice_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

}
