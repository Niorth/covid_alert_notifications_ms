package fr.projetiwa.covid_alert_notifications_ms.services;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class NotificationsService {

    public Boolean userIsNegative(Long user_id){ //mettre userID
        HttpHeaders headers = new HttpHeaders(); // set Content-Type and Accept headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // example of custom header
        headers.set("X-Request-Source", "Desktop"); // build the request
        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = "http://localhost:8080/personState";
        ResponseEntity<Boolean> response = restTemplate.exchange( serviceUrl, HttpMethod.GET, request, Boolean.class, 1 );
        Boolean isNegative = response.getBody();
        System.out.println(isNegative);
        return isNegative;
    }

    public Boolean userIsSuspicious(Long user_id){ //FAIRE PASSER ID
        HttpHeaders headers = new HttpHeaders(); // set Content-Type and Accept headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // example of custom header
        headers.set("X-Request-Source", "Desktop"); // build the request
        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = "http://localhost:8080/covidState";
        ResponseEntity<Boolean> response = restTemplate.exchange( serviceUrl, HttpMethod.GET, request, Boolean.class, 1 );
        Boolean isSuspicious = response.getBody();
        System.out.println(isSuspicious);
        return isSuspicious;
    }

}
