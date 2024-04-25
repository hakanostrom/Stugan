package se.hakanostrom.stugan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.hakanostrom.stugan.entity.Bokning;

@Repository
public interface BokningRepository extends CrudRepository<Bokning, Long> {
}
