package fr.projetiwa.covid_alert_notifications_ms.controllers;
import fr.projetiwa.covid_alert_notifications_ms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {
    private NotificationsService notificationsService;
/*
        if(notificationsService.userIsNegative(person_id) && notificationsService.userIsSuspicious(person_id)){
            return true;
        }
        return false;
    */

    @GetMapping
    @RequestMapping("/mustbenotified")
    public Boolean mustbenotified  ( @RequestParam("personId") Long personId ) {
        notificationsService = new NotificationsService();
        return notificationsService.userIsNegative(personId);
    }
}
