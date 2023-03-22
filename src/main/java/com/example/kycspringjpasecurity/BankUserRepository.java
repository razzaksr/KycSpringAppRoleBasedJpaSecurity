package com.example.kycspringjpasecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser,String> {
    BankUser findByUsername(String username);
}
