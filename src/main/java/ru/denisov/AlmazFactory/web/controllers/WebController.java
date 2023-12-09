package ru.denisov.AlmazFactory.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.model.Order;
import ru.denisov.AlmazFactory.model.enums.JobTitleOfEmployee;
import ru.denisov.AlmazFactory.repository.EmployeeRepository;
import ru.denisov.AlmazFactory.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class WebController {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final OrderRepository orderRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Employee> iter = employeeRepository.findAll();
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee employee : iter) {
            list.add(employee);
        }

        Iterable<Order> iter1 = orderRepository.findAll();
        ArrayList<Order> list1 = new ArrayList<>();
        for (Order order : iter1) {
            list1.add(order);
        }
        model.addAttribute("orders", list1);
        model.addAttribute("employees", list);
        return "index";
    }

    @PostMapping("/")
    public String addBook(Employee book) {
        book.setJobTitle(JobTitleOfEmployee.WORKER);
        book.setEndWork(new Date(1702117160000L));
        Employee newBook = employeeRepository.save(book);
        return "redirect:/";
    }
}
