package com.gregodadone.customer;

import com.gregodadone.clients.fraud.FraudCheckResponse;
import com.gregodadone.clients.fraud.FraudClient;
import com.gregodadone.clients.fraud.NotificationClient;
import com.gregodadone.clients.fraud.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository,
        FraudClient fraudClient,
        NotificationClient notificationClient
) implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (Boolean.TRUE.equals(fraudCheckResponse.isFraudster())) {
            throw new IllegalStateException("fraudster");
        }

        notificationClient.sendNotification(NotificationRequest.builder()
                .toCustomerId(customer.getId())
                .toCustomerEmail(customer.getEmail())
                .message(String.format("Hi %s, welcome to gregodadone.com",
                        customer.getFirstName()))
                .build());
    }
}
