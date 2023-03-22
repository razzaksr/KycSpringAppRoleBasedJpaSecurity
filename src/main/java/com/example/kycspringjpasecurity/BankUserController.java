package com.example.kycspringjpasecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banker")
public class BankUserController {
    @Autowired
    BankUserService service;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public BankUser addNewUser(@RequestBody BankUser bankUser){
        bankUser.setPassword(passwordEncoder.encode(bankUser.getPassword()));
        return service.add(bankUser);
    }
}
