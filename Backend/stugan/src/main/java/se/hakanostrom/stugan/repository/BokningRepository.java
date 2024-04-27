package se.hakanostrom.stugan.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.hakanostrom.stugan.entity.Bokning;

@Repository
public interface BokningRepository extends CrudRepository<Bokning, Long> {

    @Query("FROM Bokning WHERE stuga_id=:stuga_id AND datum=:datum")
    public Iterable<Bokning> findDoublebook(@Param("stuga_id") Long stugaId, @Param("datum") String datum);

    @Query("FROM Bokning WHERE stuga_id=:stuga_id")
    public Iterable<Bokning> findByStuga(@Param("stuga_id") Long stugaId);
}
