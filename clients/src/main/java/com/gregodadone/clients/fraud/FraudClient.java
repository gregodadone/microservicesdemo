package com.gregodadone.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("fraud")
public interface FraudClient {

}
