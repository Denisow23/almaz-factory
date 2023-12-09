package ru.denisov.AlmazFactory.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.denisov.AlmazFactory.model.*;
import ru.denisov.AlmazFactory.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DirectorServiceImpl implements DirectorService{

    private final OrderRepository orderRepository;
    private final SupplyRepository supplyRepository;
    private final MaterialRepository materialRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    @Override
    public List<Order> getAllOrders() {
        log.debug("Call getAllOrders in DirectorService");

        Iterable<Order> orders = orderRepository.findAll();
        List<Order> orderList = new ArrayList<>();
        for(Order order : orders){
            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Supply> getAllSupplies() {
        log.debug("Call getAllSupplies in DirectorService");

        Iterable<Supply> supplies = supplyRepository.findAll();
        List<Supply> supplyList = new ArrayList<>();
        for(Supply supply : supplies){
            supplyList.add(supply);
        }
        return supplyList;
    }

    @Override
    public List<Material> getAllMaterial() {
        log.debug("Call getAllMaterials in DirectorService");

        Iterable<Material> materials = materialRepository.findAll();
        List<Material> materialList = new ArrayList<>();
        for(Material material : materials) {
            materialList.add(material);
        }

        return materialList;
    }

    @Override
    public List<Product> getAllProducts() {
        log.debug("Call getAllProducts in DirectorService");

        Iterable<Product> products = productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        for(Product product : products) {
            productList.add(product);
        }

        return productList;
    }

    @Override
    public List<Customer> getAllCustomers() {
        log.debug("Call getAllCustomers in DirectorService");

        Iterable<Customer> customers = customerRepository.findAll();
        List<Customer> customersList = new ArrayList<>();
        for(Customer customer : customers) {
            customersList.add(customer);
        }

        return customersList;
    }

    @Override
    public Order saveOrder(Order order) {
        log.debug("Call saveOrder in DirectorService");

        return orderRepository.save(order);
    }

    @Override
    public Supply saveSupply(Supply supply) {
        log.debug("Call saveSupply in DirectorService");

        return supplyRepository.save(supply);
    }

    @Override
    public Material saveMaterial(Material material) {
        log.debug("Call saveMaterial in DirectorService");

        return materialRepository.save(material);
    }

    @Override
    public Order updateOrder(Order order) {
        log.debug("Call updateOrder in DirectorService");

        Order existedOrder = getOrdersById(order.getId());
        if (existedOrder != null) {
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Supply updateSupply(Supply supply) {
        log.debug("Call updateSupply in DirectorService");

        Supply existedSupply = getSuppliesById(supply.getId());
        if (existedSupply != null) {
            return supplyRepository.save(supply);
        }
        return null;
    }

    @Override
    public Material updateMaterial(Material material) {
        log.debug("Call updateSupply in DirectorService");

        Material existedMaterial = getMaterialById(material.getId());
        if (existedMaterial != null) {
            return materialRepository.save(material);
        }
        return null;
    }

    @Override
    public Order getOrdersById(int id) {
        log.debug("Call getOrdersById in DirectorService");

        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Supply getSuppliesById(int id) {
        log.debug("Call getSuppliesById in DirectorService");

        return supplyRepository.findById(id).orElse(null);
    }

    @Override
    public Material getMaterialById(int id) {
        log.debug("Call getSuppliesById in DirectorService");

        return materialRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrdersById(int id) {
        log.debug("Call deleteOrdersById in DirectorService");

        orderRepository.deleteById(id);
    }

    @Override
    public void deleteSuppliesById(int id) {
        log.debug("Call deleteSuppliesById in DirectorService");

        supplyRepository.deleteById(id);
    }

    @Override
    public void deleteMaterialById(int id) {
        log.debug("Call deleteMaterialById in DirectorService");

        materialRepository.deleteById(id);
    }
}
