package cad.osb.birthdaycountdown.config;

import cad.osb.birthdaycountdown.repositories.HerokuUserRepository;
import cad.osb.birthdaycountdown.repositories.InMemUserRepository;
import cad.osb.birthdaycountdown.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class RepositoryConfig {
    @Bean
    UserRepository userRepository() {
        return new HerokuUserRepository();
        //return new InMemUserRepository(new ArrayList<>());
    }
}
