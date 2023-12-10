package ru.denisov.AlmazFactory.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
