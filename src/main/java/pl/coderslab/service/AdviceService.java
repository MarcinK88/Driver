package pl.coderslab.service;

import pl.coderslab.model.Advice;

import java.util.List;

public interface AdviceService {

    List<Advice> findAll();

    void save(Advice advice);

    Advice getOne(long id);

    void delete(Advice advice);
}
