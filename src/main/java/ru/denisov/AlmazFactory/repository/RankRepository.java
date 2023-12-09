package ru.denisov.AlmazFactory.repository;

import org.springframework.data.repository.CrudRepository;
import ru.denisov.AlmazFactory.model.Rank;

public interface RankRepository extends CrudRepository<Rank, Integer> {
}
