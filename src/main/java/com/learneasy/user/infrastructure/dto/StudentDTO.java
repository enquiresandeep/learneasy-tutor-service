package com.learneasy.user.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class StudentDTO {

    private String studentId;

    private String firstName;
    private String lastName;
    private String studentStatus;
    private List<Phone> phones;
    private int defaultAddressID;
    private int defaultPaymentProfileId;

}
