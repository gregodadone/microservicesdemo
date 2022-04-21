package com.gregodadone.notification;

import com.gregodadone.clients.fraud.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationServiceImpl(
        NotificationRepository notificationRepository
) implements NotificationService {
    @Override
    public void send(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("Grego Dadone")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build();

        notificationRepository.saveAndFlush(notification);
    }
}
