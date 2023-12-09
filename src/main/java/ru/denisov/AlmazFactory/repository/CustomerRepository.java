package ru.denisov.AlmazFactory.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import ru.denisov.AlmazFactory.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
