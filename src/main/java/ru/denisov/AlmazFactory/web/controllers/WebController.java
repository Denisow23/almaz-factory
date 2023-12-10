package ru.denisov.AlmazFactory.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.model.enums.JobTitleOfEmployee;
import ru.denisov.AlmazFactory.repository.EmployeeRepository;
import ru.denisov.AlmazFactory.web.webUtils.UserInfo;


@Controller
@RequiredArgsConstructor
public class WebController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String loginPage(Model model){
        model.addAttribute("userInfo", new UserInfo());
        return "login";
    }

    @PostMapping("/")
    public String authorize(@ModelAttribute UserInfo userInfo){
        Employee employee = employeeRepository.findByEmplLogin(userInfo.getLogin());

        if (employee != null && employee.getPassword().equals(userInfo.getPassword())) {
            if (employee.getJobTitle().equals(JobTitleOfEmployee.HR)){
                return "redirect:/hr";
            }
            if (employee.getJobTitle().equals(JobTitleOfEmployee.DIRECTOR)){
                return "redirect:/director";
            }if (employee.getJobTitle().equals(JobTitleOfEmployee.WORKER)){
                return "redirect:/worker";
            }
        }
        return "redirect:/";
    }
}
