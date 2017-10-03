package cad.osb.birthdaycountdown.config;

import cad.osb.birthdaycountdown.repositories.UserRepository;
import cad.osb.birthdaycountdown.services.BirthdayService;
import cad.osb.birthdaycountdown.services.UserService;
import cad.osb.birthdaycountdown.services.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    UserService userService(UserRepository repo) {
        return new UserServiceImpl(repo);
    }

    @Bean
    BirthdayService birthdayService() {
        return new BirthdayService();
    }
}
