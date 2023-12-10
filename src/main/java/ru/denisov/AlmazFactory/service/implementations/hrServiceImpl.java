package ru.denisov.AlmazFactory.service.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.model.Rank;
import ru.denisov.AlmazFactory.model.enums.JobTitleOfEmployee;
import ru.denisov.AlmazFactory.repository.EmployeeRepository;
import ru.denisov.AlmazFactory.repository.RankRepository;
import ru.denisov.AlmazFactory.service.services.hrService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class hrServiceImpl implements hrService {

    private final EmployeeRepository employeeRepository;
    private final RankRepository rankRepository;

    @Override
    public Employee getEmplById(int id) {
        log.debug("Call getEmplById in hrService");

        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.debug("Call getAllEmployees in hrService");

        Iterable<Employee> employees = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        for(Employee employee : employees) {
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public List<Rank> getAllRanks() {
        log.debug("Call getAllRanks in hrService");

        Iterable<Rank> ranks = rankRepository.findAll();
        List<Rank> rankList = new ArrayList<>();
        for(Rank rank : ranks) {
            rankList.add(rank);
        }
        return rankList;
    }

    @Override
    public List<String> getAllTitles() {
        List<String> list= new ArrayList<>();
        list.add(JobTitleOfEmployee.HR.toString());
        list.add(JobTitleOfEmployee.DIRECTOR.toString());
        list.add(JobTitleOfEmployee.WORKER.toString());
        return list;
    }

    @Override
    public Employee saveEmpl(Employee employee) {
        log.debug("Call saveEmpl in hrService");

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        log.debug("Call updateEmployee in hrService");
        Employee existedEmployee = getEmplById(employee.getId());
        if (existedEmployee != null){
           // employee.setEndWork(null);
            return employeeRepository.save(employee);
        }

        log.warn("Employee with id = " + employee.getId() + " does not exists");
        return null;
    }

    @Override
    public Employee dismissEmployeeById(Integer id) {
        log.debug("Call dismissEmployee in hrSrvice");

        Employee existedEmployee = getEmplById(id);
        if (existedEmployee != null) {
            existedEmployee.setEndWork(new Date());
            return employeeRepository.save(existedEmployee);
        }

        log.warn("Employee with id = " + id + " does not exists");
        return null;
    }

    @Override
    public Employee calculateSalaryById(Integer id) {
        log.debug("Call calculateSalary in hrSrvice");


        Employee existedEmployee = getEmplById(id);
        if (existedEmployee != null) {
            existedEmployee.setSalary(0);
            log.info("Salary for employee with id: " + existedEmployee.getId() + " calculated!");
            return employeeRepository.save(existedEmployee);
        }

        log.warn("Employee with id = " + id + " does not exists");
        return null;
    }

    @Override
    public void calculateSalaryAll() {
        log.debug("Call calculateSalaryAll");

        try {
            Iterable<Employee> employees = employeeRepository.findAll();
            employees.forEach(empl -> empl.setSalary(0));
            employeeRepository.saveAll(employees);
            log.info("Salary for all employees calculated!");
        } catch (Exception ex) {
            log.warn("Something wrong!");
        }

    }

    @Override
    public void deleteEmployeeById(Integer id) {
        log.debug("Call deleteEmployeeById");

        employeeRepository.deleteById(id);
    }


}
