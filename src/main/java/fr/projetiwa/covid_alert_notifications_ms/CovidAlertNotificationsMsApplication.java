package fr.projetiwa.covid_alert_notifications_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CovidAlertNotificationsMsApplication {
	/**
	 * creates a rest template
	 * @return a new RestTemplate
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * main function to launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CovidAlertNotificationsMsApplication.class, args);
	}

}
