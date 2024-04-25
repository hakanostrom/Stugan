package se.hakanostrom.stugan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.hakanostrom.stugan.entity.Bokning;
import se.hakanostrom.stugan.repository.BokningRepository;

import java.util.List;

@Service
public class BokningServiceImpl implements BokningService {

    @Autowired
    private BokningRepository bokningRepository;

    @Override
    public Bokning sparaBokning(Bokning bokning) {
        return bokningRepository.save(bokning);
    }

    @Override
    public List<Bokning> listaBokningar() {
        return (List<Bokning>) bokningRepository.findAll();
    }
}
