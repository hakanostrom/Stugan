package se.hakanostrom.stugan.service;

import se.hakanostrom.stugan.entity.Bokning;

import java.util.List;
import java.util.Optional;

public interface BokningService {
    Optional<Bokning> sparaBokning(Bokning bokning);

    List<Bokning> listaBokningar();

    List<Bokning> listaBokningarPerStuga(Long stugaId);
}
