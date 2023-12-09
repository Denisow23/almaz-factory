package ru.denisov.AlmazFactory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
