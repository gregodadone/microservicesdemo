package com.gregodadone.notification;

import com.gregodadone.clients.fraud.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public record NotificationServiceImpl(
        NotificationRepository notificationRepository
) implements NotificationService {
    @Override
    public void send(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .text(notificationRequest.text())
                .build();

        notificationRepository.saveAndFlush(notification);
    }
}
