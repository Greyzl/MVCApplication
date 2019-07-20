package javaconfiguration.config;

import javaconfiguration.logic.Provider.ConfigurableMessageProvider;
import javaconfiguration.logic.Provider.MessageProvider;
import javaconfiguration.logic.Renderer.MessageRenderer;
import javaconfiguration.logic.Renderer.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }
}
