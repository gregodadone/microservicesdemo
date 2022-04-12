package com.gregodadone.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(CustomerRepository customerRepository) implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.save(customer);
    }
}
