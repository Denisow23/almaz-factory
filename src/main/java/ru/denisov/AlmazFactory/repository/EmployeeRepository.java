package ru.denisov.AlmazFactory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    public Employee findByEmplLogin(String login);
}
