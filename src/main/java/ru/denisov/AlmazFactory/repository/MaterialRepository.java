package ru.denisov.AlmazFactory.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.Material;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer> {
}
