package fr.projetiwa.covid_alert_notifications_ms.controllers;
import fr.projetiwa.covid_alert_notifications_ms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {
    @Autowired
    private NotificationsService notificationsService;

    @GetMapping("/mustbenotified")
    @CrossOrigin(origins="*")
    public Boolean mustbenotified  (@RequestHeader (name="Authorization") String token) {

        if(notificationsService.userIsNew(token)){
            System.out.println("user is new");
            return false;
        }else if(notificationsService.userIsNegative(token) && notificationsService.userIsSuspicious(token)){
            System.out.println("user is negative and suspicious");
            return true;
        }
        return false;

    }
}
