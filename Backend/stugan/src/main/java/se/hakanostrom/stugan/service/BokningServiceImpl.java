package se.hakanostrom.stugan.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.hakanostrom.stugan.entity.Bokning;
import se.hakanostrom.stugan.repository.BokningRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class BokningServiceImpl implements BokningService {

    @Autowired
    private BokningRepository bokningRepository;

    @Override
    public Optional<Bokning> sparaBokning(Bokning bokning) {

        // Kontrollera så det inte finns en dubbelbokning på efterfrågad stuga (samma datum)
        var dubbelbokningar = bokningRepository.findDoublebook(bokning.getStuga_id(), bokning.getDatum());
        var antalDubbelbokningar = StreamSupport.stream(dubbelbokningar.spliterator(), false).count();
        log.info("Antal bokningar på stugan: " + antalDubbelbokningar);

        if (antalDubbelbokningar > 0)
            return Optional.empty();
        else
            return Optional.of(bokningRepository.save(bokning));
    }

    @Override
    public List<Bokning> listaBokningar() {
        return (List<Bokning>) bokningRepository.findAll();
    }

    @Override
    public List<Bokning> listaBokningarPerStuga(Long stugaId) {
        return (List<Bokning>) bokningRepository.findByStuga(stugaId);
    }
}
