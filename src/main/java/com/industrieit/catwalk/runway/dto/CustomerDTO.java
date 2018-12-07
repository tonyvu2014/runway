package com.industrieit.catwalk.runway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private String firstName;
    private String lastName;

    private String email;
    private String dateOfBirth;
}
