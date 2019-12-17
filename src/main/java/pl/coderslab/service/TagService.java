package pl.coderslab.service;

import pl.coderslab.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();

    void save(Tag tag);

    Tag getOne(long id);

    void delete(Tag one);
}
