package com.industrieit.catwalk.runway.dao;

import com.industrieit.catwalk.runway.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
