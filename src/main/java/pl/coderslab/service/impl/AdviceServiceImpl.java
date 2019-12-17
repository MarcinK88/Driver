package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Advice;
import pl.coderslab.repository.AdviceRepository;
import pl.coderslab.service.AdviceService;

import java.util.List;
@Service
public class AdviceServiceImpl implements AdviceService {

    private final AdviceRepository adviceRepository;

    public AdviceServiceImpl(AdviceRepository adviceRepository) {
        this.adviceRepository = adviceRepository;
    }

    @Override
    public List<Advice> findAll() {
        return adviceRepository.findAll();
    }

    @Override
    public void save(Advice advice) {
        adviceRepository.save(advice);
    }

    @Override
    public Advice getOne(long id) {
        return adviceRepository.getOne(id);
    }

    @Override
    public void delete(Advice advice) {
        adviceRepository.delete(advice);
    }
}
