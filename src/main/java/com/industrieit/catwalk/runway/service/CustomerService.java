package com.industrieit.catwalk.runway.service;

import com.industrieit.catwalk.runway.dao.CustomerRepository;
import com.industrieit.catwalk.runway.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        log.info("Getting all customers");
        return customerRepository.findAll();
    }
}
