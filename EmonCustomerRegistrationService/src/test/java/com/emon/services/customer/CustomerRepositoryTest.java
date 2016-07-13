package com.emon.services.customer;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EmonCustomerRegistrationServiceApplication.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	@Test
	public void testSaveS() {
		Customer customer = new Customer();
		customer.setFirstName("Sridhar");
		customer.setLastName("Paladugu");
		customer.setPrimaryPhoneNumber("6307247565");
		customer.setSecondaryPhoneNumber("6786486066");
		customer.setAddressLine1("3840 James Trail Dr");
		customer.setCity("Cumming");
		customer.setState("GA");
		customer.setZip("30041");
		customer.setEmail("spaladugu@pivotal.io");
		customer.setEmgergencyContactFirstname("Sirisha");
		customer.setEmgergencyContactLastname("Paladugu");
		customer.setEmgergencyContactPhoneNumber("6304325434");
		customerRepository.saveAndFlush(customer);
		List<Customer> customers = customerRepository.findByPrimaryPhoneNumber("6307247565");
		Assert.assertTrue(customers.size() == 1);
	}
	@Test
	public void testFindByFirstNameAndLastName() {
		String firstName = "Sridhar";
		String LastName = "Paladugu";
		List<Customer> customers = customerRepository.findByFirstNameAndLastName(firstName, LastName);
		Assert.assertTrue(customers.size() == 1);
	}

	@Test
	@Ignore
	public void testFindByPrimaryPhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testFindAll() {
		fail("Not yet implemented");
	}


}
