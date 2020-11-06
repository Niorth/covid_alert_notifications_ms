package fr.projetiwa.covid_alert_notifications_ms.controllers;
import fr.projetiwa.covid_alert_notifications_ms.services.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {
    
    private NotificationsService notificationsService;

    @GetMapping
    @RequestMapping("{id}")
    public Boolean get ( @PathVariable Long person_id ) {
        if(notificationsService.userIsNegative(person_id) && notificationsService.userIsSuspicious(person_id)){
            return true;
        }
        return false;
    }
}
