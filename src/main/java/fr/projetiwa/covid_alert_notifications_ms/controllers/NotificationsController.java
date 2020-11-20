package fr.projetiwa.covid_alert_notifications_ms.controllers;
import fr.projetiwa.covid_alert_notifications_ms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {
    private NotificationsService notificationsService;
/*
        if(notificationsService.userIsNegative(token) && notificationsService.userIsSuspicious(token)){
            return true;
        }
        return false;
    */

    @GetMapping("/mustbenotified")
    @CrossOrigin(origins="*")
    public Boolean mustbenotified  (@RequestHeader (name="Authorization") String token) {
        System.out.println("token controller " + token);

        notificationsService = new NotificationsService();
        return notificationsService.userIsNegative(token);
    }
}
