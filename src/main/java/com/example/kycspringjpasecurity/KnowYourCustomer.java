package com.example.kycspringjpasecurity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class KnowYourCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long accountNumber;
    private String accountHolder;
    private String email;
    private String pan;
    private long contact;
    private long aadhaar;
    private String address;
    private double accountBalance;
    private String accountPasscode;
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;
}
