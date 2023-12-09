package ru.denisov.AlmazFactory.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.denisov.AlmazFactory.model.Material;
import ru.denisov.AlmazFactory.model.Order;
import ru.denisov.AlmazFactory.model.Product;
import ru.denisov.AlmazFactory.model.Supply;
import ru.denisov.AlmazFactory.repository.ProductRepository;
import ru.denisov.AlmazFactory.service.DirectorService;

@Controller
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping("/director")
    public String directorPage(){
        return "director/director";
    }

    @GetMapping("/director/orders")
    public String getOrders(Model model){
        model.addAttribute("orders",directorService.getAllOrders());
        return "director/entityPages/orders";
    }

    @GetMapping("/director/orders/edit/{id}")
    public String showEditOrderForm(@PathVariable Integer id, Model model) {
        Order order = directorService.getOrdersById(id);

        if(order != null) {
            model.addAttribute("order", order);
            model.addAttribute("customers", directorService.getAllCustomers());
            model.addAttribute("products", directorService.getAllProducts());
            return "director/editPages/editOrderPage";
        }
        return "redirect:/director/orders";
    }

    @PostMapping("/director/orders/edit")
    public String editOrder(@ModelAttribute Order order) {
        directorService.updateOrder(order);
        return "redirect:/director/orders";
    }

    @GetMapping("/director/orders/delete/{id}")
    public String deleteOrder(@PathVariable Integer id){
        directorService.deleteOrdersById(id);

        return "redirect:/director/orders";
    }

    @GetMapping("/director/orders/create")
    public String showCreateOrderForm(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("customers", directorService.getAllCustomers());
        model.addAttribute("products", directorService.getAllProducts());
        return "director/createPages/createOrderPage";
    }

    @PostMapping("/director/orders/create")
    public String createOrder(@ModelAttribute Order order) {
        directorService.saveOrder(order);
        return "redirect:/director/orders";
    }

    @GetMapping("/director/materials")
    public String getMaterials(Model model){
        model.addAttribute("materials",directorService.getAllMaterial());
        return "director/entityPages/materials";
    }

    @GetMapping("/director/materials/edit/{id}")
    public String showEditMaterialForm(@PathVariable Integer id, Model model) {
        Material material = directorService.getMaterialById(id);

        if(material != null) {
            model.addAttribute("material", material);
            return "director/editPages/editMaterialPage";
        }
        return "redirect:/director/materials";
    }

    @PostMapping("/director/materials/edit")
    public String editMaterial(@ModelAttribute Material material) {
        directorService.updateMaterial(material);
        return "redirect:/director/materials";
    }

    @GetMapping("/director/materials/delete/{id}")
    public String deleteMaterial(@PathVariable Integer id){
        directorService.deleteMaterialById(id);

        return "redirect:/director/materials";
    }

    @GetMapping("/director/materials/create")
    public String showCreateForm(Model model){
        model.addAttribute("material", new Material());

        return "director/createPages/createMaterialPage";
    }

    @PostMapping("/director/materials/create")
    public String createTask(@ModelAttribute Material material) {
        directorService.saveMaterial(material);

        return "redirect:/director/materials";
    }

    @GetMapping("/director/supplies")
    public String getSupplies(Model model){
        model.addAttribute("supplies", directorService.getAllSupplies());
        return "director/entityPages/supplies";
    }

    @GetMapping("/director/supplies/edit/{id}")
    public String showEditSupplyForm(@PathVariable Integer id, Model model) {
        Supply supply = directorService.getSuppliesById(id);

        if(supply != null) {
            model.addAttribute("supply", supply);
            model.addAttribute("materials",directorService.getAllMaterial());
            return "director/editPages/editSupplyPage";
        }
        return "redirect:/director/supplies";
    }

    @PostMapping("/director/supplies/edit")
    public String editSupply(@ModelAttribute Supply supply) {
        directorService.updateSupply(supply);

        return "redirect:/director/supplies";
    }

    @GetMapping("/director/supplies/delete/{id}")
    public String deleteSupply(@PathVariable Integer id){
        directorService.deleteSuppliesById(id);

        return "redirect:/director/supplies";
    }

    @GetMapping("/director/supplies/create")
    public String showCreateSupplyForm(Model model){
        model.addAttribute("supply", new Supply());
        model.addAttribute("materials",directorService.getAllMaterial());

        return "director/createPages/createSupplyPage";
    }

    @PostMapping("/director/supplies/create")
    public String createSupply(@ModelAttribute Supply supply) {
        directorService.saveSupply(supply);

        return "redirect:/director/supplies";
    }
}
