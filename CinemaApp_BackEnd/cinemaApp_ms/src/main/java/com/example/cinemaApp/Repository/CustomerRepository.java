package com.example.cinemaApp.Repository;

import com.example.cinemaApp.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findById(int customerID);
}
