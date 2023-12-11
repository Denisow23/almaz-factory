package ru.denisov.AlmazFactory.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.denisov.AlmazFactory.model.Employee;
import ru.denisov.AlmazFactory.model.Report;
import ru.denisov.AlmazFactory.service.implementations.WorkerServiceImpl;

@Controller
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerServiceImpl workerService;

    @GetMapping("/worker/{id}")
    public String getWorkerPage(@PathVariable Integer id, Model model) {
        Employee employee = workerService.getEmployeeById(id);
        model.addAttribute("empl", employee);
        return "worker/worker";
    }

    @GetMapping("/worker/{id}/orders")
    public String getOrdersInWork(Model model){
        model.addAttribute("orders", workerService.getAllOrders());
        return "worker/orders";
    }

    @GetMapping("/worker/{id}/createReport")
    public String showCreateReportPage(@PathVariable Integer id, Model model){
        model.addAttribute("report", new Report());
        model.addAttribute("id", id);
        model.addAttribute("products", workerService.getAllProducts());
        return "worker/createReport";
    }

    @PostMapping("/worker/{id}/createReport")
    public String createReport(@ModelAttribute Report report, @PathVariable Integer id){
        report.getPk().setEmployee(workerService.getEmployeeById(id));
        workerService.saveReport(report);
        return "redirect:/worker/" + id;
    }

    @GetMapping("/worker/{id}/reports")
    public String showReports(@PathVariable Integer id, Model model){
        model.addAttribute("reports", workerService.getReportsByEmployeeId(id));
        model.addAttribute("id", id);
        return "worker/reports";
    }


}
