package fr.projetiwa.covid_alert_notifications_ms.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class NotificationsService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * calls the CovidState microservice to know if the user is negative or not
     * @param token
     * @return a boolean
     * true if the user is "negative"
     * false otherwise
     */
    public Boolean userIsNegative(String token){

        HttpHeaders headers = new HttpHeaders(); // set Content-Type and Accept headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // example of custom header
        headers.add("Authorization", token );
        HttpEntity request = new HttpEntity(headers);
        String serviceUrl = "http://localhost:3002/personState/isNegative";

        try {
            ResponseEntity<String> response = restTemplate.exchange( serviceUrl, HttpMethod.GET, request, String.class, 1 );
            Boolean isNegative = Boolean.parseBoolean(response.getBody());
            System.out.println("isNegative ? "+isNegative);
            return isNegative;
        }catch (HttpClientErrorException e){
            System.out.println(e);
        }

        return false;
    }
    /**
     * calls the CovidState microservice to know if the user is contact or not
     * @param token
     * @return a boolean
     * true if the user is "contact"
     * false otherwise
     */
    public Boolean userIsContact(String token){

        HttpHeaders headers = new HttpHeaders(); // set Content-Type and Accept headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // example of custom header
        headers.add("Authorization", token );
        HttpEntity request = new HttpEntity(headers);
        String serviceUrl = "http://localhost:3002/personState/isContact";

        try {
            ResponseEntity<String> response = restTemplate.exchange( serviceUrl, HttpMethod.GET, request, String.class, 1 );
            Boolean isContact = Boolean.parseBoolean(response.getBody());
            System.out.println("isContact ? "+isContact);
            return isContact;
        }catch (HttpClientErrorException e){
            System.out.println(e);
        }

        return false;
    }
    /**
     * calls the SuspiciousPosition microservice to know if the user is suspicious or not
     * @param token
     * @return a boolean
     * true if the user is "suspicious"
     * false otherwise
     */
    public Boolean userIsSuspicious(String token){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // example of custom header
        headers.add("Authorization", token );
        HttpEntity request = new HttpEntity(headers);
        String serviceUrl = "http://localhost:3005/suslocation/isSuspicious";

        try {
            ResponseEntity<String> response = restTemplate.exchange( serviceUrl, HttpMethod.GET, request, String.class, 1 );
            JSONObject jsonObject = new JSONObject(response.getBody());
            System.out.println(response.getBody());

            Boolean isSuspicious = jsonObject.getBoolean("isSuspicious");
            System.out.println("is Suspicious ? "+isSuspicious);

            return isSuspicious;

        }catch (HttpClientErrorException e){
            System.out.println(e);
        }

        return false;
    }

    /**
     * calls the CovidState microservice to know if the user is new or not
     * @param token
     * @return a boolean
     * true if the user is "new"
     * false otherwise
     */
    public Boolean userIsNew(String token){

        HttpHeaders headers = new HttpHeaders(); // set Content-Type and Accept headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // example of custom header
        headers.add("Authorization", token );
        HttpEntity request = new HttpEntity(headers);
        String serviceUrl = "http://localhost:3002/personState/isNew";

        try {
            ResponseEntity<String> response = restTemplate.exchange( serviceUrl, HttpMethod.GET, request, String.class, 1 );
            Boolean isNew = Boolean.parseBoolean(response.getBody());
            System.out.println("isNew ? "+isNew);
            return isNew;
        }catch (HttpClientErrorException e){
            System.out.println(e);
        }

        return false;
    }

}
