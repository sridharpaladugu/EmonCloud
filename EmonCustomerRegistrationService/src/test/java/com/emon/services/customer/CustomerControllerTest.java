package com.emon.services.customer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(EmonCustomerRegistrationServiceApplication.class)
@WebAppConfiguration
public class CustomerControllerTest {
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	private MockMvc mockMvc;
	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

		Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@SuppressWarnings("unchecked")
	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void testCRUD() throws Exception {
		testCreate();
		findByPrimaryPhoneNumber();
		findByFirstNameAndLastName();
	}

	public void testCreate() throws Exception {
		Customer customer = createCustomer();
		String customerJson = json(customer);
		ResultActions actions = this.mockMvc
				.perform(post("/customer/createCustomer").contentType(contentType).content(customerJson));
		actions.andExpect(status().isOk());
		actions.andExpect(content().contentType(contentType));
		actions.andExpect(jsonPath("customerId", is(1)));
		actions.andDo(MockMvcResultHandlers.print());
	}

	public void findByFirstNameAndLastName() throws Exception {
		String firstName = "Sridhar";
		String lastName = "Paladugu";
		String action = "/customer/findByFirstNameAndLastName/"+ firstName +"/"+lastName;
		ResultActions resultActions = mockMvc.perform(get(action));
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(content().contentType(contentType));
		resultActions.andExpect(jsonPath("$[0].customerId", is(1)));
		resultActions.andExpect(jsonPath("$[0].firstName", is("Sridhar")));
		resultActions.andExpect(jsonPath("$[0].lastName", is("Paladugu")));
		resultActions.andExpect(jsonPath("$", hasSize(1)));
	}

	public void findByPrimaryPhoneNumber() throws Exception {
		String phone = "6307247565";
		ResultActions resultActions = mockMvc.perform(get("/customer/findByPhone/" + phone));
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(content().contentType(contentType));
		resultActions.andExpect(jsonPath("$[0].customerId", is(1)));
		resultActions.andExpect(jsonPath("$[0].firstName", is("Sridhar")));
		resultActions.andExpect(jsonPath("$[0].lastName", is("Paladugu")));
		resultActions.andExpect(jsonPath("$", hasSize(1)));
	}

	private Customer createCustomer() {
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
		return customer;
	}

}
