package ru.denisov.AlmazFactory.service.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.model.Product;
import ru.denisov.AlmazFactory.model.Report;
import ru.denisov.AlmazFactory.model.pk.ReportPK;
import ru.denisov.AlmazFactory.model.viewEntity.Orders2WorkerEntity;
import ru.denisov.AlmazFactory.repository.EmployeeRepository;
import ru.denisov.AlmazFactory.repository.viewRepositories.Orders2WorkerEntityRepository;
import ru.denisov.AlmazFactory.repository.ProductRepository;
import ru.denisov.AlmazFactory.repository.ReportRepository;
import ru.denisov.AlmazFactory.service.services.WorkerService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkerServiceImpl implements WorkerService {

    private final ReportRepository reportRepository;
    private final ProductRepository productRepository;
    private final EmployeeRepository employeeRepository;
    private final Orders2WorkerEntityRepository orders2WorkerEntityRepository;
    @Override
    public Report getReportByReportPK(ReportPK reportPK) {
        log.debug("Call getReportByReportPK in WorkerService");

        return reportRepository.findById(reportPK).orElse(null);
    }

    @Override
    public Report saveReport(Report report) {
        log.debug("Call saveReport in WorkerService");

        return reportRepository.save(report);
    }

    @Override
    public List<Product> getAllProducts() {
        log.debug("Call getAllProducts in WorkerService");

        Iterable<Product> products = productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        for(Product product : products) {
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.debug("Call getAllEmployees in WorkerService");

        Iterable<Employee> employees = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        for(Employee product : employees) {
            employeeList.add(product);
        }
        return employeeList;
    }

    @Override
    public List<Orders2WorkerEntity> getAllOrders() {
        log.debug("Call getAllReports in WorkerService");

        return orders2WorkerEntityRepository.findAll();
    }
}
