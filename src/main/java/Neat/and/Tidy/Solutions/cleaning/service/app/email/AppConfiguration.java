package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Value("${mail_url}")
    private String url;
    @Value("${api_key}")
    private String apiKey;

    @Bean
    public MailConfig mailConfig() {
        return new MailConfig(apiKey, url);
    }
}
