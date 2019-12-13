package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "tag")
    private String name;

}
