package ru.denisov.AlmazFactory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
