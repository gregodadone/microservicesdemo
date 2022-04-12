package com.gregodadone.customer;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email
) {}
