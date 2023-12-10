package ru.denisov.AlmazFactory.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.service.implementations.hrServiceImpl;

@Controller
@RequiredArgsConstructor
public class HrController {

    private final hrServiceImpl hrService;

    @GetMapping("/hr")
    public String hrPage(){
        return "hr/hr";
    }

    @GetMapping("/hr/employees")
    public String employees(Model model){
        model.addAttribute("employees", hrService.getAllEmployees());
        return "hr/entityPages/employees";
    }

    @GetMapping("/hr/employees/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Integer id, Model model) {
        Employee empl = hrService.getEmplById(id);

        if(empl != null) {
            model.addAttribute("empl", empl);
            model.addAttribute("ranks", hrService.getAllRanks());
            model.addAttribute("jobTitles", hrService.getAllTitles());
            return "hr/editPages/editEmployeePage";
        }
        return "redirect:/hr/employees";
    }

    @PostMapping("/hr/employees/edit")
    public String editEmployee(@ModelAttribute Employee empl) {
        hrService.updateEmployee(empl);
        return "redirect:/hr/employees";
    }

    @GetMapping("/hr/employees/dismiss/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        hrService.dismissEmployeeById(id);

        return "redirect:/hr/employees";
    }

    @GetMapping("/hr/employees/calculate/{id}")
    public String Calculate(@PathVariable Integer id){
        hrService.calculateSalaryById(id);

        return "redirect:/hr/employees";
    }

    @GetMapping("/hr/calculateAll")
    public String Calculate(){
        hrService.calculateSalaryAll();

        return "redirect:/hr";
    }

    @GetMapping("/hr/create")
    public String showCreateOrderForm(Model model){
        model.addAttribute("empl", new Employee());
        model.addAttribute("jobTitles", hrService.getAllTitles());
        model.addAttribute("ranks", hrService.getAllRanks());
        return "hr/createPages/createEmployeePage";
    }

    @PostMapping("/hr/create")
    public String createOrder(@ModelAttribute Employee employee) {
        hrService.saveEmpl(employee);
        return "redirect:/hr";
    }
}
