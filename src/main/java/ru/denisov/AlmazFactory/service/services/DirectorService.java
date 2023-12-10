package ru.denisov.AlmazFactory.service.services;

import ru.denisov.AlmazFactory.model.*;

import java.util.List;

public interface DirectorService {
    List<Order> getAllOrders();
    List<Supply> getAllSupplies();
    List<Material> getAllMaterial();

    List<Product> getAllProducts();

    List<Customer> getAllCustomers();
    Order saveOrder(Order order);
    Supply saveSupply(Supply supply);

    Material saveMaterial(Material material);
    Order updateOrder(Order order);
    Supply updateSupply(Supply supply);

    Material updateMaterial(Material material);

    Order getOrdersById(int id);
    Supply getSuppliesById(int id);
    Material getMaterialById(int id);

    void deleteOrdersById(int id);
    void deleteSuppliesById(int id);
    void deleteMaterialById(int id);




}
