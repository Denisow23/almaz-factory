//package ru.denisov.AlmazFactory.web;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ru.denisov.AlmazFactory.model.Employee;
//import ru.denisov.AlmazFactory.repository.EmployeeRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class EmployeeController {
//
//    @Autowired
//    private final EmployeeRepository employeeRepository;
//
//    @GetMapping("/")
//    public List<Employee> employeeList(){
//        Iterable<Employee> iter = employeeRepository.findAll();
//        ArrayList<Employee> list = new ArrayList<>();
//        for (Employee employee : iter) {
//            list.add(employee);
//        }
//
//        return list;
//    }
//}
