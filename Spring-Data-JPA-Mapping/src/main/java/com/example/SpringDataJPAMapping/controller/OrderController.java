package com.example.SpringDataJPAMapping.controller;

import com.example.SpringDataJPAMapping.dto.OrderRequest;
import com.example.SpringDataJPAMapping.dto.OrderResponse;
import com.example.SpringDataJPAMapping.entity.Customer;
import com.example.SpringDataJPAMapping.repository.CustomerRepository;
import com.example.SpringDataJPAMapping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
       return customerRepository.save(request.getCustomer());
    }
    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse>getJoinInfo(){
        return customerRepository.getJoinInfo();
    }

}
