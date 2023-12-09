package ru.denisov.AlmazFactory.repository;

import org.springframework.data.repository.CrudRepository;
import ru.denisov.AlmazFactory.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
