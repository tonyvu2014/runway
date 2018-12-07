package com.industrieit.catwalk.runway.dao;

import com.industrieit.catwalk.runway.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    @Modifying
    @Transactional
    void deleteByEmail(String email);
}
