package fr.projetiwa.covid_alert_notifications_ms;

import fr.projetiwa.covid_alert_notifications_ms.controllers.NotificationsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CovidAlertNotificationsMsApplicationTests {
	@Autowired
	private NotificationsController notificationsController ;
	@Test
	void contextLoads() throws Exception{
		assertThat(notificationsController).isNotNull();
	}

}
