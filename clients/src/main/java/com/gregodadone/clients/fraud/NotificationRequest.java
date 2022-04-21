package com.gregodadone.clients.fraud;

import lombok.Builder;

@Builder
public record NotificationRequest(
        int toCustomerId,
        String toCustomerEmail,
        String message
) {
}
