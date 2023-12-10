package ru.denisov.AlmazFactory.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.denisov.AlmazFactory.model.Report;
import ru.denisov.AlmazFactory.service.implementations.WorkerServiceImpl;

@Controller
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerServiceImpl workerService;

    @GetMapping("/worker")
    public String getWorkerPage() {
        return "worker/worker";
    }

    @GetMapping("/worker/orders")
    public String getOrdersInWork(Model model){
        model.addAttribute("orders", workerService.getAllOrders());
        return "worker/orders";
    }

    @GetMapping("/worker/createReport")
    public String showCreateReportPage(Model model){
        model.addAttribute("report", new Report());
        model.addAttribute("employees", workerService.getAllEmployees());
        model.addAttribute("products", workerService.getAllProducts());
        return "worker/createReport";
    }

    @PostMapping("/worker/createReport")
    public String createReport(@ModelAttribute Report report){
        workerService.saveReport(report);

        return "redirect:/worker";
    }


}
