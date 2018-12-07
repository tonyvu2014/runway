package com.industrieit.catwalk.runway.controller;

import com.industrieit.catwalk.runway.dto.CustomerDTO;
import com.industrieit.catwalk.runway.exception.DataNotFoundException;
import com.industrieit.catwalk.runway.model.Customer;
import com.industrieit.catwalk.runway.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value="customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(value="customer")
    public Customer getCustomer(String email) throws DataNotFoundException {
        return customerService.getCustomer(email);
    }

    @PostMapping(value="customer")
    @ResponseBody
    public Customer addCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

    @DeleteMapping(value="customer")
    public void deleteCustomer(String email) {
        customerService.deleteCustomer(email);
    }
}
