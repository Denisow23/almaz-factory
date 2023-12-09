package ru.denisov.AlmazFactory.repository;

import org.springframework.data.repository.CrudRepository;
import ru.denisov.AlmazFactory.model.Report;
import ru.denisov.AlmazFactory.model.pk.ReportPK;

public interface ReportRepository extends CrudRepository<Report, ReportPK> {
}
