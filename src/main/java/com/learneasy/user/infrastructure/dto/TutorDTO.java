package com.learneasy.user.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorDTO extends  BaseDTO{

    private String tutorId;
    private String firstName;
    private String lastName;
    private String tutorStatus;
    private List<PhoneDTO> phones;
    private int defaultAddressID;
    private int defaultPaymentProfileId;

}
