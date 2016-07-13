package com.emon.services.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
	List<Customer> findByPrimaryPhoneNumber(String primaryPhoneNumber);
}
