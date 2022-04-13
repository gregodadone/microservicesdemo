package com.gregodadone.notification;

import com.gregodadone.clients.fraud.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public record NotificationController(NotificationService notificationService) {
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("sending notification: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
