package ru.denisov.AlmazFactory.repository.viewRepositories;

import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.pk.OrderVIew;
import ru.denisov.AlmazFactory.model.viewEntity.Orders2WorkerEntity;

@Repository
public interface Orders2WorkerEntityRepository extends ReadOnlyRepository<Orders2WorkerEntity, OrderVIew> {
}
