package se.hakanostrom.stugan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.hakanostrom.stugan.entity.Stuga;

// Står för "interfacet" mot databasen. Inga extrafunktioner har behövts läggas till (i dagsläget).
@Repository
public interface StugaRepository extends CrudRepository<Stuga, Long> {
}
