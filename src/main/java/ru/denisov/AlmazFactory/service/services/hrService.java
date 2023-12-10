package ru.denisov.AlmazFactory.service.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.model.Rank;

import java.util.List;

public interface hrService {

    Employee getEmplById(int id);

    List<Employee> getAllEmployees();

    List<Rank> getAllRanks();

    List<String> getAllTitles();

    Employee saveEmpl(Employee employee);
    Employee updateEmployee(Employee employee);

    Employee dismissEmployeeById(Integer id);

    Employee calculateSalaryById(Integer id);

    void calculateSalaryAll();

    void deleteEmployeeById(Integer id);

}
