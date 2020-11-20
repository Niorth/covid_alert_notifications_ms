package fr.projetiwa.covid_alert_notifications_ms.services;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


public class NotificationsService {

    public Boolean userIsNegative(String token){
        System.out.println("token service "+token);

        HttpHeaders headers = new HttpHeaders(); // set Content-Type and Accept headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // example of custom header
        headers.add("Authorization", token );
        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = "http://localhost:3002/personState/isNegative";
        System.out.println(headers.toString());

        try {
            ResponseEntity<String> response = restTemplate.exchange( serviceUrl, HttpMethod.GET, request, String.class, 1 );
            return true;
        }catch (HttpClientErrorException e){
            System.out.println(e);
        }

        return false;
    }

    public Boolean userIsSuspicious(){
        HttpHeaders headers = new HttpHeaders(); // set Content-Type and Accept headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // example of custom header
        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = "http://localhost:8080/covidState";
        ResponseEntity<Boolean> response = restTemplate.exchange( serviceUrl, HttpMethod.GET, request, Boolean.class, 1 );
        Boolean isSuspicious = response.getBody();
        System.out.println(isSuspicious);
        return isSuspicious;
    }

}
