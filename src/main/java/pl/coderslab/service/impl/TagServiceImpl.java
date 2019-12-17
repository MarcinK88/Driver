package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Tag;
import pl.coderslab.repository.TagRepository;
import pl.coderslab.service.TagService;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public Tag getOne(long id) {
        return tagRepository.getOne(id);
    }

    @Override
    public void delete(Tag one) {
        tagRepository.delete(one);
    }
}
