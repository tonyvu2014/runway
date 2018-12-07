package com.industrieit.catwalk.runway.service;

import com.industrieit.catwalk.runway.dao.CustomerRepository;
import com.industrieit.catwalk.runway.dto.CustomerDTO;
import com.industrieit.catwalk.runway.exception.DataNotFoundException;
import com.industrieit.catwalk.runway.model.Customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "customer")
@Slf4j
public class CustomerService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private CustomerRepository customerRepository;

    @Cacheable
    public List<Customer> getAllCustomers() {
        log.info("Getting all customers");
        return customerRepository.findAll();
    }

    @Cacheable(key="#email")
    public Customer getCustomer(String email) throws DataNotFoundException {
        log.info("Getting customer with email: {}", email);
        Optional<Customer> customer = customerRepository.findByEmail(email);
        return customer.orElseThrow(() -> new DataNotFoundException(String.format("Unable to find customer with email %s", email)));
    }

    @CachePut(key="#customerDTO.email")
    public Customer addCustomer(CustomerDTO customerDTO) {
        log.info("Adding a new customer customer with email: {}", customerDTO.getEmail());
        Customer customer = Customer.builder()
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .email(customerDTO.getEmail())
                .dateOfBirth(LocalDate.parse(customerDTO.getDateOfBirth(), DATE_TIME_FORMATTER))
                .build();
        return customerRepository.save(customer);
    }

    @CacheEvict(key="#email")
    public void deleteCustomer(String email) {
        log.info("Deleting customer with email: {}", email);
        customerRepository.deleteByEmail(email);
    }


}
