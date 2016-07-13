package com.emon.services.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(value="/createCustomer", method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer saved = customerRepository.saveAndFlush(customer);
		return saved;
	}
	
	@RequestMapping(value="/findByFirstNameAndLastName/{firstName}/{lastName}", method=RequestMethod.GET)
	public List<Customer> findByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
		List<Customer> l = customerRepository.findByFirstNameAndLastName(firstName, lastName);
		return l;
	}
	
	@RequestMapping(value="/findByPhone/{phone}", method=RequestMethod.GET)
	public List<Customer> findByPrimaryPhoneNumber(@PathVariable String phone){
		return customerRepository.findByPrimaryPhoneNumber(phone);
	}
}
