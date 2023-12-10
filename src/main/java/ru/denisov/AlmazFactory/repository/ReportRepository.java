package ru.denisov.AlmazFactory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.Report;
import ru.denisov.AlmazFactory.model.pk.ReportPK;

@Repository
public interface ReportRepository extends CrudRepository<Report, ReportPK> {
}
