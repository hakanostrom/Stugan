package se.hakanostrom.stugan.service;

import se.hakanostrom.stugan.entity.Stuga;

import java.util.List;
import java.util.Optional;

public interface StugaService {
    List<Stuga> listaStugor();

    Optional<Stuga> hittaStuga(Long id);
}
