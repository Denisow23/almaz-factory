package ru.denisov.AlmazFactory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.Rank;

@Repository
public interface RankRepository extends CrudRepository<Rank, Integer> {
}
