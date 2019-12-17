package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tag")
    private String name;

}
