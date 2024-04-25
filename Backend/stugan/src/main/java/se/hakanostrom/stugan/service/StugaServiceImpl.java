package se.hakanostrom.stugan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.hakanostrom.stugan.entity.Stuga;
import se.hakanostrom.stugan.repository.StugaRepository;

import java.util.List;

@Service
public class StugaServiceImpl implements StugaService {

    @Autowired
    private StugaRepository stugaRepository;

    @Override
    public List<Stuga> listaStugor() {
        return (List<Stuga>) stugaRepository.findAll();
    }
}
