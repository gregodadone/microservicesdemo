package com.gregodadone.notification;

import com.gregodadone.clients.fraud.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest notificationRequest);
}
