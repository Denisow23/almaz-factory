package ru.denisov.AlmazFactory.repository;

import org.springframework.data.repository.CrudRepository;
import ru.denisov.AlmazFactory.model.Supply;

public interface SupplyRepository extends CrudRepository<Supply, Integer> {
}
