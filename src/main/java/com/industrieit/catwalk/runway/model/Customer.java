package com.industrieit.catwalk.runway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Entity
@Table(name="customer")
public class Customer {

    @Id
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique=true)
    private String email;
    private LocalDate dateOfBirth;
}
