package ru.denisov.AlmazFactory.service.services;

import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.model.Product;
import ru.denisov.AlmazFactory.model.Report;
import ru.denisov.AlmazFactory.model.pk.ReportPK;
import ru.denisov.AlmazFactory.model.viewEntity.Orders2WorkerEntity;

import java.util.List;

public interface WorkerService {

    Report getReportByReportPK(ReportPK reportPK);
    Report saveReport(Report report);
    List<Product> getAllProducts();
    List<Employee> getAllEmployees();

    List<Orders2WorkerEntity> getAllOrders();

}
