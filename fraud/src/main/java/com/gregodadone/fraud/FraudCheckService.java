package com.gregodadone.fraud;

public interface FraudCheckService {
    Boolean isFraudulentCustomer(Integer customerId);
}
