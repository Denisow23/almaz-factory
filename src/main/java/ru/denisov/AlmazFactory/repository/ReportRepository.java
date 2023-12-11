package ru.denisov.AlmazFactory.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.Report;
import ru.denisov.AlmazFactory.model.pk.ReportPK;

import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<Report, ReportPK> {

    @Query(value = "SELECT * FROM get_reports_by_emp_id(:id)", nativeQuery = true)
    public List<Report> getReportsById(@Param("id") Integer id);
}
