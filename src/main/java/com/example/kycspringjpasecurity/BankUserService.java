package com.example.kycspringjpasecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BankUserService implements UserDetailsService {
    @Autowired
    private BankUserRepository repository;

    public BankUser add(BankUser bankUser){
        return repository.save(bankUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BankUser bankUser=repository.findByUsername(username);
        if(bankUser==null){
            throw new UsernameNotFoundException("Invalid username");
        }
        return bankUser;
    }
}
